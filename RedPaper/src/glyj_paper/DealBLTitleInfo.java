package glyj_paper;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class DealBLTitleInfo {
	public static void main(String[] args) {
        File srcFolder = new File("C:\\Users\\Administrator.PC--20140317OBO\\Desktop\\��ɫ����\\��Ϣ��ȡ\\�ɼ�����\\��·�������������.txt");
        try {
			dealTitleInfo(srcFolder);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        System.out.println("�ļ���Ϣ��ȡ���");
	}

	private static void dealTitleInfo(File srcFolder) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new FileReader(srcFolder));
		String line = null;
		String title = "",guid="";
		while((line = br.readLine())!=null){
			  String[] line_info = line.split("\t");
			  guid = "BL"+line_info[0]+line_info[1];
			  writeTitleToLog("D:\\��·������������Ϣ.txt",guid);
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
