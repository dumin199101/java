package socket_review;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class TCPServer {
	
	public static void main(String[] args) throws IOException{
		
		//封装服务器端Socket对象 
		ServerSocket ss = new ServerSocket(22222);
		
		//监听客户端连接
		Socket s = ss.accept();
		
		//读取通道内的流：
		InputStream is = s.getInputStream();
		
		byte[] bys = new byte[1024];
		
		int len = 0;
		
		while((len = is.read(bys)) != -1){
			
			    System.out.println(new String(bys,0,len)); 
			
		}
		
		//给客户端给出反馈信息：
		OutputStream os = s.getOutputStream();
		
		os.write("信息已接收完毕".getBytes());
		
		//关闭流对象：
		s.close();
		
		
		
		
		
		
		
		 
		 
		 
		
	}

}
