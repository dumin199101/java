package glyj_paper;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;

/**
 * �������������
 * @author Administrator
 *
 */
public class ProduceDownloadTimes {
   public static void main(String[] args)  throws IOException{
	   BufferedReader br = new BufferedReader(new FileReader(
				"D:\\n_download_id.txt"));
		String line = null;
		String result = "";
		int download = 0;
		Random r = new Random();
		
		while ((line = br.readLine()) != null) {
			download = r.nextInt(100)+1;
//			System.out.println(line+"\t"+download);
			result = line+"\t"+download;
            writeTitleToLog("D:\\download.txt", result);
		}
		
		System.out.println("��Ϣ��ȡ���");
	   
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
