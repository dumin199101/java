package glyj_03;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.Socket;

/**
 * �ͻ���¼�����ݣ�д�뵽�ı��ļ�
 * @author Administrator
 *
 */
public class TCPClient {

	public static void main(String[] args) throws IOException{

		Socket s = new Socket("192.168.1.107", 11111);
		
		System.out.println("����¼������");
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(s.getOutputStream()));
		
		String line = null;
		
		while((line = br.readLine()) != null){
			
			if("888".equals(line)){
				
				break;
				
			}
			
			bw.write(line);
			
			bw.newLine();
			
			bw.flush();
			
			
		}
		
		
		s.close();
		
		
		
		
		
	}

}
