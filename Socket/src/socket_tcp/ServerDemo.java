package socket_tcp;

import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * 1.��װ������Socket����
 * 2.�����ͻ�������
 * 3.��װͨ����������������
 * 4.�ͷ���Դ
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
