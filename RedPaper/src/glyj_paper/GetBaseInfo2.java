package glyj_paper;

import java.awt.image.BufferedImage;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import javax.imageio.ImageIO;

/*
 * 提取图书的基本信息：
 *   1.图书名
 *   2.图片数
 *   3.图片的宽度、高度
 */
public class GetBaseInfo2 {
	public static int index = 180;

	public static void main(String[] args) {
		File srcFolder = new File("J:\\报刊加工\\八路军军政杂志");
		getBaseInfo(srcFolder);
		System.out.println(srcFolder.getName() + "基本信息提取完毕");
	}

	private static void getBaseInfo(File srcFolder) {
		File[] fileList = srcFolder.listFiles();
		int fileCount = 0;
		int width = 0;
		int height = 0;
		
		for (File file : fileList) {
			if (file.isDirectory()) {
				// 递归遍历：
				getBaseInfo(file);
			} else {
				// 文件搜寻：
				if (file.getName().equals("1.jpg")) {
					// 获取图片宽高：
					BufferedImage bufferedImage = null;
					try {
						bufferedImage = ImageIO.read(file);
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					width = bufferedImage.getWidth();
					height = bufferedImage.getHeight();
				}
				fileCount++;
			}
		}
		

		if (srcFolder.getName().length() > 4 && !srcFolder.getName().equals("八路军军政杂志")) {
				GetBaseInfo2.index++;
				int position = srcFolder.getAbsolutePath().lastIndexOf("八路军军政杂志");
				int endposition = srcFolder.getAbsolutePath().lastIndexOf("期");
				String filename = srcFolder.getAbsolutePath().substring(position,endposition+1).replace("\\","");
				String dateInfo = srcFolder.getAbsolutePath().substring(endposition+1).replace("\\","");
				String date[] = dateInfo.split("\\.");
				String year = date[0];
				String month = date[1];
				String day = date[2];
				
				if(month.length()<2){
					month = "0"+month;
				}
				
				if(day.length()<2){
					day = "0" + day;
				}
				
				String publish_time = year +"-" + month + "-" +day;
				
				String hash = "BL" +  filename.substring(8,10) + filename.substring(12,14);
				
				String result = GetBaseInfo2.index+"\t"+year+"\t"+hash+"\t"+filename+"\t"+"\t"+width+"\t"+height+"\t"+fileCount+"\t"+publish_time;
				
				 try {
				 writeInfoLog("D:\\八路军军政基本信息.txt",result);
				 } catch (IOException e) {
				 // TODO Auto-generated catch block
				 e.printStackTrace();
				 }
//				System.out.println(GetBaseInfo2.index+"\t"+year+"\t"+hash+"\t"+filename+"\t"+"\t"+width+"\t"+height+"\t"+fileCount+"\t"+publish_time);
				System.out.println(srcFolder.getName() + "提取完毕");
		}
	}

	private static void writeInfoLog(String string, String result)
			throws IOException {
		// TODO Auto-generated method stub
		BufferedWriter bw = new BufferedWriter(new FileWriter(new File(string),
				true));
		bw.write(result);
		bw.newLine();
		bw.flush();
		bw.close();
	}

}
