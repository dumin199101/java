package glyj_mpr;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/**
 * 数据库更新后，发现ID数不对应：查找ID
 * @author Administrator
 *
 */
public class CompareID {
	public static void main(String[] args) throws IOException {
		
		//ID全的
		BufferedReader br = new BufferedReader(new FileReader("E:\\连环画新增资源处理\\Txt\\ID.txt"));
		
		
		//ID少的
		BufferedReader br2 = new BufferedReader(new FileReader("E:\\连环画新增资源处理\\Txt\\tmp.txt"));
		
		
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
