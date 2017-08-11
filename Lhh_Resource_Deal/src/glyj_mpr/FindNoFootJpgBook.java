package glyj_mpr;

import java.io.File;
import java.io.IOException;

/**
 * 6.���������з�׵�ͼ�飺
 * 
 * @author Administrator
 * 
 */
public class FindNoFootJpgBook {

	public static void main(String[] args) {
		File srcFolder = new File("E:\\������������Դ����\\Book");
		try {
			findNotFootJpgBook(srcFolder);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	private static void findNotFootJpgBook(File srcFolder) throws IOException {

		File[] fileArr = srcFolder.listFiles();

		for (File file : fileArr) {

			if (file.isDirectory()) {
				
				if(file.getName().endsWith("audio")){
					
					continue;
					
				}
				
				if(file.getName().contains("img")){
					
					 File[] imgList = file.listFiles();
					 
					 if(!(imgList[imgList.length-1].getName().equals("foot.jpg"))){
						 
						 System.out.println(file.getParent()+"---"+imgList[imgList.length-1].getName());
						 
					 }
					 
				}
				
				findNotFootJpgBook(file); 

			}  
		}

	}

}
