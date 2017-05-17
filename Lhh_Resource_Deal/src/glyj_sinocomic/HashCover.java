package glyj_sinocomic;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

/**
 * hashɢ�з����ļ�����Ӧ���ļ�����
 * 
 * @author Administrator
 * 
 */

public class HashCover {

	public static void main(String[] args) throws IOException {

		File srcFolder = new File("D:\\������ƽ̨ͼ���������\\Cover");

		File destFolder = new File("D:\\������ƽ̨ͼ���������\\BookCover");

		File referTxt = new File("D:\\������ƽ̨ͼ���������\\BookID_CoverImage_wy.txt");

		

		BufferedReader br = new BufferedReader(new FileReader(referTxt));

		String line = null;

		while ((line = br.readLine()) != null) {

			String[] row = line.split("\\t");

			String bookid = row[0];  //4111

			String coverImageName = row[1];  // /bookimg/20160818/47/3cH3cLGOYnD3B_28123.jpg
			
			String imgPath = coverImageName.substring(9); //20160818/44/E8FsM8H9Sn0lE_94059.jpg
			
			String imgParentPath = new File(imgPath).getParent(); // 20160818\44
			
			
			File parentFolder = new File(destFolder,imgParentPath); //D:\������ƽ̨ͼ���������\BookCover\20160818\30
			
//			System.out.println(parentFolder.getAbsolutePath());
			
			if(!parentFolder.exists()){
				parentFolder.mkdirs();
			}
			
		   //��������һ��/��λ�ã���ȡ��������ǈDƬ���ļ���
 		   int index = coverImageName.lastIndexOf("/");  
 		   
 		   String newName = coverImageName.substring(index+1);  //3cH3cLGOYnD3B_28123.jpg
 		   
 		   File srcFile = new File(srcFolder,bookid+"\\"+newName);
 		   
 		   File destFile = new File(destFolder,imgParentPath+"\\"+newName);
 		   
 		   
// 		   System.out.println(srcFile.getAbsolutePath() + "---" + destFile.getAbsolutePath());
 		   
 		   //�����ƶ���
 		   srcFile.renameTo(destFile);
 		   
 		   System.out.println(srcFile.getAbsolutePath()+":�ƶ����");
 		   
		

		}

		br.close();

	}

	
}
