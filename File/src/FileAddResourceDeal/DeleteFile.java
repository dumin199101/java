package FileAddResourceDeal;

import java.io.File;

/**
 * ����ɾ��ĳ���ļ����µ������ļ�
 * @author Administrator
 *
 */
public class DeleteFile {
	
	 public static void main(String[] args) {
		
		 File srcFolder = new File("H:\\��Դ����\\�񻰹���ϵ��");
		 
		 
		 deleteFolder(srcFolder);
		 
		 
		 
		 
		 
		 
		 
	 }

	private static void deleteFolder(File srcFolder) {
		// TODO Auto-generated method stub
		
		File[] fileArr = srcFolder.listFiles();
		
		
		for(File f : fileArr){
			
			if(f.isDirectory()){
				
				 deleteFolder(f);
				
			}else{
				
				//ɾ���ļ���
				
				if(f.delete()){
					
					System.out.println(f.getName() + "�ļ�ɾ���ɹ�");
					
				}else{
					
					System.out.println(f.getName() + "�ļ�ɾ��ʧ��");
					
				}
				
				
			}
			
			
			//ɾ���ļ���
			
			if(srcFolder.delete()){
				
				System.out.println(srcFolder.getName() + "�ļ�ɾ���ɹ�");
				
			}else{
				
				System.out.println(srcFolder.getName() + "�ļ�ɾ��ʧ��");
				
			}
			
			
			
		}
		
		
		
		
	}
	

}
