package glyj_sinocomic;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

/**
 * hash散列封面文件到对应的文件夹下
 * 
 * @author Administrator
 * 
 */

public class HashCover {

	public static void main(String[] args) throws IOException {

		File srcFolder = new File("D:\\连环画平台图书批量入库\\Cover");

		File destFolder = new File("D:\\连环画平台图书批量入库\\BookCover");

		File referTxt = new File("D:\\连环画平台图书批量入库\\BookID_CoverImage_wy.txt");

		

		BufferedReader br = new BufferedReader(new FileReader(referTxt));

		String line = null;

		while ((line = br.readLine()) != null) {

			String[] row = line.split("\\t");

			String bookid = row[0];  //4111

			String coverImageName = row[1];  // /bookimg/20160818/47/3cH3cLGOYnD3B_28123.jpg
			
			String imgPath = coverImageName.substring(9); //20160818/44/E8FsM8H9Sn0lE_94059.jpg
			
			String imgParentPath = new File(imgPath).getParent(); // 20160818\44
			
			
			File parentFolder = new File(destFolder,imgParentPath); //D:\连环画平台图书批量入库\BookCover\20160818\30
			
//			System.out.println(parentFolder.getAbsolutePath());
			
			if(!parentFolder.exists()){
				parentFolder.mkdirs();
			}
			
		   //查找最後一個/的位置，截取到最後就是圖片的文件名
 		   int index = coverImageName.lastIndexOf("/");  
 		   
 		   String newName = coverImageName.substring(index+1);  //3cH3cLGOYnD3B_28123.jpg
 		   
 		   File srcFile = new File(srcFolder,bookid+"\\"+newName);
 		   
 		   File destFile = new File(destFolder,imgParentPath+"\\"+newName);
 		   
 		   
// 		   System.out.println(srcFile.getAbsolutePath() + "---" + destFile.getAbsolutePath());
 		   
 		   //批量移动：
 		   srcFile.renameTo(destFile);
 		   
 		   System.out.println(srcFile.getAbsolutePath()+":移动完毕");
 		   
		

		}

		br.close();

	}

	
}
