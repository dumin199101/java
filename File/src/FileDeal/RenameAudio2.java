package FileDeal;

import java.io.File;

public class RenameAudio2 {
	
	 public static void main(String[] args) {
		
	      File srcFolder = new File("H:\\资源处理\\宝碗\\audio\\4");
	      
	      
	      rename(srcFolder);
	      
	     
	     
	     
		 
	 }

	private static void rename(File srcFolder) {
		// TODO Auto-generated method stub
		
		File[] fileArr = srcFolder.listFiles();
		
		int x = 97;
		
		for(File file : fileArr){
			
			
//			System.out.println(file.getName());
			
//			1.处理5位6位的名字 001.mp3 010.mp3 -->112.mp3,都变为7位
//			if(file.getName().length()<=6){
//			
//				
//				   
//				    //处理五位：
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
				
				 System.out.println(file.getAbsolutePath() + "文件命名成功");
				 
			}else{
				
				 System.out.println(file.getAbsolutePath() + "文件命名失败");
				
			}
			
			
			
			
			
			
			
			
			
		}
		
		
		
		
		
		
		
		
		
		
		
		
		
	}
	

}
