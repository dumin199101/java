package glyj_sl;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class GetPRCChapterURL{
   public static void main(String[] args)  throws IOException{
	   InputStream file = new FileInputStream("D:\\chapterURL.txt");
	   BufferedReader br = new BufferedReader(new InputStreamReader(file, "UTF-8"));
	   BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(new FileOutputStream("D://prc_url.txt", true), "UTF-8"));
	   String line = null;
	   String prefix = "http://prc.goosuudata.com/index.php?m=cndex&a=view&file=Resource/Prc_UpdateSrc";
	   while((line = br.readLine())!=null){
		   String[] lines = line.split("\t");
		   String dir1 = lines[1].substring(0,2);
		   String dir2 = lines[1].substring(2,4);
		   String url = prefix+"/"+dir1+"/"+dir2+"/"+lines[1]+".pdf";
		   bw.write(lines[0]+"\t"+lines[1]+"\t"+lines[2]+"\t"+lines[3]+"\t"+lines[4]+"\t"+url);
		   bw.newLine();
		   bw.flush();
	   }
	   bw.close();
	   br.close();
   }
}
