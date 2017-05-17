package glyj_02;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.Socket;

/**
 * 键盘录入数据，输出在控制台
 * 
 * @author Administrator
 * 
 */
public class TCPClient {
	public static void main(String[] args) throws IOException{
        
		Socket s = new Socket("192.168.1.107", 11111);
		
		System.out.println("请输入数据：");
		
		//键盘录入数据：
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		

//		OutputStream os = s.getOutputStream();
		
		//封装通道内的流，通过BufferedWriter包装一下，字节流-->转换流--->高效流
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(s.getOutputStream()));
		
		String line = null;
		
		while((line = br.readLine()) != null){
			
			//键盘录入数据，自定义结束标记
			   
			   if("888".equals(line)){
				   break;
			   }
			   
			   bw.write(line);
			   
			   bw.newLine();
			   
			   bw.flush();
			
			
			
			
			
		}
		
		
	
		
		
		
//		br.close();
		s.close();
		
		
		
		
		
		
		
	}
}
