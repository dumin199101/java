package glyj_mpr;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/**
 * ���ݿ���º󣬷���ID������Ӧ������ID
 * @author Administrator
 *
 */
public class CompareID {
	public static void main(String[] args) throws IOException {
		
		//IDȫ��
		BufferedReader br = new BufferedReader(new FileReader("E:\\������������Դ����\\Txt\\ID.txt"));
		
		
		//ID�ٵ�
		BufferedReader br2 = new BufferedReader(new FileReader("E:\\������������Դ����\\Txt\\tmp.txt"));
		
		
		String line = null;
		
		String line2 = null;
		
		while((line = br.readLine())!=null){
			
			while((line2 = br2.readLine())!=null){
				
				
				if(line.equals(line2)){
					
					continue;
					
				}
				
				System.out.println(line);
				
				
			}
			
			
			
			
			
			
		}
		
		
	}

}
