package glyj_sinocomic;

import java.io.File;

/**
 * ɾ�����ļ���
 * @author Administrator
 *
 */
public class DeleteEmptyDir {
   public static void main(String[] args) {
	   File srcFolder = new File("D:\\������ƽ̨ͼ���������\\HashResource\\Resource");
	   
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
			   
			   System.out.println(file.getAbsolutePath()+"��ɾ���ɹ�");
			   
			   srcFolder.delete();
			   
			   
		   }
		
	}
}
