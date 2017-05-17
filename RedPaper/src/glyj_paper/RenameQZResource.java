package glyj_paper;

import java.io.File;

/*
 * ����������δ����õ�����
 */
public class RenameQZResource {
	
	  public static int index = 408;
	
      public static void main(String[] args) {
		   File srcFolder = new File("D:\\�»��ձ�\\2");
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
			System.out.println(srcFile.getAbsolutePath()+"�������ɹ�");
		}else{
			System.out.println(srcFile.getAbsolutePath()+"������ʧ��");
		}
		
	}
}
