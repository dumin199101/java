package glyj_mpr;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * 从提取好的资源中复制一份图片出来，为加密做准备：
 * @author Administrator
 *
 */
public class GetAllBookIMG {
	public static void main(String[] args) {
		
		
		File srcFolder = new File("E:\\连环画新增资源处理\\Book\\MPR_CN");
		
		File destFolder = new File("E:\\newMPR_CN_147");
		
		if(!destFolder.exists()){
			
			destFolder.mkdir();
			
		}
		
		try {
			copyFolder(srcFolder,destFolder);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}

	private static void copyFolder(File srcFolder, File destFolder) throws IOException{
		// TODO Auto-generated method stub
		File[] fileArr = srcFolder.listFiles();
		
		File newFolder = new File(destFolder,srcFolder.getName());
		
		newFolder.mkdir();
		
		for(File file : fileArr){
			
			if(file.isDirectory()){
				
				
				if(file.getName().equals("audio")){
					
					continue;
					
				}
				
				
				
				
				
				copyFolder(file, newFolder);
				
				
			}else{
				
				File newFile = new File(newFolder,file.getName());
				
				copyFile(file,newFile);
				
				System.out.println(file.getAbsolutePath()+"文件复制完成");
				
				
			}
			
			
		}
		
	}

	private static void copyFile(File file, File newFile) throws IOException{
		// TODO Auto-generated method stub
		BufferedInputStream bis = new BufferedInputStream(new FileInputStream(file));
		
		BufferedOutputStream bos = new  BufferedOutputStream(new FileOutputStream(newFile));
		
		int len = 0;
		
	    byte[] bys = new byte[1024];
	    
	    while((len = bis.read(bys))!=-1){
	    	
	    	bos.write(bys, 0, len);
	    	
	    }
		
	    
	    bis.close();
	    
	    bos.close();
		
		
		
	}

}
