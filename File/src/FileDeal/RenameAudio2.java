package FileDeal;

import java.io.File;

public class RenameAudio2 {
	
	 public static void main(String[] args) {
		
	      File srcFolder = new File("H:\\��Դ����\\����\\audio\\4");
	      
	      
	      rename(srcFolder);
	      
	     
	     
	     
		 
	 }

	private static void rename(File srcFolder) {
		// TODO Auto-generated method stub
		
		File[] fileArr = srcFolder.listFiles();
		
		int x = 97;
		
		for(File file : fileArr){
			
			
//			System.out.println(file.getName());
			
//			1.����5λ6λ������ 001.mp3 010.mp3 -->112.mp3,����Ϊ7λ
//			if(file.getName().length()<=6){
//			
//				
//				   
//				    //������λ��
//				    if(file.getName().length()==5){
//				    	
//			    	 File newName = new File(srcFolder,"00"+file.getName());
//				    	 
//				    	 file.renameTo(newName);
//			    	
//				    	 
//				    	
//			    }else if(file.getName().length()==6){
//			    	
//				    	
//				    	File newName = new File(srcFolder,"0"+file.getName());
//				    	
//				    	file.renameTo(newName);
//				    	
//				    	
//			    	
//				    }
//				    
//				    
//				  
//			
//			}
			
			
			File dest = new File(srcFolder,String.valueOf(x)+".mp3");
			
			x = x+1;
			
			boolean flag = file.renameTo(dest);
			
			
			if(flag){
				
				 System.out.println(file.getAbsolutePath() + "�ļ������ɹ�");
				 
			}else{
				
				 System.out.println(file.getAbsolutePath() + "�ļ�����ʧ��");
				
			}
			
			
			
			
			
			
			
			
			
		}
		
		
		
		
		
		
		
		
		
		
		
		
		
	}
	

}
