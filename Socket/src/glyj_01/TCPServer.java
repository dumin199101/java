package glyj_01;

//��ȡ�ַ���������ʾ�ڿ���̨

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
		
		//��ȡ�ͻ��˵�IP��
		InetAddress address = s.getInetAddress();
		
		String ip = address.getHostAddress();
		
		
		
	    //��ȡͨ���ڵ����ݣ�
		InputStream is = s.getInputStream();
		
		byte[] bys = new byte[1024];
		
		int len = 0;
		
		while((len = is.read(bys)) != -1){

			 System.out.println("�ͻ���IP:" + ip + "������Ϊ��" + new String(bys,0,len));
			
			
		}
		
		//���ͻ��˷�����
		OutputStream os = s.getOutputStream();
		
		os.write("�����ѽ������".getBytes());
		
		s.close();
		
		
		
		
		
		
	}

}
