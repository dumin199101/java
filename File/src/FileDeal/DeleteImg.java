package FileDeal;

/**
 * 删除所有的空白图片文件夹：
 */

import java.io.File;

public class DeleteImg {
	
	public static void main(String[] args) {
	       
   	 File srcFolder = new File("G:\\Audio\\Book");
   	 
   	 deleteImgOfEmpty(srcFolder);
   	 
   	 
   	 System.out.println("img文件夹删除完成");
   	 
   	 
   	 
   	 
    }

	private static void deleteImgOfEmpty(File srcFolder) {
		// TODO Auto-generated method stub
	    
		if(srcFolder.isDirectory()){
			
			
			File[] fileArr = srcFolder.listFiles();
			
			for(File file : fileArr){
				
				
				if(file.getName().endsWith("img")){
					
					 file.delete();
					 
					 System.out.println(file.getAbsolutePath() + "文件夹删除完成");
					
				}
				
			
				 
				 deleteImgOfEmpty(file);
				 
				
			}
			
			
		        	
			
			
		}
		
		
		
		
	}
	
	
	
	
	
	

}
