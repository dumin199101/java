package FileDeal;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class FindWesternRegionAllBook {
     public static void main(String[] args) {
	     
    	 //��װԴĿ¼��
    	 File srcFolder = new File("F:\\demo");
    	 
    	 //��װĿ�ĵ�Ŀ¼��
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
			 //������ļ��У�
			 
			 //��Ŀ�ĵ�Ŀ¼�����ļ��У�
			File newFolder = new File(destFolder,srcFolder.getName());
			
			newFolder.mkdir();
			
			//�����ļ��У�
			File[] fileArr = srcFolder.listFiles();
			
			for(File file : fileArr){
				
				
				   	  
				
					  copyFolder(file, newFolder);
					  
					  System.out.println(newFolder.getAbsolutePath() + ":�ļ��и��Ƴɹ�");
					 
				 
				
				 
				
				
			}
			
			
				
			
			
		}else{
			//������ļ���ֱ�����ļ����ƣ�
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
		
		System.out.println(newFile.getAbsolutePath() + ":�ļ����Ƴɹ�");
		
		
		
		
		
		
		
	}
}
