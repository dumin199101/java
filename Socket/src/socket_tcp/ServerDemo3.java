package socket_tcp;

import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class ServerDemo3 {
	
	public static void main(String[] args) throws IOException{
		
		ServerSocket ss = new ServerSocket(9999);
		
		Socket s = ss.accept();
		
		InputStream is = s.getInputStream();
		
		byte[] bys = new byte[1024];
		
		int len = 0;
		
		while((len = is.read(bys)) != -1){
			
			 System.out.println(new String(bys,0,len));
			
			
			
		}
		
		
		s.close();
	}

}
