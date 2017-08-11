package FileDeal;

import java.io.File;
import java.io.FilenameFilter;

/**
 * ͨ���ļ���������ɾ��ָ����ʽ���ļ���
 *    
 * @author Administrator
 *
 */

public class FileNameFilterDelete {
    public static void main(String[] args) {
		
    	  File srcFolder = new File("H:\\abc");
    	  
    	  String format = ".mp3";
    	  
    	  //ɾ��ĳ���ļ��������е�.jpg�ļ�
    	  
    	  deleteFile(srcFolder,format);
    	
    	
	}

    
	private static void deleteFile(File srcFolder, String format) {
		
		   final String file_format = format;
		 
	       if(srcFolder.isDirectory()){
	    	        
	    	      //�ݹ�����ļ��У�
	    	      File[] fileArr = srcFolder.listFiles(new FilenameFilter() {
					
					@Override
					public boolean accept(File dir, String name) {
						
						File newFile = new File(dir, name);
						
                       
//						if(newFile.getName().endsWith(file_format)){
//							
//						��System.out.println(newFile.getAbsolutePath());
//							
//						}
						
					
//						return true;
						if(newFile.isFile()){
							return newFile.isFile() && newFile.getName().endsWith(file_format);
						}else{
							deleteFile(newFile,file_format); 
							return true;
						}
						
				
						

						
						
					}
				});   
	    	   
	    	      
	    	    for(File file : fileArr){
	    	    	
	    	    	
	    	    	
	    	    	
	    	    	 deleteFile(file,format); 
	    	    	
	    	    	 
	    	    	
	    	    }  
	    	   
	    	   
	    	   
	       }else{
	    	        //���ļ�ɾ����
	    	         srcFolder.delete();
	    	         
	    	         System.out.println(srcFolder.getAbsolutePath() + "ɾ���ɹ�");
	    	   
	       }    
		
		
		
		
	}
	
	
}
