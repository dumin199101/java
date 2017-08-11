package glyj_paper;

import java.io.File;

/*
 * 处理玲子那未处理好的数据
 */
public class RenameQZResource {
	
	  public static int index = 408;
	
      public static void main(String[] args) {
		   File srcFolder = new File("D:\\新华日报\\2");
		   renameFile(srcFolder);
	  }

	private static void renameFile(File srcFolder) {
		// TODO Auto-generated method stub
		File[] fileArr = srcFolder.listFiles();
		if(fileArr!=null){
			for(File file : fileArr){
				if(file.isDirectory()){
					renameFile(file);
				}else{
					RenameQZResource.index++;
//					System.out.println(file.getAbsolutePath()+"---"+RenameQZResource.index);
					File srcFile = new File(srcFolder, file.getName());
					File destFile = new File(srcFolder,Integer.toString(RenameQZResource.index)+".jpg");
					rename(srcFile,destFile);
				}
			}
		}
	}

	private static void rename(File srcFile, File destFile) {
		// TODO Auto-generated method stub
		if(srcFile.renameTo(destFile)){
			System.out.println(srcFile.getAbsolutePath()+"重命名成功");
		}else{
			System.out.println(srcFile.getAbsolutePath()+"重命名失败");
		}
		
	}
}
