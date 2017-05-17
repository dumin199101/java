package glyj_sinocomic;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;

/**
 * 提取图书封面到某个目录下
 * 
 * @author Administrator
 * 
 */
public class GetBookCover {

	public static void main(String[] args) throws IOException{

		File srcFolder = new File(
				"J:\\升级改版连环画数字图书馆机构版 -  资源\\高总版数字图书馆（测试）\\lhhupdate_test\\Public\\Mpr\\Book\\MPR_WWR");

		File destFolder = new File("D:\\连环画平台图书批量入库\\Cover");
		
		File referTxt = new File("D:\\连环画平台图书批量入库\\BookID_wy.txt");
		
		BufferedReader br = new BufferedReader(new FileReader(referTxt));
		
		String line = null;
		
		while( (line = br.readLine()) != null){
	
			 String bookid = line;
			 
//			 System.out.println(bookid);
			 
			 copyCover(srcFolder,destFolder,bookid);
			 
			 
			
			
		}
		
		
		

	}

	private static void copyCover(File srcFolder, File destFolder, String bookid) throws IOException{
		// TODO Auto-generated method stub
		File newSrcFolder = new File(srcFolder, bookid);
		
		File newDestFolder = new File(destFolder,bookid);
		
		if(!newDestFolder.exists()){
			newDestFolder.mkdir();
		}
		
		File newSrcFile = new File(newSrcFolder,"img/1.jpg");
		
		File newDestFile = new File(newDestFolder,"1.jpg");
		
		BufferedInputStream bis = new BufferedInputStream(new FileInputStream(newSrcFile));
		
		BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(newDestFile));
		
		byte[] bys = new byte[1024];
		
		int len = 0;
		
		while((len = bis.read(bys))!=-1){
			
			bos.write(bys, 0, len);
					
		}
		
		bis.close();
		
		bos.close();
		
		System.out.println(bookid+" copy complete");
		
		
		
		
	}
}
