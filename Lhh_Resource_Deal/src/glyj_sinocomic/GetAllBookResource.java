package glyj_sinocomic;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;

/**
 * ��ʵ���Էֿ���ȡ�����������������
 * 1.����ȡ������飺����ͼ���ͼƬ+��������ͼ���ͼƬ+��������ͼ�����Ƶ
 * 2.����ȡ�����ά����飺����+ά��
 * @author Administrator
 *
 */

public class GetAllBookResource {
	
	public static void main(String[] args) throws IOException{
		
		File srcFolder = new File("D:\\������ƽ̨ͼ���������\\Demo");
		
		File destFolder = new File("D:\\������ƽ̨ͼ���������\\DemoTest");
		
		File referTxt = new File("D:\\������ƽ̨ͼ���������\\ReferTxt.txt");
		
		BufferedReader br = new BufferedReader(new FileReader(referTxt));
		
		String line = null;
		
		while((line = br.readLine()) != null){
			
		    if(!line.equals("")){
		    	
		    	String[] strArr = line.split("\\t");
				
		    	//ͼ�����ID
				String refer_id = strArr[0];
				
				//ͼ��������ID
				String id = strArr[1];
				
				File newSrcFolder = new File(srcFolder,refer_id);
				
				if(newSrcFolder.exists()){
					copyFolder(newSrcFolder,destFolder,id);
				}
				
				
				

				

		    }
			
		
			
			
			
			
			
			
		}
		
		
		br.close();
		
		
		
		
	}

	private static void copyFolder(File newSrcFolder, File destFolder,String id)  throws IOException{
		// TODO Auto-generated method stub
		File[] fileArr = newSrcFolder.listFiles();
		
		for(File file : fileArr){
			
			if(file.getName().endsWith(".jpg") || file.getName().endsWith(".mp3")){
				 
				File srcFile = new File(newSrcFolder,file.getName());
				
				File newDestFolder = new File(destFolder,id);
				
				if(!newDestFolder.exists()){
					
					 newDestFolder.mkdirs();
					
				}
				
				File newFile = new File(newDestFolder,file.getName());
				

//				System.out.println(srcFile.getAbsolutePath());
				
				 //���ļ����ƣ�
				 copyFiles(srcFile,newFile);
//				 
				 System.out.println(srcFile.getAbsolutePath()+"�ļ��������");
//				
				
				
				
			}
			
			
		}
		
		
		
	}

	private static void copyFiles(File srcFile, File newFile) throws IOException{
		// TODO Auto-generated method stub
		BufferedInputStream bis = new BufferedInputStream(new FileInputStream(srcFile));
		
		BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(newFile));
		
		
		byte[] bys = new byte[1024];
		
		int len = 0;
		
		
		
		while((len = bis.read(bys)) != -1){
			
			 bos.write(bys, 0,len);
			 			
		}
		
		
		bos.close();
		
		bis.close();
		
		
		
		
		
	}
	

}
