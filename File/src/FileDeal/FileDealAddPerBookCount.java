package FileDeal;

import java.io.File;
import java.io.FilenameFilter;

/**
 * ��ѯÿ�����ͼƬ�ļ�ҳ���Ƿ���ż��ҳ�����������ҳ��ӡ��
 * @author Administrator
 *
 */
public class FileDealAddPerBookCount {
	
	public static void main(String[] args) {
		
		 File srcFolder = new File("J:\\�����ϵ�\\mpr\\����ս��ϵ��");
		 
		 
		 printBookNameCountOdd(srcFolder);
		
		
		
		
		
	}

	private static void printBookNameCountOdd(File srcFolder) {
		// TODO Auto-generated method stub
		
		File[] fileArr = srcFolder.listFiles();
		
		
	
		
		if(srcFolder.getName().contains("img")){
			
			 
		
			 System.out.println(srcFolder.getAbsolutePath() + "���ļ��ĸ�����" + fileArr.length);
		
		}
		
		
		for(File file : fileArr){
			

			 if(file.isDirectory()){
				  
				  
				 
				 
				  //������ļ���
				  printBookNameCountOdd(file);
				 
				 
			 }else{
				 
				//������ļ���
				 
				 
				 
				
				 
				 
				 
				 
				 
				 
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
//					 System.out.println(srcFolder.getAbsolutePath() + "���ļ��ĸ�����" + fileArr.length);
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
