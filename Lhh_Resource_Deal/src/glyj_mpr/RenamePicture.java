package glyj_mpr;

import java.io.File;

/**
 * 图片重命名：
 * 
 * @author Administrator
 * 
 */
public class RenamePicture {
	public static void main(String[] args) {

		File srcFolder = new File("E:\\连环画新增资源处理\\Book\\需处理图书");

//		find1Jpg(srcFolder);
		
		renameJpg(srcFolder);
		
		System.out.println("Procedure End");

	}

	private static void renameJpg(File srcFolder) {
		// TODO Auto-generated method stub
	    File[] fileArr = srcFolder.listFiles();
	    
	    int x = 1;
	    
	    for(File file : fileArr){
	    	
	    	if(file.isDirectory()){
	    		
	    		if(file.getName().equals("audio")){
	    			
	    			continue;
	    			
	    		}
	    		
	    		renameJpg(file);
	    		
	    	}else{
	    		
	    		
//	    		System.out.println(file.getAbsolutePath());
//	    		System.out.println(file.getName());
	    		
	    		
	    		
	    		File dest = new File(srcFolder, String.valueOf(x) + ".jpg");
	    		
//	    		System.out.println(dest.getName());
	    		
	    		if(file.renameTo(dest)){
	    			
	    			System.out.println(file.getName()+"文件重命名成功");
	    			
	    		}else{
	    			
	    			System.out.println(file.getName()+"【文件重命名失败】");
	    			
	    		}
	    		
	    		
	    		
	    		x++;
	    		
	    		
	    	}
	    	
	    	
	    }
		
		
	}

	private static void find1Jpg(File srcFolder) {
		// TODO Auto-generated method stub
		File[] fileArr = srcFolder.listFiles();

		for (File file : fileArr) {
			
			if(file.isDirectory()){
			    
			
				find1Jpg(file);
				
			}else{
				
				if(file.getName().equals("1.jpg")){
					
					System.out.println(file.getParent());
					
				}
				
				
			}

		}

	}
}
