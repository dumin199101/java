package FileDeal;

import java.io.File;
import java.io.IOException;

public class RenameAudio {
	
	 public static void main(String[] args) throws IOException{
		
	       File srcFolder =  new File("H:\\资源处理");
	       
	       rename(srcFolder);
	       
	       
		 
	 
	 
	 }
	 
	 

	private static void rename(File srcFolder) {
		// TODO Auto-generated method stub
		
		
		 if(srcFolder.isDirectory()){
			 
			   //srcFolder是文件夹递归处理
			   File[] fileArr = srcFolder.listFiles();
			   
			   for(File file : fileArr){
				   
				      
				      //对音频文件夹做递归处理
				      if(file.getName().endsWith("audio")){
				    	  
				    	   renameFile(file);
				    	  
				    	  
				    	  
				      }
				   
				        
				      rename(file);
				   
				   
			   }
			 
			   
			  
			 
			 
			 
		 }
		
		
		
		
		
		
		
		

		
		
	}



	private static void renameFile(File srcFolder) {
		// TODO Auto-generated method stub
		
		
		
		File[] fileArr = srcFolder.listFiles();
		
		int x = 0;
		
		for(File file : fileArr){
			
			//1-1 在1的前面
//			System.out.println(file.getAbsolutePath());

			//1.处理5位6位的名字 001.mp3 010.mp3 -->112.mp3,都变为7位
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
			
			
			
			
			//处理带-线的
//			if(file.getName().contains("-")){
//			
//				   if(file.getName().length()==7){
//					   
//					   String[] fileNameArr = file.getName().split("-");
//					   
//					   File newFile = new File(srcFolder,"00" + fileNameArr[0].concat(".mp3.mp3"));
//					   
//				   file.renameTo(newFile);
//					   
//				   }else if(file.getName().length()==8){
//					   
//                       String[] fileNameArr = file.getName().split("-");
//					   
//					   File newFile = new File(srcFolder,"0" + fileNameArr[0].concat(".mp3.mp3"));
//					   
//					   file.renameTo(newFile);
//					   
//					   
//				   }else if(file.getName().length()==9){
//			
//			          String[] fileNameArr = file.getName().split("-");
//					   
//                      File newFile = new File(srcFolder,fileNameArr[0].concat(".mp3.").concat(fileNameArr[1]).concat(".mp3"));
//					   
//					   file.renameTo(newFile);
//					   
//					   
//				   }
//				
//			}
			
			
			//防止重命名100以上的失败：
//			if(file.getName().endsWith(".mp3")){
//				
//				
//				
//				File newFile = new File(srcFolder,"bak"+file.getName());
//				
//				file.renameTo(newFile);
//				
//				
//			}
			
			
			
			
			
			
			
			
//			File dest = new File(srcFolder,String.valueOf(x)+".mp3");
//			
//			x = x+1;
//			
//			boolean flag = file.renameTo(dest);
//			
//			
//			if(flag){
//				
//				 System.out.println(file.getAbsolutePath() + "文件命名成功");
//				 
//			}else{
//				
//				 System.out.println(file.getAbsolutePath() + "文件命名失败");
//				
//			}
			
			
	
			
		}
		
		
//		System.out.println( srcFolder.getName() + ",第1步处理完成");
//		System.out.println(srcFolder.getName()+ ",第2步处理完成");
//		System.out.println(srcFolder.getName() + "第3步处理完成");
//		System.out.println(srcFolder.getName() + "第4步处理完成");
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	}

}
