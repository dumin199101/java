package FileDeal;

import java.io.File;
import java.io.IOException;

public class RenameAudio {
	
	 public static void main(String[] args) throws IOException{
		
	       File srcFolder =  new File("H:\\��Դ����");
	       
	       rename(srcFolder);
	       
	       
		 
	 
	 
	 }
	 
	 

	private static void rename(File srcFolder) {
		// TODO Auto-generated method stub
		
		
		 if(srcFolder.isDirectory()){
			 
			   //srcFolder���ļ��еݹ鴦��
			   File[] fileArr = srcFolder.listFiles();
			   
			   for(File file : fileArr){
				   
				      
				      //����Ƶ�ļ������ݹ鴦��
				      if(file.getName().endsWith("audio")){
				    	  
				    	   renameFile(file);
				    	  
				    	  
				    	  
				      }
				   
				        
				      rename(file);
				   
				   
			   }
			 
			   
			  
			 
			 
			 
		 }
		
		
		
		
		
		
		
		

		
		
	}



	private static void renameFile(File srcFolder) {
		// TODO Auto-generated method stub
		
		
		
		File[] fileArr = srcFolder.listFiles();
		
		int x = 0;
		
		for(File file : fileArr){
			
			//1-1 ��1��ǰ��
//			System.out.println(file.getAbsolutePath());

			//1.����5λ6λ������ 001.mp3 010.mp3 -->112.mp3,����Ϊ7λ
//			if(file.getName().length()<=6){
//			
//				
//				   
//				    //������λ��
//				    if(file.getName().length()==5){
//				    	
//			    	 File newName = new File(srcFolder,"00"+file.getName());
//				    	 
//				    	 file.renameTo(newName);
//			    	
//				    	 
//				    	
//			    }else if(file.getName().length()==6){
//			    	
//				    	
//				    	File newName = new File(srcFolder,"0"+file.getName());
//				    	
//				    	file.renameTo(newName);
//				    	
//				    	
//			    	
//				    }
//				    
//				    
//				  
//			
//			}
			
			
			
			
			//�����-�ߵ�
//			if(file.getName().contains("-")){
//			
//				   if(file.getName().length()==7){
//					   
//					   String[] fileNameArr = file.getName().split("-");
//					   
//					   File newFile = new File(srcFolder,"00" + fileNameArr[0].concat(".mp3.mp3"));
//					   
//				   file.renameTo(newFile);
//					   
//				   }else if(file.getName().length()==8){
//					   
//                       String[] fileNameArr = file.getName().split("-");
//					   
//					   File newFile = new File(srcFolder,"0" + fileNameArr[0].concat(".mp3.mp3"));
//					   
//					   file.renameTo(newFile);
//					   
//					   
//				   }else if(file.getName().length()==9){
//			
//			          String[] fileNameArr = file.getName().split("-");
//					   
//                      File newFile = new File(srcFolder,fileNameArr[0].concat(".mp3.").concat(fileNameArr[1]).concat(".mp3"));
//					   
//					   file.renameTo(newFile);
//					   
//					   
//				   }
//				
//			}
			
			
			//��ֹ������100���ϵ�ʧ�ܣ�
//			if(file.getName().endsWith(".mp3")){
//				
//				
//				
//				File newFile = new File(srcFolder,"bak"+file.getName());
//				
//				file.renameTo(newFile);
//				
//				
//			}
			
			
			
			
			
			
			
			
//			File dest = new File(srcFolder,String.valueOf(x)+".mp3");
//			
//			x = x+1;
//			
//			boolean flag = file.renameTo(dest);
//			
//			
//			if(flag){
//				
//				 System.out.println(file.getAbsolutePath() + "�ļ������ɹ�");
//				 
//			}else{
//				
//				 System.out.println(file.getAbsolutePath() + "�ļ�����ʧ��");
//				
//			}
			
			
	
			
		}
		
		
//		System.out.println( srcFolder.getName() + ",��1���������");
//		System.out.println(srcFolder.getName()+ ",��2���������");
//		System.out.println(srcFolder.getName() + "��3���������");
//		System.out.println(srcFolder.getName() + "��4���������");
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	}

}
