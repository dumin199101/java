package glyj_lhh_database;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import glyj_lhh_database.ImageRemarkUtil;

public class ErrorDeal{
	
	public static void main(String[] args) throws IOException {		
		BufferedReader br = new BufferedReader(new FileReader("D:\\book_id.txt"));
		String line = null;
		while((line = br.readLine())!=null){
			File srcFolder = new File("J:\\Lhh\\Lhh_Book\\"+line);
			ImageRemarkUtil.batchAddWaterMark(srcFolder);
		}
	}
	
	

}
