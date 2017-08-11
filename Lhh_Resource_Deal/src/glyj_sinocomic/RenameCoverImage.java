package glyj_sinocomic;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

/**
 * �������ɹ������������еķ���ͼƬ��
 * @author Administrator
 *
 */
public class RenameCoverImage {
     public static void main(String[] args) throws IOException{
	   
    	  File referTxt = new File("D:\\������ƽ̨ͼ���������\\BookID_CoverImage_wy.txt");
    	  
    	  File srcFolder = new File("D:\\������ƽ̨ͼ���������\\Cover");
    	  
    	  
    	  BufferedReader br = new BufferedReader(new FileReader(referTxt));
    	  
    	  String line = null;
    	  
    	  while((line = br.readLine()) != null){
    		  
    		  String[] row  = line.split("\\t");
    		  
    		  String bookid = row[0];
    		  
   		      String coverImageName = row[1];
    		  
   		    
    		   
    		   //��������һ��/��λ�ã���ȡ��������ǈDƬ���ļ���
    		   int index = coverImageName.lastIndexOf("/");
    		   
    		   String newName = coverImageName.substring(index+1);
    		   
    		   
    		   renameCoverImage(srcFolder,newName,bookid);
    		   
    		   
    		  
    	  }
    	  
    	  
    	  
    	 
    	 
	 }
     
     /**
      * �������ļ�
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
			
			System.out.println(newSrcFile.getName()+"������ʧ��");
			
		}
		
		
		
		
		
	}
}
