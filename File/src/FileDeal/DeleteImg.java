package FileDeal;

/**
 * ɾ�����еĿհ�ͼƬ�ļ��У�
 */

import java.io.File;

public class DeleteImg {
	
	public static void main(String[] args) {
	       
   	 File srcFolder = new File("G:\\Audio\\Book");
   	 
   	 deleteImgOfEmpty(srcFolder);
   	 
   	 
   	 System.out.println("img�ļ���ɾ�����");
   	 
   	 
   	 
   	 
    }

	private static void deleteImgOfEmpty(File srcFolder) {
		// TODO Auto-generated method stub
	    
		if(srcFolder.isDirectory()){
			
			
			File[] fileArr = srcFolder.listFiles();
			
			for(File file : fileArr){
				
				
				if(file.getName().endsWith("img")){
					
					 file.delete();
					 
					 System.out.println(file.getAbsolutePath() + "�ļ���ɾ�����");
					
				}
				
			
				 
				 deleteImgOfEmpty(file);
				 
				
			}
			
			
		        	
			
			
		}
		
		
		
		
	}
	
	
	
	
	
	

}
