package glyj_sinocomic;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

/**
 * 按照生成规则重命名所有的封面图片：
 * @author Administrator
 *
 */
public class RenameCoverImage {
     public static void main(String[] args) throws IOException{
	   
    	  File referTxt = new File("D:\\连环画平台图书批量入库\\BookID_CoverImage_wy.txt");
    	  
    	  File srcFolder = new File("D:\\连环画平台图书批量入库\\Cover");
    	  
    	  
    	  BufferedReader br = new BufferedReader(new FileReader(referTxt));
    	  
    	  String line = null;
    	  
    	  while((line = br.readLine()) != null){
    		  
    		  String[] row  = line.split("\\t");
    		  
    		  String bookid = row[0];
    		  
   		      String coverImageName = row[1];
    		  
   		    
    		   
    		   //查找最後一個/的位置，截取到最後就是圖片的文件名
    		   int index = coverImageName.lastIndexOf("/");
    		   
    		   String newName = coverImageName.substring(index+1);
    		   
    		   
    		   renameCoverImage(srcFolder,newName,bookid);
    		   
    		   
    		  
    	  }
    	  
    	  
    	  
    	 
    	 
	 }
     
     /**
      * 重命名文件
      * @param srcFolder
      * @param newName
      * @param bookid
      */

	private static void renameCoverImage(File srcFolder, String newName,
			String bookid) {
		
		File newSrcfolder = new File(srcFolder,bookid);
		
		File newSrcFile = new File(newSrcfolder,"1.jpg");
		
		File newDestFile = new File(newSrcfolder,newName);
		
		if(!newSrcFile.renameTo(newDestFile)){
			
			System.out.println(newSrcFile.getName()+"重命名失败");
			
		}
		
		
		
		
		
	}
}
