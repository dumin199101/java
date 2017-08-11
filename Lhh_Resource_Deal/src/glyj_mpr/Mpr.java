package glyj_mpr;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * ����������ͼ�����Դ�ӹ�����
 * 1.���ƴ�������Դ������Ŀ¼
 * 
 * 
 * @author Administrator
 *
 */
public class Mpr {
	
	public static void main(String[] args) {
		
		//��װ��ԴԭʼĿ¼��
		File srcFolder = new File("E:\\������������Դ����\\Book");
		
		
		//��װĿ�ĵ�Ŀ¼:
		File destFolder = new File("E:\\Demo");
		
		
		if(!destFolder.exists()){
			
			destFolder.mkdir();
			
		}
		
		
		//1.���ƴ�������Դ������Ŀ¼
		try {
			copyFolder(srcFolder,destFolder);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		
		
		System.out.println("Procedure Running Over");
		
		
		
		
		
		
		
		
		
	}

	private static void copyFolder(File srcFolder, File destFolder) throws IOException{
		// TODO Auto-generated method stub
		File[] fileArr = srcFolder.listFiles();
		
		//����Ŀ�ĵ�Ŀ¼��
		File newFolder = new File(destFolder,srcFolder.getName());
		
		newFolder.mkdir();
		
		for(File file : fileArr){
			
			 if(file.isDirectory()){
				 
				  copyFolder(file, newFolder);
				  
				 
			 }else{
				 
				 
				//�����ļ����ƣ�
			    File newFile = new File(newFolder,file.getName());
			    
				 copyFile(file,newFile);
				 
				 
			 }
			
			
			
		}
		
		
	}

	private static void copyFile(File file, File newFile) throws IOException{
		// TODO Auto-generated method stub
		BufferedInputStream bis = new BufferedInputStream(new FileInputStream(file));
		
		BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(newFile));
		
		int len = 0;
		
		byte[] bys = new byte[1024];
		
		while((len = bis.read(bys)) != -1){
			
			bos.write(bys, 0, len);
			
		}
		
		bis.close();
		
		bos.close();
		
		System.out.println(newFile.getAbsolutePath()+"�ļ��������");
		
	}

}
