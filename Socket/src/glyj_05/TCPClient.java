package glyj_05;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.net.Socket;

/**
 * �ͻ��˶�ȡ�ı��ļ�����������д���ı��ļ�
 * @author Administrator
 *
 */
public class TCPClient {
    public static void main(String[] args) throws IOException{
		
    	Socket s = new Socket("192.168.1.107",11111);
    	
    	BufferedReader br = new BufferedReader(new FileReader("a.txt"));
    	
    	BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(s.getOutputStream()));
    	
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
