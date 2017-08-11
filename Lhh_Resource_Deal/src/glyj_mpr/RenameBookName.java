package glyj_mpr;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

/**
 * 根据图书ID重命名图书
 * @author Administrator
 *
 */
public class RenameBookName {
     public static void main(String[] args) {
	        
    	 File srcFolder = new File("E:\\连环画新增资源处理\\Book\\MPR_CN");
    	 
    	 File bookinfo = new File("E:\\连环画新增资源处理\\Txt\\tmp_book_info.txt");
    	 
    	 try {
			renameBookName(srcFolder,bookinfo);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
     	 
    	 
	 }

	private static void renameBookName(File srcFolder, File bookinfo) throws IOException{
		// TODO Auto-generated method stub
		File[] fileArr = srcFolder.listFiles();
		
		for(File file : fileArr){
			
			BufferedReader br = new BufferedReader(new FileReader(bookinfo));
			
			String line = null;
			
			while((line=br.readLine())!=null){
				
				System.out.println(line);
				
				
				
			}
			
			
		}
		
		
	}
}
