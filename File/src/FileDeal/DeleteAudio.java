package FileDeal;

import java.io.File;

/**
 * ɾ�����е�audio���ļ��У�
 * @author Administrator
 *
 */
public class DeleteAudio {
     public static void main(String[] args) {
       
    	 File srcFolder = new File("H:\\Resource\\�Ĵ�����ϵ��");
    	 
    	 deleteAudioOfEmpty(srcFolder);
    	 
    	 
    	 System.out.println("audio�ļ���ɾ�����");
    	 
    	 
    	 
    	 
     }

	private static void deleteAudioOfEmpty(File srcFolder) {
		// TODO Auto-generated method stub
	    
		if(srcFolder.isDirectory()){
			
			
			File[] fileArr = srcFolder.listFiles();
			
			for(File file : fileArr){
				
				
				if(file.getName().endsWith("audio")){
					
					 file.delete();
					 
					 System.out.println(file.getAbsolutePath() + "�ļ���ɾ�����");
					
				}
				
			
				 
				 deleteAudioOfEmpty(file);
				 
				
			}
			
			
		        	
			
			
		}
		
		
		
		
	}
	
}
