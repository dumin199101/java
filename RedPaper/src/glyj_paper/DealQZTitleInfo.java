package glyj_paper;

import java.awt.image.BufferedImage;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.imageio.ImageIO;

/**
 * 提取群众周刊基本图书信息
 * 
 * @author Administrator
 * 
 */
public class DealQZTitleInfo {

	private static String juan = "";
	private static String qi = "";
	public static int index = 219;
	private static String juanID = "";
	private static int qiID = 0;
	private static String qistr = "";
	private static int width,height = 0;

	public static void main(String[] args) {
		File srcFolder = new File("J:\\报刊加工\\群众周刊");
		getBaseInfo(srcFolder);
	}

	private static void getBaseInfo(File srcFolder) {
		// TODO Auto-generated method stub
		File[] fileArr = srcFolder.listFiles();
		String result = "";
		String qiID = "";
		int imgIndex = 0;
		Pattern p = Pattern.compile("第(.+)卷");
		Pattern p2 = Pattern.compile("第(.+)期");

		ArrayList<FileNameSort> imgURList = new ArrayList<FileNameSort>();

		for (File f : fileArr) {
			imgURList.add(new FileNameSort(f.getName())); // 把文件名放入list里面
		}

		Collections.sort(imgURList);

		for (FileNameSort name : imgURList) {
			File f = new File(srcFolder, name.toString());
			if (f.isDirectory()) {
				Matcher m = p.matcher(name.toString());
				while (m.find()) {
					DealQZTitleInfo.juan = m.group();
				}
				Matcher m2 = p2.matcher(f.getName());
				while (m2.find()) {
					DealQZTitleInfo.qi = m2.group();
				}
				if (f.getName().matches("[01]\\d第(.+)卷")) {
					DealQZTitleInfo.juanID = f.getName().substring(0, 2);
				}
				if (!f.getName().matches("[01]\\d第(.+)卷")) {
					DealQZTitleInfo.qiID++;
					if (DealQZTitleInfo.qiID <= 9) {
						DealQZTitleInfo.qistr = "00" + DealQZTitleInfo.qiID;
					} else if(DealQZTitleInfo.qiID >= 10 && DealQZTitleInfo.qiID<=99) {
						DealQZTitleInfo.qistr = "0" + DealQZTitleInfo.qiID;
					}else{
						DealQZTitleInfo.qistr = Integer.toString(DealQZTitleInfo.qiID);
					}
					DealQZTitleInfo.index++;
					if (DealQZTitleInfo.qi.contains("、")) {
						DealQZTitleInfo.qi += "合刊";
					}
					result = index + "\t" + DealQZTitleInfo.juan + "\t" + "QZ"
							+ DealQZTitleInfo.juanID + DealQZTitleInfo.qistr + "\t" + "群众周刊"
							+ DealQZTitleInfo.juan + DealQZTitleInfo.qi+"\t"+DealQZTitleInfo.width+"\t"+DealQZTitleInfo.height+"\t"+f.list().length;
//					System.out.println(result);
					try {
						writeTitleToLog("D:\\群众周刊基本信息.txt", result);
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					System.out.println(f.getName()+"处理完毕");
				}
				getBaseInfo(f);
			}else{
				if(f.getName().equals("Thumbs.db")){
					continue;
				}
//				System.out.println(f.getAbsolutePath());
				imgIndex++;
				//进行文件重命名，生成Guid
				String fname = "";
				String filename =f.getName().substring(0,f.getName().indexOf("."));
				switch (filename.length()) {
				case 1:
					fname = "00" + filename;
					break;
				case 2:
					fname = "0" + filename;
					break;
				default:
					fname = filename;
				}
				
				String guid = "QZ"+ DealQZTitleInfo.juanID + DealQZTitleInfo.qistr +fname+ "\t"+f.getName()+"\t"+imgIndex;
//				System.out.println(guid);
//				try {
//					writeTitleToLog("D:\\群众周刊信息采集.txt", guid);
//				} catch (IOException e) {
//					// TODO Auto-generated catch block
//					e.printStackTrace();
//				}
				
				//重命名文件：
//				File srcFile = new File(srcFolder, f.getName());
//				File destFile = new File(srcFolder,Integer.toString(imgIndex)+".jpg");
//				rename(srcFile, destFile);
				
				//读取图片宽度+高度：
				if(f.getName().equals("1.jpg")){
					//获取图片宽高：
					BufferedImage bufferedImage = null;
					try {
						bufferedImage = ImageIO.read(f);
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}   
					 DealQZTitleInfo.width = bufferedImage.getWidth();   
					 DealQZTitleInfo.height = bufferedImage.getHeight();
				}
			}
		}
	}

	private static void writeTitleToLog(String fileName, String result)
			throws IOException {
		// TODO Auto-generated method stub
		BufferedWriter bw = new BufferedWriter(new FileWriter(fileName, true));
		bw.write(result);
		bw.newLine();
		bw.flush();
		bw.close();
	}
	
	private static void rename(File srcFile, File destFile) {
		// TODO Auto-generated method stub
		if(srcFile.renameTo(destFile)){
			System.out.println(srcFile.getAbsolutePath()+"重命名成功");
		}else{
			System.out.println(srcFile.getAbsolutePath()+"重命名失败");
		}
		
	}
}
