package Digui;

import java.io.File;

public class DiguiDemo2 {
	
	public static void main(String[] args) {
		
		File f = new File("F:\\aaa");
		
		deleteFolder(f);
		
		
	}

	private static void deleteFolder(File srcFolder) {
		
		if(srcFolder.exists()){
			
			File[] fileArr = srcFolder.listFiles();
			
			if(fileArr != null){
				
				for(File f : fileArr){
					
					if(f.isDirectory()){
						
						deleteFolder(f);
						
						/*ɾ�����ļ�������ɾ���ļ���
						
						System.out.println(f.getAbsolutePath()+"-----"+f.delete());*/
						
						
					}else{
						
						System.out.println(f.getAbsolutePath()+"-------:"+f.delete());
						
					}
					
				}
				
				
				
				System.out.println(srcFolder.getAbsolutePath()+":"+srcFolder.delete());
				
				
				
			}

			
			
			
			
			
		}
		
				
		
		
		
		
		
	}

}
