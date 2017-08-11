package glyj_mpr;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * 连环画数字图书馆资源加工处理：
 * 1.复制待处理资源到处理目录
 * 
 * 
 * @author Administrator
 *
 */
public class Mpr {
	
	public static void main(String[] args) {
		
		//封装资源原始目录：
		File srcFolder = new File("E:\\连环画新增资源处理\\Book");
		
		
		//封装目的地目录:
		File destFolder = new File("E:\\Demo");
		
		
		if(!destFolder.exists()){
			
			destFolder.mkdir();
			
		}
		
		
		//1.复制待处理资源到处理目录
		try {
			copyFolder(srcFolder,destFolder);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		
		
		System.out.println("Procedure Running Over");
		
		
		
		
		
		
		
		
		
	}

	private static void copyFolder(File srcFolder, File destFolder) throws IOException{
		// TODO Auto-generated method stub
		File[] fileArr = srcFolder.listFiles();
		
		//创建目的地目录：
		File newFolder = new File(destFolder,srcFolder.getName());
		
		newFolder.mkdir();
		
		for(File file : fileArr){
			
			 if(file.isDirectory()){
				 
				  copyFolder(file, newFolder);
				  
				 
			 }else{
				 
				 
				//进行文件复制：
			    File newFile = new File(newFolder,file.getName());
			    
				 copyFile(file,newFile);
				 
				 
			 }
			
			
			
		}
		
		
	}

	private static void copyFile(File file, File newFile) throws IOException{
		// TODO Auto-generated method stub
		BufferedInputStream bis = new BufferedInputStream(new FileInputStream(file));
		
		BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(newFile));
		
		int len = 0;
		
		byte[] bys = new byte[1024];
		
		while((len = bis.read(bys)) != -1){
			
			bos.write(bys, 0, len);
			
		}
		
		bis.close();
		
		bos.close();
		
		System.out.println(newFile.getAbsolutePath()+"文件复制完成");
		
	}

}
