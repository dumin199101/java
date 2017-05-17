package glyj_paper;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class DealBLTitleInfo {
	public static void main(String[] args) {
        File srcFolder = new File("C:\\Users\\Administrator.PC--20140317OBO\\Desktop\\红色报刊\\信息提取\\采集测试\\八路军军政标题测试.txt");
        try {
			dealTitleInfo(srcFolder);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        System.out.println("文件信息提取完毕");
	}

	private static void dealTitleInfo(File srcFolder) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new FileReader(srcFolder));
		String line = null;
		String title = "",guid="";
		while((line = br.readLine())!=null){
			  String[] line_info = line.split("\t");
			  guid = "BL"+line_info[0]+line_info[1];
			  writeTitleToLog("D:\\八路军军政标题信息.txt",guid);
		}
		
	}

	private static void writeTitleToLog(String fileName, String result) throws IOException{
		// TODO Auto-generated method stub
		BufferedWriter bw = new BufferedWriter(new FileWriter(fileName, true));
		bw.write(result);
		bw.newLine();
		bw.flush();
		bw.close();
	}
}
