package FileDeal;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class FindWesternRegionAllBook {
     public static void main(String[] args) {
	     
    	 //封装源目录：
    	 File srcFolder = new File("F:\\demo");
    	 
    	 //封装目的地目录：
    	 File destFolder = new File("H:\\");
    	 
    	 try {
			copyFolder(srcFolder,destFolder);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	 
    	 
	 }

	private static void copyFolder(File srcFolder, File destFolder) throws IOException{
		
		
		
		// TODO Auto-generated method stub
		if(srcFolder.isDirectory()){
			 //如果是文件夹：
			 
			 //在目的地目录复制文件夹：
			File newFolder = new File(destFolder,srcFolder.getName());
			
			newFolder.mkdir();
			
			//遍历文件夹：
			File[] fileArr = srcFolder.listFiles();
			
			for(File file : fileArr){
				
				
				   	  
				
					  copyFolder(file, newFolder);
					  
					  System.out.println(newFolder.getAbsolutePath() + ":文件夹复制成功");
					 
				 
				
				 
				
				
			}
			
			
				
			
			
		}else{
			//如果是文件：直接做文件复制：
			File newFile = new File(destFolder,srcFolder.getName());
			
			
			
			copyFile(srcFolder,newFile);
			
			
			
			
		}
		
		
	}

	private static void copyFile(File srcFolder, File newFile) throws IOException{
		// TODO Auto-generated method stub
		BufferedInputStream bis = new BufferedInputStream(new FileInputStream(srcFolder));
		
		BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(newFile));
		
		byte[] bys = new byte[1024];
		
		int len = 0;
		
		while((len = bis.read(bys)) != -1){
			
			
			bos.write(bys,0,len);
			
			
		}
		
		
		bos.close();
		bis.close();
		
		System.out.println(newFile.getAbsolutePath() + ":文件复制成功");
		
		
		
		
		
		
		
	}
}
