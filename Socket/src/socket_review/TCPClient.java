package socket_review;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

public class TCPClient {
	
	public static void main(String[] args) throws IOException{
		
		 //��װSocket����
		 Socket s = new Socket("192.168.1.107", 22222);
		 
		 //��װͨ�����������
		 OutputStream os = s.getOutputStream();
		 
		 //��ͨ����д����
		 os.write("hello tcp".getBytes());
		 
		 s.shutdownOutput();
		 
		 //��ȡ�������˵ķ�����Ϣ��
		 InputStream is = s.getInputStream();
		 
		 byte[] bys =  new byte[1024];
		 
		 int len = 0;
		 
		 while((len = is.read(bys)) != -1){
			 
			  System.out.println(new String(bys,0,len));
			 
		 }
		 
		 //�ر�������
		 s.close();
		 
		 
		 
		 
		
		
		
	}

}
