package glyj_sl;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * 拆分文件
 * @author Administrator
 *
 */
public class ExtractFile {
	 public static int index = 0;
     public static void main(String[] args) {
    	 String parentDir = "J:\\新疆丝绸之路西域史料文献辑要数据库原始数据\\丝绸之路西域史料文献辑要\\丝绸之路西域古代文献部（260种）_PDF\\一版252-260";
    	 File srcFolder = new File(parentDir);	
	     try {
			scanDir(srcFolder);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
	 }

	private static void scanDir(File srcFolder) throws IOException {
		File destFolder = new File("J:\\新疆丝绸之路西域史料文献辑要数据库加工数据\\成本PDF\\古代卷(241)");
		// TODO Auto-generated method stub
		File[] fileArr = srcFolder.listFiles();
	     if(fileArr!=null){
	    	 for(File file : fileArr){
	    		 if(file.isDirectory()){
	    			 scanDir(file);
	    		 }else{
	    			 if(!file.getName().endsWith("正文.pdf"))
	    				 continue;
	    			 ExtractFile.index++;
//	    			 System.out.println(ExtractFile.index+":"+file.getAbsolutePath());
	    			 String parent = file.getParent();
	    			 int pos = parent.lastIndexOf("\\");
	    			 //复制PDF到指定目录
	    			 File srcFile = new File(srcFolder,file.getName());
	    			 File destFile = new File(destFolder,parent.substring(pos+1)+".pdf");
	    			 copyFile(srcFile,destFile);
	    		 }
	    	 }
	     }
	}

	private static void copyFile(File srcFile, File destFile) throws IOException {
		
		// TODO Auto-generated method stub
		BufferedInputStream bis = new BufferedInputStream(new FileInputStream(srcFile));
		BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(destFile));
		int len = 0;
		byte[] bys = new byte[1024];
		while((len = bis.read(bys))!=-1){
			bos.write(bys, 0, len);
		}
		bis.close();
		bos.close();
		System.out.println(destFile.getName()+"文件复制完成");
	}
}
