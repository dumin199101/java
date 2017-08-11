package FileDeal;

import java.io.File;

/**
 * 删除所有的audio空文件夹：
 * @author Administrator
 *
 */
public class DeleteAudio {
     public static void main(String[] args) {
       
    	 File srcFolder = new File("H:\\Resource\\四大名著系列");
    	 
    	 deleteAudioOfEmpty(srcFolder);
    	 
    	 
    	 System.out.println("audio文件夹删除完成");
    	 
    	 
    	 
    	 
     }

	private static void deleteAudioOfEmpty(File srcFolder) {
		// TODO Auto-generated method stub
	    
		if(srcFolder.isDirectory()){
			
			
			File[] fileArr = srcFolder.listFiles();
			
			for(File file : fileArr){
				
				
				if(file.getName().endsWith("audio")){
					
					 file.delete();
					 
					 System.out.println(file.getAbsolutePath() + "文件夹删除完成");
					
				}
				
			
				 
				 deleteAudioOfEmpty(file);
				 
				
			}
			
			
		        	
			
			
		}
		
		
		
		
	}
	
}
