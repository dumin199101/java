package glyj_paper;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

/**
 * 获取群众周刊的标题信息
 * 
 * @author Administrator
 * 
 */
public class GetQZTitle {
	private static String num;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new FileReader(
				"D:\\群众周刊标题信息.txt"));
		String line = null;
		String result = "";
		while ((line = br.readLine()) != null) {
             String[] data = line.split("\t");
//             System.out.println(data[0]+"\t"+data[1]+"\t"+data[2]+"\t"+data[4]);
             if(data[0].length()==1){
            	  GetQZTitle.num = "00" + data[0];
             }else if(data[0].length()==2){
            	  GetQZTitle.num = "0" + data[0];
             }else{
            	  GetQZTitle.num = data[0];
             }
             
             result = "QZ" + data[2] + data[4] + GetQZTitle.num + "\t" + "QZ" + data[2] + data[4] + "\t" + data[1];
             
             writeTitleToLog("D:\\QZ_Title.txt", result);
               
		}
		
		System.out.println("信息提取完毕");
	}
	
	private static void writeTitleToLog(String fileName, String result)
			throws IOException {
		// TODO Auto-generated method stub
		BufferedWriter bw = new BufferedWriter(new FileWriter(fileName, true));
		bw.write(result);
		bw.newLine();
		bw.flush();
		bw.close();
	}
}
