package FileDeal;

import java.io.File;

public class RenameImg{
	public static void main(String[] args) {
        
		File srcFolder = new File("H:\\Resource_Demo\\勇擒红孩儿\\img");
		
		renameFile(srcFolder);
		
		
		
		
	}

	private static void renameFile(File srcFolder) {
		// TODO Auto-generated method stub
		File[] fileArr = srcFolder.listFiles();
		
		int x = 0;
		
		for(File f : fileArr){
			
			
			
//			if(f.getName().length()==5){
//				
//				  //对于等于5的加0处理：3.jpg
//				  File destFile = new File(srcFolder, "0"+f.getName());
//				  
//				  boolean flag = f.renameTo(destFile);
//				  
//				  if(flag){
//					  
//					  System.out.println(f.getName() + "文件重命名完成第一步");
//					  
//				  }
//				
//				
//				
//				
//			}
			
			
			//如果字符串值小于7位23.jpg加0处理 023.jpg
//			if(f.getName().length()<7){
//				
//				 File destFile = new File(srcFolder, "0"+f.getName());
//				  
//				  boolean flag = f.renameTo(destFile);
//				  
//				  if(flag){
//					  
//					  System.out.println(f.getName() + "文件重命名完成第二步");
//					  
//				  }
//				
//				  
//				
//				
//			}
			
			
			
			
			
			//012.jpg

//		    File destFile1 = new File(srcFolder,"0"+String.valueOf(x)+".jpg");
//		    
//		    x++;
//			
//			boolean  flag = f.renameTo(destFile1);
//			
//			if(flag){
//				
//				System.out.println(f.getName() + "文件重命名完成第三步");
//				
//			}
			
			
			
			//再重命名：01.jpg-->001.jpg
			if(f.getName().length()==6){
				

				
				 File destFile2 = new File(srcFolder,"0"+f.getName());
				 
				 boolean flag2 = f.renameTo(destFile2);
				 
				 if(flag2){
					 
					 System.out.println(f.getName() + "文件重命名完成第四步");
					 
				 }
				 
				
				
				
			}
			

			
			
			
			
			
			
			
		}
		
		
		
	}
	
	
	
}
