package glyj_mpr;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * 2.查找所有待background.mp3的图书书目:
 * 
 * @author Administrator
 * 
 */
public class Mpr_Deal {
	private static int count = 0;
	
	public static void main(String[] args) {
        File srcFolder = new File("E:\\连环画新增资源处理\\Book");
        try {
			findBackgroundBookName(srcFolder);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        System.out.println("存在background.mp3文件的个数为"+count+"个");
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
        			
        			File txtFolder = new File("E:\\连环画新增资源处理\\Txt");
        			
        			if(!txtFolder.exists()){
        			  
        				txtFolder.mkdir();
        			  
        			}
        			
        			FileOutputStream fos = new FileOutputStream("E:\\连环画新增资源处理\\Txt\\result.txt",true);
        			
        			fos.write(file.getParent().getBytes());
        			
        			fos.write("\r\n".getBytes());
        			
//        			System.out.println(file.getParent());
        			
        		}
        		
        		
        	}
        		
        	
        }
		
	}
}
