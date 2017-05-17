package glyj_05;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

public class TCPServer {
     public static void main(String[] args) throws IOException{
		
         ServerSocket ss = new ServerSocket(11111);
         
         Socket s = ss.accept();
         
         BufferedReader br = new BufferedReader(new InputStreamReader(s.getInputStream()));
         
         BufferedWriter bw = new BufferedWriter(new FileWriter("b.txt"));
         
         String line = null;
         
         while((line = br.readLine()) != null){
        	 
        	 
        	 bw.write(line);
        	 
        	 bw.newLine();
        	 
        	 bw.flush();
        	 
         }
         
         
         
         br.close();
    	 s.close();
    	 
    	 
    	 
    	 
    	 
	}
}
