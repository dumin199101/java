package socket_tcp;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

/**
 * 在客户端读取服务器端给出的反馈：
 * @author Administrator
 *
 */
public class ClientDemo2 {
     public static void main(String[] args) throws IOException{
    	 
	      Socket s = new Socket("192.168.1.122",12306);
	      
	      OutputStream os = s.getOutputStream();
	      
	      os.write("hello world".getBytes());
	      
	      s.shutdownOutput();
	      
	      
	      //读取服务器端给出的反馈信息：
	      
	      InputStream is = s.getInputStream();
	      
	      byte[] bys = new byte[1024];
	      
	      
	      
	      int len = 0;
	      
	     
	      while((len=is.read(bys)) != -1){
	    	  
	    	
	    	  
	    	   System.out.println(new String(bys,0,len));
	    	  
	      }
	      
	      
	      
	  
	      
	      
	      
	 }
}
