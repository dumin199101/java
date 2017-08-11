package FileDeal;

import java.io.File;

public class GetSize {
     public static void main(String[] args) {
	      
    	  File srcFolder = new File("H:\\adobeAcrocat");
    	 
    	  double size = getSize(srcFolder);
    	  
    	  System.out.println(Math.round(size)+"MB");
    	  
	 }

	private static double getSize(File srcFolder) {
		// TODO Auto-generated method stub
		
		if(srcFolder.isDirectory()){
			
			double size = 0.0;
			
			 //如果是文件夹：
			File[] fileArr = srcFolder.listFiles();
			
			for(File file : fileArr){
				
				  size += getSize(file);
				
			}
			
			return size;
			
			
			
		}else{
			
			//如果是文件：
			double ss = (double) srcFolder.length() / 1024 / 1024;  
//            System.out.println(srcFolder.getName() + " : " + ss + "MB");  
            return ss;  
			
			
		}
		
	}
     
     
     
}
