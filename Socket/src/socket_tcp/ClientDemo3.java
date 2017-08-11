package socket_tcp;


import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.Socket;

public class ClientDemo3 {
	public static void main(String[] args) throws IOException{
		
		Socket s = new Socket("192.168.1.122",9999);
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
//		OutputStream os  = s.getOutputStream();
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(s.getOutputStream()));
		
		String str = null;
		
		while((str = br.readLine()) != null){
			
			 if("886".equals(str)){
				 
				 break;
			 }
			
			 bw.write(str);
			 bw.newLine();
			 bw.flush();
			
			
		}
		
		
		
		br.close();
		
		s.close();
	    
		
		
		
		
	}
}
