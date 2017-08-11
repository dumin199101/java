package socket_review;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

public class TCPClient {
	
	public static void main(String[] args) throws IOException{
		
		 //封装Socket对象：
		 Socket s = new Socket("192.168.1.107", 22222);
		 
		 //封装通道输出流对象：
		 OutputStream os = s.getOutputStream();
		 
		 //往通道内写数据
		 os.write("hello tcp".getBytes());
		 
		 s.shutdownOutput();
		 
		 //读取服务器端的反馈信息：
		 InputStream is = s.getInputStream();
		 
		 byte[] bys =  new byte[1024];
		 
		 int len = 0;
		 
		 while((len = is.read(bys)) != -1){
			 
			  System.out.println(new String(bys,0,len));
			 
		 }
		 
		 //关闭流对象：
		 s.close();
		 
		 
		 
		 
		
		
		
	}

}
