package glyj_lhh_database;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

/**
 * ɾ���������Դ
 * 
 * @author Administrator
 * 
 */
public class DeleteResource {

	public static void main(String[] args) {
		File srcFolder = new File("J:\\�������������ͼƬ��Դ\\����\\MPR_CN");
		File offsetTxt = new File("D:\\Deal\\tmp_cn_diff.txt");
		
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
	    	
	    	File delFolder = new File(srcFolder,line);
	    	
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
				
//				System.out.println(file.getAbsolutePath()+"�ļ��ѱ�ɾ��");
				
				
				
				
				
			}
			
		}
		
		delFolder.delete();
		
		System.out.println(delFolder.getAbsolutePath()+"�ļ��б�ɾ��");
		
	}
	
}
