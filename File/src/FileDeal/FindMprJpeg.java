package FileDeal;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * ��������MPR�ļ����е�ͼƬ��Դ��ÿ��MPR�ļ�������audio�ļ��и�img�ļ��У�
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
		
		System.out.println("�ļ��������,����ʱ" + seconds + "s");
		
		
	      	
	
	
	}

	private static void copyFolder(File srcFolder, File destFolder)  throws IOException{
		// TODO Auto-generated method stub
		
		if(srcFolder.isDirectory()){
			
			  File destDir = new File(destFolder, srcFolder.getName());
			  
			  destDir.mkdir();
			  
			  File[] fileArr = srcFolder.listFiles();
			  
			  
			  
			  
			for(File file : fileArr){
				
				 
			    
			    
			  
				
			    copyFolder(file, destDir);  
				
				 
//				 System.out.println(file.getAbsolutePath() + "�ļ����µ�ͼƬ�������");
				
				
			}
			
		    
			  
			 
			
			
		}else{
			
			//�����ͼƬ�ļ��ҲŸ��ƣ�
			if(srcFolder.getName().endsWith("jpg")){
				
				File newFile = new File(destFolder,srcFolder.getName());
				
				copyFile(srcFolder,newFile);
				
				System.out.println(newFile.getAbsolutePath() + "ͼƬ�ļ��������");
				
				
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
