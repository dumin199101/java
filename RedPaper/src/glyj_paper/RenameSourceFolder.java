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
 * 重命名文件夹
 * @author Administrator
 *
 */
public class RenameSourceFolder {
	
	private static String juanID = "";
	private static int qiID = 0;
	private static String qistr = "";
	
     public static void main(String[] args) {
//    	 File srcFolder = new File("J:\\报刊加工\\BL");
    	 //renameBLFolder(srcFolder);	
    	 File srcFolder = new File("J:\\报刊加工\\QZ");
//    	 File srcFolder = new File("D:\\新华日报\\3");
    	 renameQZFolder(srcFolder);
    	 
	 }

	private static void renameQZFolder(File srcFolder) {
		// TODO Auto-generated method stub
		File[] fileArr = srcFolder.listFiles();
		
		String result = "";

		ArrayList<FileNameSort> imgURList = new ArrayList<FileNameSort>();

		for (File f : fileArr) {
			imgURList.add(new FileNameSort(f.getName())); // 把文件名放入list里面
		}

		Collections.sort(imgURList);
		
		for (FileNameSort name : imgURList) {
			
			File f = new File(srcFolder, name.toString());
			
			if (f.isDirectory()) {
				
				if (f.getName().matches("[01]\\d第(.+)卷")) {
					RenameSourceFolder.juanID = f.getName().substring(0, 2);
					File srcFile = new File(srcFolder, f.getName());
					File destFile = new File(srcFolder,RenameSourceFolder.juanID);
					rename(srcFile, destFile);
					renameQZFolder(destFile);
//					System.out.println(f.getName()+"---"+RenameSourceFolder.juanID);
				}
				
				if (!f.getName().matches("[01]\\d第(.+)卷")) {
					String publishDate = "";
					publishDate = f.getName().substring(f.getName().lastIndexOf('-')+1).replaceAll("\\.", "-");
					
					RenameSourceFolder.qiID++;
					if (RenameSourceFolder.qiID <= 9) {
						RenameSourceFolder.qistr = "00" + RenameSourceFolder.qiID;
					} else if(RenameSourceFolder.qiID >= 10 && RenameSourceFolder.qiID<=99) {
						RenameSourceFolder.qistr = "0" + RenameSourceFolder.qiID;
					}else{
						RenameSourceFolder.qistr = Integer.toString(RenameSourceFolder.qiID);
					}
	
					
//					result = "QZ" + RenameSourceFolder.juanID + RenameSourceFolder.qistr + "\t" + publishDate;
//					System.out.println(result);
//					try {
//						writeTitleToLog("D:\\群众周刊日期信息.txt", result);
//					} catch (IOException e) {
//						// TODO Auto-generated catch block
//						e.printStackTrace();
//					}
					
					File srcFile = new File(srcFolder, f.getName());
					File destFile = new File(srcFolder,RenameSourceFolder.qistr);
					rename(srcFile, destFile);
					renameQZFolder(destFile);
//					System.out.println(f.getName()+"---"+RenameSourceFolder.qistr);
					
//					System.out.println(f.getName()+"处理完毕");
				}
				
			}
		}
		
	}

	private static void renameBLFolder(File srcFolder) {
		// TODO Auto-generated method stub
		File[] fileArr = srcFolder.listFiles();
		if(fileArr!=null){
			for(File file : fileArr){
				if(file.isDirectory()){
					 String newName = file.getName().substring(1,3);
					 File srcFile = new File(srcFolder, file.getName());
					 File destFile = new File(srcFolder,newName);
//					 System.out.println(file.getName()+"-----"+newName);
					 rename(srcFile, destFile);
					 renameBLFolder(destFile);
				}
			}
		}
		
	}
	
	private static void rename(File srcFile, File destFile) {
		// TODO Auto-generated method stub
		if(srcFile.renameTo(destFile)){
			System.out.println(srcFile.getAbsolutePath()+"重命名成功");
		}else{
			System.out.println(srcFile.getAbsolutePath()+"重命名失败");
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
	
}
