package Digui;

import java.io.File;

public class DiguiDemo1 {


	public static void main(String[] args) {
		 File f = new File("E:\\wamp\\www\\test\\product_update\\prc\\Resource\\Prc_ImgSrc");
		 
		 //FindFileEndWithphp(f);
		 
		 FindFileEndWithJpg(f);
		 
	}

	private static void FindFileEndWithphp(File SrcFolder) {
		
		 File[] fileArr = SrcFolder.listFiles();
		 
		 for(File f : fileArr){
			 
			 if(f.isDirectory()){
				 
				 FindFileEndWithphp(f);
				 
			 }else{
				 
				 if(f.getName().endsWith(".php")){
					 
					 System.out.println(f.getAbsolutePath());
					 
				 }
				 
			 }
			 
		 }
		
	}
	
	
	private static void FindFileEndWithJpg(File SrcFolder){
		
		File[] fileArr = SrcFolder.listFiles();
		
		if(fileArr != null){
			
			for(File file : fileArr){
				
				if(file.isDirectory()){
					
					FindFileEndWithJpg(file);
					
				}else{
					
					
					if(!(file.getName().endsWith("_thumb.jpg"))){
						System.out.println("不以_thumb.jpg结尾的文件："+ file.getName());
					}
					
					
					
				}
				
			}
			
			
		}
		
		
		
		
		
	}
	

	
	
}
