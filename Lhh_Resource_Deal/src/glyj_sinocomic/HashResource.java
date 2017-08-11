package glyj_sinocomic;

import java.io.File;

/**
 * ���ݵ�ǰIDHashɢ����Դ
 * 
 * @author Administrator
 * 
 */
public class HashResource {
	public static void main(String[] args) {
		
          File srcFolder = new File("D:\\������ƽ̨ͼ���������\\HashResource\\Resource");
          
          File destFolder = new File("D:\\������ƽ̨ͼ���������\\HashResource\\Hash\\20160822");
          
          
          hashResource(srcFolder,destFolder);
          
          
          
 	}

	private static void hashResource(File srcFolder, File destFolder) {
		// TODO Auto-generated method stub
		
		File[] fileArr = srcFolder.listFiles();
		
		for(File file : fileArr){
			int bookID = Integer.parseInt(file.getName());
			int parentDir = bookID % 50;
			File newSrcFolder = new File(srcFolder,file.getName());
			File newDestFolder = new File(destFolder,String.valueOf(parentDir)+"\\"+bookID+"\\img");
		    copyFolder(newSrcFolder,newDestFolder);
		}
		
		
		
	}

	private static void copyFolder(File newSrcFolder, File newDestFolder) {
		// TODO Auto-generated method stub
		File[] fileArr = newSrcFolder.listFiles();
		
		if(!newDestFolder.exists()){
			newDestFolder.mkdirs();
		}
		
		for(File file : fileArr){
			
			if(file.getName().endsWith(".jpg") || file.getName().endsWith(".mp3")){
				
				   File srcFile = new File(newSrcFolder,file.getName());
				   File destFile = new File(newDestFolder,file.getName());
				  
//				   System.out.println(destFile);
				   
				   moveFiles(srcFile,destFile);
				   
				   System.out.println(srcFile.getAbsolutePath()+":�ļ��ƶ����");
				
				
			}
			
			
			
			
			
			
		}
		
		
		
	}

	private static void moveFiles(File srcFile, File destFile) {
		// TODO Auto-generated method stub
		srcFile.renameTo(destFile);
		
		
	}
}
