package socket_tcp;

import java.io.IOException;
import java.io.OutputStream;
import java.net.Socket;

/**
 * TCP���ͻ���
 * 1.��װSocket����
 * 2.��װͨ���������д����
 * 3.�ͷ���Դ
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
