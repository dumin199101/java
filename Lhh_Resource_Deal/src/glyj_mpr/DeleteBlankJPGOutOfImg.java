package glyj_mpr;

import java.io.File;

/**
 * 4.ɾ������Img�ļ�����ߵ�blank.jpg
 * @author Administrator
 *
 */
public class DeleteBlankJPGOutOfImg {
	
	public static void main(String[] args) {
		
		File srcFolder = new File("E:\\������������Դ����\\Book");
		
		deleteBlankJpg(srcFolder);
		
		
		
	}

	private static void deleteBlankJpg(File srcFolder) {
		// TODO Auto-generated method stub
		File[] fileArr = srcFolder.listFiles();
		
		for(File file : fileArr){
			
			if(file.isDirectory() && (!file.getName().equals("img"))){
				
				 deleteBlankJpg(file);
				
			}else{
				
				if(file.getName().endsWith("blank.jpg")){
					
					file.delete();
					
					System.out.println(file.getAbsolutePath()+"ɾ���ɹ�");
					
				}
				
			}
			
		}
		
	}
	

}
