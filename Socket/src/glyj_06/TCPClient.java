package glyj_06;
/**
 * 1.��װDatagramSocket����
 * 2.��װDatagraPacket����
 * 3.������ݣ�����
 * 4.�ͷ���Դ
 * 
 */
import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class TCPClient {
	public static void main(String[] args) throws IOException{
        
		DatagramSocket ds = new DatagramSocket();
		
		byte[] bys = "hello world".getBytes();
		
		int len = bys.length;
		
		InetAddress address = InetAddress.getByName("192.168.1.105");
        
		int port = 6666;
		
		DatagramPacket dp = new DatagramPacket(bys, len, address, port);
		
		ds.send(dp);
		
		ds.close();
		
	}
}
