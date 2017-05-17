package FileDeal;

import java.io.File;
import java.io.FilenameFilter;

/**
 * 通过文件过滤器来删除指定格式的文件：
 *    
 * @author Administrator
 *
 */

public class FileNameFilterDelete {
    public static void main(String[] args) {
		
    	  File srcFolder = new File("H:\\abc");
    	  
    	  String format = ".mp3";
    	  
    	  //删除某个文件夹下所有的.jpg文件
    	  
    	  deleteFile(srcFolder,format);
    	
    	
	}

    
	private static void deleteFile(File srcFolder, String format) {
		
		   final String file_format = format;
		 
	       if(srcFolder.isDirectory()){
	    	        
	    	      //递归遍历文件夹：
	    	      File[] fileArr = srcFolder.listFiles(new FilenameFilter() {
					
					@Override
					public boolean accept(File dir, String name) {
						
						File newFile = new File(dir, name);
						
                       
//						if(newFile.getName().endsWith(file_format)){
//							
//						　System.out.println(newFile.getAbsolutePath());
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
	    	        //做文件删除：
	    	         srcFolder.delete();
	    	         
	    	         System.out.println(srcFolder.getAbsolutePath() + "删除成功");
	    	   
	       }    
		
		
		
		
	}
	
	
}
