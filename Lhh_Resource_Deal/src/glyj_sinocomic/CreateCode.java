package glyj_sinocomic;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
/**
 * ����ָ����������Code
 */
public class CreateCode {
	
	public static void main(String[] args) throws IOException{
		

		String s = "BD20160823";
		
		File destFile = new File("D:\\������ƽ̨ͼ���������\\CreateCode_hywy.txt");
		
		
		BufferedWriter bw = new BufferedWriter(new FileWriter(destFile));
		
		
		
		
		
		
		for(int i=2374;i<=2513;i++){
			
			String str = s + Integer.toString(i);
			
			bw.write(str);
			
			bw.newLine();
			
			bw.flush();
			
			
		}
		
		
		bw.close();
		
		System.out.println("over");
		
		
		
		
	}

}
