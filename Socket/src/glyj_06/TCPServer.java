package glyj_06;
/**
 * 1.����DatagramSocket����
 * 2.�������ݰ�
 * 3.��������
 * 4.��������
 * 5.�ͷ���Դ
 */
import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class TCPServer {
    public static void main(String[] args) throws IOException{
		
    	DatagramSocket ds = new DatagramSocket(6666);
    	
    	byte[] bys = new byte[1024];
    	
    	int length = bys.length;
    	
    	DatagramPacket dp = new DatagramPacket(bys, length);
    	
    	ds.receive(dp);
    	
        byte[] bys2 = dp.getData();
        
        int len = dp.getLength();
        
        InetAddress address = dp.getAddress();
        
        System.out.println("���ݽ�����ϣ�");
        
        System.out.println("IPΪ��"+ address.getHostAddress() +"������Ϊ��" + new String(bys2,0,len));
    	
    	
    	
    	
    	
    	
	}
}
