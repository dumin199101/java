package glyj_02;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.Socket;

/**
 * ����¼�����ݣ�����ڿ���̨
 * 
 * @author Administrator
 * 
 */
public class TCPClient {
	public static void main(String[] args) throws IOException{
        
		Socket s = new Socket("192.168.1.107", 11111);
		
		System.out.println("���������ݣ�");
		
		//����¼�����ݣ�
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		

//		OutputStream os = s.getOutputStream();
		
		//��װͨ���ڵ�����ͨ��BufferedWriter��װһ�£��ֽ���-->ת����--->��Ч��
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(s.getOutputStream()));
		
		String line = null;
		
		while((line = br.readLine()) != null){
			
			//����¼�����ݣ��Զ���������
			   
			   if("888".equals(line)){
				   break;
			   }
			   
			   bw.write(line);
			   
			   bw.newLine();
			   
			   bw.flush();
			
			
			
			
			
		}
		
		
	
		
		
		
//		br.close();
		s.close();
		
		
		
		
		
		
		
	}
}
