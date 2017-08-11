package socket_tcp;

import java.io.IOException;
import java.io.OutputStream;
import java.net.Socket;

/**
 * TCP：客户端
 * 1.封装Socket对象
 * 2.封装通道输出流，写数据
 * 3.释放资源
 * @author Administrator
 *
 */
public class ClientDemo {
	
	public static void main(String[] args) throws IOException{
		
		Socket s = new Socket("10.0.0.11", 2222);
		
		OutputStream os = s.getOutputStream();
		
		os.write("hello tcp".getBytes());
		
		s.close();
		
		
		
		
		
		
	}
	

}
