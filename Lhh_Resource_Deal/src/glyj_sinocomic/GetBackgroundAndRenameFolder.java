package glyj_sinocomic;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

/**
 * ���ļ��������������Ұ�background.mp3�ƶ����ļ������
 * @author Administrator
 *
 */
public class GetBackgroundAndRenameFolder {
     public static void main(String[] args)  throws IOException{
	      File srcFolder = new File("D:\\������ƽ̨ͼ���������\\HashResource\\Audio\\Resource");
	      
	      File referFile = new File("D:\\������ƽ̨ͼ���������\\ReferTxt.txt");
	      
	      BufferedReader br = new BufferedReader(new FileReader(referFile));
	      
	      //��background.mp3��ȡ������
	      File[] fileArr = srcFolder.listFiles();
	      
	      for(File file : fileArr){
	    	  
	    	   File background = new File(file,"audio/background.mp3");
	    	  
	    	   File newBackground = new File(file,"background.mp3");
	    	   
	    	   if(background.exists()){
	    		   background.renameTo(newBackground);
	    		   System.out.println(newBackground.getAbsolutePath()+"�ļ��ƶ��ɹ�");
	    	   }
	    	   
	    	  
	      }
	      
	      
	      
	      
	      String line = null;
	      
	      while((line = br.readLine()) !=null){
	    	  
	    	  String[] row = line.split("\\t");
	    	  
	    	  String referid = row[0];
	    	  
	    	  String bookid = row[1];
	    	  
	    	  File newSrcFolder = new File(srcFolder,referid);
	    	  
	    	  File newDestFolder = new File(srcFolder,"bak"+bookid);
	    	  
//	    	  System.out.println(newSrcFolder.getAbsolutePath()+"---"+newDestFolder.getAbsolutePath());
	    	  
	    	  if(newSrcFolder.renameTo(newDestFolder)){
	    		  System.out.println(newSrcFolder.getAbsolutePath()+"�ļ����������ɹ�");
	    	  }
	    	  
	      }
	      
	      
	    //ɾ������bak��ͷ���ļ���
	    File[] fileList = srcFolder.listFiles();
	    
	    for(File file :fileList){
	    	
	    	if(!file.getName().startsWith("bak")){
	    		
	    		   deleteFolder(file);
	    		
	    	}
	    	
	    }
	    
	    
	    //��������ǰ�ļ���
	    File[] fileList2 = srcFolder.listFiles();
	    
	    for(File file : fileList2){
	    	 
	    	 File newName = new File(file.getParentFile(),file.getName().substring(3));
	    	 
	    	 file.renameTo(newName);
	    	
	    }
	      
	      

	      
	 }

	private static void deleteFolder(File file) {
		// TODO Auto-generated method stub
		File[] fileArr = file.listFiles();
		
		for(File f : fileArr){
			
            if(f.isDirectory()){
            	deleteFolder(f);
            }else{
            	f.delete();
            }

		}
		
		file.delete();
		
	}

	
}
