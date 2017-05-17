package glyj_06;
/**
 * 1.创建DatagramSocket对象
 * 2.创建数据包
 * 3.接收数据
 * 4.解析数据
 * 5.释放资源
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
        
        System.out.println("数据接收完毕：");
        
        System.out.println("IP为："+ address.getHostAddress() +"，数据为，" + new String(bys2,0,len));
    	
    	
    	
    	
    	
    	
	}
}
