package FileDeal;

import java.io.File;

public class FileRenameSiDaMingZhu {
	
	public static void main(String[] args) {
		
//        File srcFolder = new File("H:\\Resource\\�Ĵ�����ϵ��");
//      File srcFolder = new File("H:\\Resource_Deal\\12");
      File srcFolder = new File("J:\\Resource\\ˮ�");
		
		renameFolder(srcFolder);
		
		
		
		
	}

	private static void renameFolder(File srcFolder) {
		// TODO Auto-generated method stub
		
		 if(srcFolder.isDirectory()){
			 
			 File[] fileArr = srcFolder.listFiles();
			 
			 for(File f : fileArr){
				 
				
//				 if(f.getName().endsWith("i1") || f.getName().endsWith("i2")){
//					 
//					 renameFile(f);
//					 
//					 
//				 }
				 
				 if(f.getName().endsWith("img") || f.getName().endsWith("i1") || f.getName().endsWith("i2")){
					 
					 renameFile(f);
					 
				 }
				 
				 renameFolder(f);
				 
				 
				 
				 
				 
			 }
			 
			 
			 
			 
		 }
		 
		
		
		
		
		
		
	}

	private static void renameFile(File srcFolder) {
		// TODO Auto-generated method stub
		
        File[] fileArr = srcFolder.listFiles();
		
		int x = 0;
		
		
		for(File f : fileArr){
			
			//����������
					
//					if(f.getName().length()==5){
//						
//						  //���ڵ���5�ļ�0����3.jpg
//						  File destFile = new File(srcFolder, "0"+f.getName());
//						  
//						  boolean flag = f.renameTo(destFile);
//						  
//						  if(flag){
//							  
//							  System.out.println(f.getName() + "�ļ���������ɵ�һ��");
//							  
//						  }
//						
//						
//						
//						
//					}
			
			
			
			
			//����ַ���ֵС��7λ23.jpg��0���� 023.jpg
//			if(f.getName().length()<7){
//				
//				 File destFile = new File(srcFolder, "0"+f.getName());
//				  
//				  boolean flag = f.renameTo(destFile);
//				  
//				  if(flag){
//					  
//					  System.out.println(f.getName() + "�ļ���������ɵڶ���");
//					  
//				  }
//				
//				  
//				
//				
//			}
			
			
			
			
//					
//					
//					
//					File destFile1 = new File(srcFolder,"0"+String.valueOf(x)+".jpg");
//				    
//				    x++;
//					
//					boolean  flag = f.renameTo(destFile1);
//					
//					if(flag){
//						
//						System.out.println(f.getName() + "�ļ���������ɵڶ���");
//						
//					}
					
					
			       //����ǰ10��
//					if(f.getName().length()==6){
//						
//
//						
//						 File destFile2 = new File(srcFolder,"0"+f.getName());
//						 
//						 boolean flag2 = f.renameTo(destFile2);
//						 
//						 if(flag2){
//							 
//							 System.out.println(f.getName() + "�ļ���������ɵ�����");
//							 
//						 }
//						
//						System.out.println(f.getName());
//						 
//						
//						
//						
//					}
					
					//����100ҳ���ϵ�����
			
			if(f.getName().length() == 8){
				
				File destFile3 = new File(srcFolder,f.getName().substring(1));
				
				boolean flag3 = f.renameTo(destFile3);
				
				if(flag3){
					
					 System.out.println(f.getName() + "�ļ���������ɵ��Ĳ�");
					
				}
				
				
				
				
				
				
				
			}
		
		
		
		
		
		
		
		
	}
	
	
	

    }
	
}
