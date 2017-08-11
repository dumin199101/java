package glyj_sinocomic;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

/**
 * 把文件夹重命名，并且把background.mp3移动到文件夹外边
 * @author Administrator
 *
 */
public class GetBackgroundAndRenameFolder {
     public static void main(String[] args)  throws IOException{
	      File srcFolder = new File("D:\\连环画平台图书批量入库\\HashResource\\Audio\\Resource");
	      
	      File referFile = new File("D:\\连环画平台图书批量入库\\ReferTxt.txt");
	      
	      BufferedReader br = new BufferedReader(new FileReader(referFile));
	      
	      //把background.mp3提取出来：
	      File[] fileArr = srcFolder.listFiles();
	      
	      for(File file : fileArr){
	    	  
	    	   File background = new File(file,"audio/background.mp3");
	    	  
	    	   File newBackground = new File(file,"background.mp3");
	    	   
	    	   if(background.exists()){
	    		   background.renameTo(newBackground);
	    		   System.out.println(newBackground.getAbsolutePath()+"文件移动成功");
	    	   }
	    	   
	    	  
	      }
	      
	      
	      
	      
	      String line = null;
	      
	      while((line = br.readLine()) !=null){
	    	  
	    	  String[] row = line.split("\\t");
	    	  
	    	  String referid = row[0];
	    	  
	    	  String bookid = row[1];
	    	  
	    	  File newSrcFolder = new File(srcFolder,referid);
	    	  
	    	  File newDestFolder = new File(srcFolder,"bak"+bookid);
	    	  
//	    	  System.out.println(newSrcFolder.getAbsolutePath()+"---"+newDestFolder.getAbsolutePath());
	    	  
	    	  if(newSrcFolder.renameTo(newDestFolder)){
	    		  System.out.println(newSrcFolder.getAbsolutePath()+"文件夹重命名成功");
	    	  }
	    	  
	      }
	      
	      
	    //删除不以bak开头的文件夹
	    File[] fileList = srcFolder.listFiles();
	    
	    for(File file :fileList){
	    	
	    	if(!file.getName().startsWith("bak")){
	    		
	    		   deleteFolder(file);
	    		
	    	}
	    	
	    }
	    
	    
	    //重命名当前文件夹
	    File[] fileList2 = srcFolder.listFiles();
	    
	    for(File file : fileList2){
	    	 
	    	 File newName = new File(file.getParentFile(),file.getName().substring(3));
	    	 
	    	 file.renameTo(newName);
	    	
	    }
	      
	      

	      
	 }

	private static void deleteFolder(File file) {
		// TODO Auto-generated method stub
		File[] fileArr = file.listFiles();
		
		for(File f : fileArr){
			
            if(f.isDirectory()){
            	deleteFolder(f);
            }else{
            	f.delete();
            }

		}
		
		file.delete();
		
	}

	
}
