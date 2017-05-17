package socket_tcp;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
	public static void main(String[] args) throws IOException{
		
		ServerSocket ss = new ServerSocket(9898);
		
		Socket s = ss.accept();
		
		InputStream is = s.getInputStream();
		
		byte[] bys = new byte[1024];
		
		/*
		
		int len = is.read(bys); // 阻塞
		
		
		String server = new String(bys, 0, len);
		System.out.println("server:" + server);
		*/
		
		int len = 0;
		
		while((len = is.read(bys)) != -1){
			
			System.out.println(new String(bys,0,len));
			
		}
		
		
		
		
		
		
		OutputStream os = s.getOutputStream();
		
		os.write("数据已收到".getBytes());
		
		s.close();
		
		
	}

}
