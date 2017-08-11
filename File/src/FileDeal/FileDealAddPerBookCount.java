package FileDeal;

import java.io.File;
import java.io.FilenameFilter;

/**
 * 查询每本书的图片文件页数是否都是偶数页，如果是奇数页打印：
 * @author Administrator
 *
 */
public class FileDealAddPerBookCount {
	
	public static void main(String[] args) {
		
		 File srcFolder = new File("J:\\电脑上的\\mpr\\革命战争系列");
		 
		 
		 printBookNameCountOdd(srcFolder);
		
		
		
		
		
	}

	private static void printBookNameCountOdd(File srcFolder) {
		// TODO Auto-generated method stub
		
		File[] fileArr = srcFolder.listFiles();
		
		
	
		
		if(srcFolder.getName().contains("img")){
			
			 
		
			 System.out.println(srcFolder.getAbsolutePath() + "中文件的个数：" + fileArr.length);
		
		}
		
		
		for(File file : fileArr){
			

			 if(file.isDirectory()){
				  
				  
				 
				 
				  //如果是文件夹
				  printBookNameCountOdd(file);
				 
				 
			 }else{
				 
				//如果是文件：
				 
				 
				 
				
				 
				 
				 
				 
				 
				 
			 }
			
			
		}
		
		
//		if(srcFolder.isDirectory()){
//			
//			   File[] fileArr = srcFolder.listFiles(new FilenameFilter() {
//				
//				@Override
//				public boolean accept(File dir, String name) {
//					
//					  File newFile = new File(dir,name);
//					  
//
//				  
//					  
//					  if(newFile.isDirectory()){
//						  
//						  return false;
//						  
//					  }else{
//						  
//						  return newFile.getName().contains(".jpg");
//						  
//					  }
//					  
//					  
//					
//					  
//					
//					
//				}
//			});
//			   
//			   if(srcFolder.getName().contains("img")){
//					
//					 System.out.println(srcFolder.getAbsolutePath() + "中文件的个数：" + fileArr.length);
//				
//				}
//			   
//			   
//			 for(File file : fileArr){
//				 
//				   if(file.isDirectory()){
//					    
//					   
//					    printBookNameCountOdd(file);
//					   
//					   
//				   }else{
//					   
//					   
//					   
//					   
//				   }
//				 
//				 
//			 }  
//			   
//			
//			
//			
//		}else{
//			
//			
//			
//			
//			
//		}
		
//		
//		File[] fileArr = srcFolder.listFiles(new FilenameFilter() {
//			
//			@Override
//			public boolean accept(File dir, String name) {
//				
//				  File file = new File(dir,name);
//				  
//				  
//				  return file.getName().endsWith(".jpg");
//				
//				
//				
//			}
//		});
//		
		
		
//		for(File file : fileArr){
//			
//			System.out.println(file.getName());
//			
//			
//		}
		
//		System.out.println(fileArr.length);
		
		
		
		
		
		
		
		
		
		
	}
	

}
