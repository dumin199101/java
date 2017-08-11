package socket_tcp;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

public class Client {
	 public static void main(String[] args) throws IOException{
		 
		 
	       Socket s = new Socket("192.168.1.122",9898);
	       
	       OutputStream os = s.getOutputStream();
	       
	       os.write("hello world".getBytes());
	       
	       s.shutdownOutput();
	       
	       InputStream is = s.getInputStream();
	       
	       /*
	       byte[] bys = new byte[1024];
	       
	       int len = is.read(bys);
	       
	       System.out.println(new String(bys,0,len));
	       */
	       
	       byte[] bys2   = new byte[1024];
	       
	       int len = 0;
	       
	       while((len = is.read(bys2)) != -1){
	    	   
	    	   System.out.println(new String(bys2,0,len));
	    	   
	       }
	       
	       
	       
	       s.close();
	       
	 }

}
