package glyj_mpr;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

/**
 * 3.删除数字图书馆里边重复的图书资源
 * @author Administrator
 *
 */
public class Mpr_Delete {
	
	public static void main(String[] args) {
		File srcFolder = new File("E:\\连环画新增资源处理\\Book");
		File offsetTxt = new File("E:\\连环画新增资源处理\\Txt\\result.txt");
		
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
				
				System.out.println(file.getName()+"文件已被删除");
				
				
				
				
				
			}
			
		}
		
		delFolder.delete();
		
		System.out.println(delFolder.getName()+"文件夹被删除");
		
	}

	

}
