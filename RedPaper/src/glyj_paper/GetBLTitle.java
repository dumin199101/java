package glyj_paper;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

/**
 * 处理八路军标题
 * @author Administrator
 *
 */
public class GetBLTitle {
	private static String num;
    public static void main(String[] args) throws IOException{
    	BufferedReader br = new BufferedReader(new FileReader(
				"D:\\八路军标题.txt"));
		String line = null;
		String result = "";
		while ((line = br.readLine()) != null) {
             String[] data = line.split("\t");
//             System.out.println(data[0]+"\t"+data[1]+"\t"+data[2]+"\t"+data[4]);
             if(data[1].length()==1){
            	 GetBLTitle.num = "00" + data[1];
             }else if(data[1].length()==2){
            	 GetBLTitle.num = "0" + data[1];
             }else{
            	 GetBLTitle.num = data[1];
             }
             
             result = data[0] + "\t" +  data[2] + GetBLTitle.num + "\t" + data[1] + "\t" + "八路军军政杂志"+"\t" +data[2] ;
             
//             System.out.println(result);
             
             writeTitleToLog("D:\\BL_Title.txt", result);
               
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
