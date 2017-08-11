package socket_tcp;

import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * 1.封装服务器Socket对象
 * 2.监听客户端连接
 * 3.封装通道输入流，读数据
 * 4.释放资源
 * @author Administrator
 *
 */
public class ServerDemo {
	public static void main(String[] args) throws IOException{
        
		ServerSocket ss = new ServerSocket(2222);
		
		Socket s = ss.accept();
		
		InputStream is = s.getInputStream();
		
		byte[] bys = new byte[1024];
		
		int len = 0;
		
		while((len = is.read(bys)) !=-1){
			
			System.out.println(new String(bys,0,len));
			
			
		}
		
		
		
		
		 
		
	}
}
