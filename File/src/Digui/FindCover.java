package Digui;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import javax.imageio.stream.FileImageInputStream;

/**
 * �ݹ����ͼ���е����з���
 * @author Administrator
 *
 */
public class FindCover {
	
     public static void main(String[] args)  throws IOException{
		 
    	
    	   //1.��װĿ¼��
    	    File srcFolder = new File("E:\\wamp\\www\\test\\product_update\\lhh\\Public\\Mpr\\Book\\MPR_CN");
    	    
    	    
    	    getCover(srcFolder);
    	  
    	 
    	  
    	   
    	   
    	   
    	   
    	          
    	          
 	    	
 	    	
 	    
    	 
 	     
 	    
	 }

	private static void getCover(File srcFolder) throws IOException {
		// TODO Auto-generated method stub
		
      //2.��ȡ��Ŀ¼�������ļ��и��ļ���File����
		File[] FileArray = srcFolder.listFiles();
		
		for(File file : FileArray){
			
			//3.������File�����ж����ļ��л����ļ�
 	        //1)���ļ��лص�2  2��������ļ����ж��Ƿ���1.jpg �Ǹ��Ƶ�ָ��Ŀ¼����
			if(file.isDirectory()){
				
				  getCover(file);
				
			}else{
				
				if(file.getName().equals("1.jpg")){
					
				   	
					String path  = file.getAbsolutePath();
					
					
					//System.out.println(path); E:\wamp\www\test\product_update\lhh\Public\Mpr\Book\MPR_CN\783\img\1.jpg
					
				
					
					
				
					
//					FileInputStream fis = new FileInputStream(path);
					BufferedInputStream bis = new BufferedInputStream(new FileInputStream(path));
					
					
				    String[] arr = path.split("MPR_CN");
				    

				    
					File f2 = new File(arr[1]); //arr[1] 783\img\1.jpg
					
					
					String name = f2.getParent();  //\783\img
					
//					System.out.println(name);
					
					String[] ss= name.split("img");
					
//					System.out.println(ss[0]);
					
				
					
				
					
					
			
				    File ff = new File("E:\\Cover",ss[0]);
				    
				    ff.mkdirs();
					
				    name = name + "Cover.jpg";
				    
//				    System.out.println(name);
				    
				  
				    File fff = new File("E:\\Cover",name);
					
					
					
					
					
					
				    
				
					
					
					
					BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(fff));
					
//					int by = 0;
//					
//					while((by = fis.read())!=-1){
//						
//						fos.write(by);
//						
//					}
					
					
//					fis.close();
//					fos.close();
					
					byte[] bys = new byte[1024];
					
					int len = 0;
					
					while((len = bis.read(bys))!=-1){
						
						bos.write(bys, 0, len);
					}
					
					bis.close();
					bos.close();
					
					
				
					
					
					
					
							
					
					
					
					
					
				}
				
				
			}
			
			
			
			
			
		}
		
   	 
 	   
		
		
		System.out.println("Cover�������");
		
	}
}
