package FileDeal;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * 查找所有MPR文件夹中的图片资源：每个MPR文件夹中有audio文件夹跟img文件夹：
 * @author Administrator
 *
 */
public class FindMprJpeg {
	
	public static void main(String[] args) {
          
		File srcFolder = new File("E:\\wamp\\www\\test\\product_update\\lhhupdate\\Public\\Mpr\\Book");
//		File srcFolder = new File("H:\\HSK");
		
		File destFolder = new File("H:\\Mpr");
		
		destFolder.mkdir();
		
		long start_time = System.currentTimeMillis();
		
		try {
			copyFolder(srcFolder,destFolder);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		long end_time = System.currentTimeMillis();
		
		long seconds = (end_time - start_time) / 1000;
		
		System.out.println("文件复制完成,共耗时" + seconds + "s");
		
		
	      	
	
	
	}

	private static void copyFolder(File srcFolder, File destFolder)  throws IOException{
		// TODO Auto-generated method stub
		
		if(srcFolder.isDirectory()){
			
			  File destDir = new File(destFolder, srcFolder.getName());
			  
			  destDir.mkdir();
			  
			  File[] fileArr = srcFolder.listFiles();
			  
			  
			  
			  
			for(File file : fileArr){
				
				 
			    
			    
			  
				
			    copyFolder(file, destDir);  
				
				 
//				 System.out.println(file.getAbsolutePath() + "文件夹下的图片复制完成");
				
				
			}
			
		    
			  
			 
			
			
		}else{
			
			//如果是图片文件我才复制：
			if(srcFolder.getName().endsWith("jpg")){
				
				File newFile = new File(destFolder,srcFolder.getName());
				
				copyFile(srcFolder,newFile);
				
				System.out.println(newFile.getAbsolutePath() + "图片文件复制完成");
				
				
			}
			
			
			
			
			
			
			
			
		}
		
		
		
		
	}

	private static void copyFile(File srcFolder, File newFile) throws IOException{
		// TODO Auto-generated method stub
		BufferedInputStream bis = new BufferedInputStream(new FileInputStream(srcFolder));
		
		BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(newFile));
		
		byte[] bys = new byte[1024];
		
		int len = 0;
		
		while((len = bis.read(bys)) != -1){
			
			bos.write(bys, 0, len);
			
		}
		
		bos.close();
		
		bis.close();
		
		
		
	}

	
}
