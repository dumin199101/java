package glyj_sinocomic;

import java.io.File;

/**
 * 删除空文件夹
 * @author Administrator
 *
 */
public class DeleteEmptyDir {
   public static void main(String[] args) {
	   File srcFolder = new File("D:\\连环画平台图书批量入库\\HashResource\\Resource");
	   
		deleteDir(srcFolder);
	   
   }

	private static void deleteDir(File srcFolder) {
		// TODO Auto-generated method stub
		   File[] fileArr = srcFolder.listFiles();
		   
		   for(File file : fileArr){
			   
			   if(file.isDirectory()){
				   deleteDir(file);
			   }else{
				   file.delete();
			   }
			   
			   System.out.println(file.getAbsolutePath()+"：删除成功");
			   
			   srcFolder.delete();
			   
			   
		   }
		
	}
}
