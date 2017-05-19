package glyj_lhh_database;

import java.io.File;

/**
 * 遍历文件夹名
 * @author Administrator
 *
 */
public class ScanDirName {
    public static void main(String[] args) {
		 File srcFolder = new File("J:\\Lhh\\Lhh_Book");
		 File[] fileArr = srcFolder.listFiles();
		 if(fileArr!=null){
			 for(File file:fileArr){
				 if(file.isDirectory()){
					 System.out.println(file.getName());
				 }
			 }
		 }
	}
}
