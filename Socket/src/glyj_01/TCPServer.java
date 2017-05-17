package glyj_01;

//读取字符串数据显示在控制台

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;

public class TCPServer {
	
	public static void main(String[] args) throws IOException{
		
		ServerSocket ss = new ServerSocket(11111);
		
		Socket s = ss.accept();
		
		//获取客户端的IP：
		InetAddress address = s.getInetAddress();
		
		String ip = address.getHostAddress();
		
		
		
	    //读取通道内的数据：
		InputStream is = s.getInputStream();
		
		byte[] bys = new byte[1024];
		
		int len = 0;
		
		while((len = is.read(bys)) != -1){

			 System.out.println("客户端IP:" + ip + "，内容为：" + new String(bys,0,len));
			
			
		}
		
		//给客户端反馈：
		OutputStream os = s.getOutputStream();
		
		os.write("数据已接收完毕".getBytes());
		
		s.close();
		
		
		
		
		
		
	}

}
