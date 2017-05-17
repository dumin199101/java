package glyj_mpr;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

/**
 * 3.ɾ������ͼ�������ظ���ͼ����Դ
 * @author Administrator
 *
 */
public class Mpr_Delete {
	
	public static void main(String[] args) {
		File srcFolder = new File("E:\\������������Դ����\\Book");
		File offsetTxt = new File("E:\\������������Դ����\\Txt\\result.txt");
		
		try {
			deleteFile(srcFolder,offsetTxt);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	private static void deleteFile(File srcFolder, File offsetTxt) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new FileReader(offsetTxt));
		
	    String line = null;
	    
	    while((line = br.readLine())!=null){
	    	
	    	File delFolder = new File(line);
	    	
	    	deleteFolder(delFolder);
	    	
	    }
	
		
	}

	private static void deleteFolder(File delFolder) {
		// TODO Auto-generated method stub
		File[] fileArr = delFolder.listFiles();
		
		for(File file : fileArr){
			
			if(file.isDirectory()){
				
				deleteFolder(file);
				
			}else{
				
				file.delete();
				
				System.out.println(file.getName()+"�ļ��ѱ�ɾ��");
				
				
				
				
				
			}
			
		}
		
		delFolder.delete();
		
		System.out.println(delFolder.getName()+"�ļ��б�ɾ��");
		
	}

	

}
