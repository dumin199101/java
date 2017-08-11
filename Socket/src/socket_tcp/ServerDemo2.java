package socket_tcp;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class ServerDemo2 {
	
	public static void main(String[] args) throws IOException{
		
		ServerSocket ss = new ServerSocket(12306);
		
		Socket s = ss.accept();
		
		InputStream is = s.getInputStream();
		
		byte[] bys = new byte[1024];
		
		int len = 0;
		
		while((len = is.read(bys)) != -1){
			
			System.out.println(new String(bys,0,len));
			
			
		}
		
		
		//���ͻ����ѷ�����
		
		OutputStream os = s.getOutputStream();
		
		os.write("��Ϣ���յ���лл".getBytes());
		
		s.close();
		
		
		
		
		
		
		
	}

}
