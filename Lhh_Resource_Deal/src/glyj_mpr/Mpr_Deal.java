package glyj_mpr;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * 2.�������д�background.mp3��ͼ����Ŀ:
 * 
 * @author Administrator
 * 
 */
public class Mpr_Deal {
	private static int count = 0;
	
	public static void main(String[] args) {
        File srcFolder = new File("E:\\������������Դ����\\Book");
        try {
			findBackgroundBookName(srcFolder);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        System.out.println("����background.mp3�ļ��ĸ���Ϊ"+count+"��");
	}

	private static void findBackgroundBookName(File srcFolder) throws IOException{
		
		
		// TODO Auto-generated method stub
		File[] fileArr = srcFolder.listFiles();
		
        for(File file : fileArr){
        	
        	
        	
        	if(file.isDirectory()){
        		
        		findBackgroundBookName(file);
        		
        	}else{
        		
        		if(file.getName().endsWith("background.mp3")){
        			
        			count++;
        			
        			File txtFolder = new File("E:\\������������Դ����\\Txt");
        			
        			if(!txtFolder.exists()){
        			  
        				txtFolder.mkdir();
        			  
        			}
        			
        			FileOutputStream fos = new FileOutputStream("E:\\������������Դ����\\Txt\\result.txt",true);
        			
        			fos.write(file.getParent().getBytes());
        			
        			fos.write("\r\n".getBytes());
        			
//        			System.out.println(file.getParent());
        			
        		}
        		
        		
        	}
        		
        	
        }
		
	}
}
