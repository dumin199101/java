package FileDeal;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class PatternDeleteA {

	public static void main(String[] args) throws IOException{
		
//		BufferedReader br = new BufferedReader(new FileReader("D:\\tmp_mjfc.sql"));
		
//		BufferedWriter bw = new BufferedWriter(new FileWriter("D:\\deleteA.sql"));
		
//		BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream("D:\\tmp_mjfc.sql"),"utf-8"));
//		
//		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(new FileOutputStream("D:\\deleteA.sql"),"utf-8"));
//		
//		String s = null;
//		
//		while((s = br.readLine()) != null){
//			
//			bw.write(s);
//			
//			bw.newLine();
//			
//			bw.flush();
//			    
//			
//		}
//		
//		bw.close();
//		br.close();
//		
//		System.out.println("文件复制完成");
		
		
		//做字符串替换：
		
		BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream("D:\\deleteA1.sql"), "utf-8"));
		
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(new FileOutputStream("D:\\deleteA2.sql"),"utf-8"));
		
		String s = null;
		
		while((s = br.readLine()) != null){
			
			  
//			  String pattern = "<a href[^>]*>";
//			  
//			  String ss = s.replaceAll(pattern,"");
//			  
//			  bw.write(ss);
//			  
//			  bw.newLine();
//			  
//			  bw.flush();
			  
			  String pattern2 = "</a>";
			  
			  String ss = s.replaceAll(pattern2, "");
			  
			  
			  bw.write(ss);
			  
			  bw.newLine();
			  
			  bw.flush();
			  
			
			  
			
			  
			
			
			
			
			
			
			
		}
		
		
		bw.close();
		br.close();
		
		
		System.out.println("字符串替换完成");
		
		
		
		//字符串正则替换demoTest
		
//		String s = "<a href='http://www.hao123.com'>" +  
//        "http://www.hao123.com</a><img title='img' src='abc' />";
//		
//		String pattern = "<a href[^>]*>";
//		
//		String ss = s.replaceAll(pattern, "");
//		
//		System.out.println(ss);
		
		
		
		
		
		
		
	}
	
}
