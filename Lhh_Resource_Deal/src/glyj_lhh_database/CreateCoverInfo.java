package glyj_lhh_database;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

/*创建封面信息*/
public class CreateCoverInfo {
      public static void main(String[] args) throws IOException{
		  File srcFolder = new File("J:\\陕西广电连环画图片资源\\CN");
		  BufferedWriter bw = new BufferedWriter(new FileWriter("D:\\Deal\\cover_info.txt", true));
		  File[] fileArr = srcFolder.listFiles();
		  if(fileArr!=null){
			  for(File file : fileArr){
				  if(file.isDirectory()){
					  bw.write(file.getName()+"\t"+"/CN/"+file.getName()+"/1.jpg"+"\t"+"1"+"\t"+"1");
					  bw.newLine();
					  bw.flush();
				  } 
			  }
		  }
		  bw.close();
	  }
}
