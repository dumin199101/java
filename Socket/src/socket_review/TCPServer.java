package socket_review;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class TCPServer {
	
	public static void main(String[] args) throws IOException{
		
		//��װ��������Socket���� 
		ServerSocket ss = new ServerSocket(22222);
		
		//�����ͻ�������
		Socket s = ss.accept();
		
		//��ȡͨ���ڵ�����
		InputStream is = s.getInputStream();
		
		byte[] bys = new byte[1024];
		
		int len = 0;
		
		while((len = is.read(bys)) != -1){
			
			    System.out.println(new String(bys,0,len)); 
			
		}
		
		//���ͻ��˸���������Ϣ��
		OutputStream os = s.getOutputStream();
		
		os.write("��Ϣ�ѽ������".getBytes());
		
		//�ر�������
		s.close();
		
		
		
		
		
		
		
		 
		 
		 
		
	}

}
