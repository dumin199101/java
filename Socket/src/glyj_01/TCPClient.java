package glyj_01;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

public class TCPClient {
	
	public static void main(String[] args) throws IOException{
		
		 Socket s = new Socket("192.168.1.107", 11111);
		 
	     OutputStream os = s.getOutputStream();
	     
	     os.write("hello world,i am coming".getBytes());
	     
	     //给服务器端读取完毕的反馈：
	     s.shutdownOutput();
	     
	     InputStream is = s.getInputStream();
	     
	     byte[] bys = new byte[1024];
	     
	     int len = 0;
	     
	     while((len = is.read(bys)) !=-1){
	    	 
	    	 System.out.println(new String(bys,0,len));
	    	  
	     }
		 
		 
		 s.close();
		 
		
		
		
	}

}
