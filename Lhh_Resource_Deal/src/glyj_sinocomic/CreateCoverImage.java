package glyj_sinocomic;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;

/**
 * ����ָ���������ɷ���·��
 * ���ɹ���/bookimg/20160818/1(��50ȡ����Ϊ�ϲ��ļ���)/��ǰʱ���+_rand(10000,99999)
 * @author Administrator
 *
 */
public class CreateCoverImage {
	
	public static void main(String[] args) throws IOException{
		
		String s = "/bookimg/20160823/";
		
		File srcFile = new File("D:\\������ƽ̨ͼ���������\\CreateCoverImage_hywy.txt");
		
		BufferedWriter bw = new BufferedWriter(new FileWriter(srcFile));
		
		Random r = new Random();
		
//		long timestamp = System.currentTimeMillis();
		
		for(int i=2374;i<=2513;i++){
			
			int random =r.nextInt(99999);
			
//			System.out.println(String.valueOf(timestamp) + "_" +  Integer.toString(random));
			
//			System.out.println(s +  getRandomString(13) +"_" + Integer.toString(random)+".jpg");
			
			
			
			//���������д�����ɢ���ļ���
			
			int parentName = i % 50;
			
//			File parentFolder = new File("D:\\������ƽ̨ͼ���������\\BookCover", String.valueOf(parentName));
//			
//			if(!parentFolder.exists()){
//				
//				  parentFolder.mkdir();
//				
//			}
			
			//����ͼƬ���ƣ�
			String pictureName = s + Integer.toString(parentName) + "/"+ getRandomString(13) +"_" + Integer.toString(random)+".jpg";
			
			bw.write(pictureName);
			
			bw.newLine();
			
			bw.flush();
			
			
		
			
		 
			
			
		}
		
		
		bw.close();
		
		System.out.println("over");
		
		
		
		
		
		
		
		
		
	}
	
	
	
	public static String getRandomString(int length){  
        String str="abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";  
        Random random = new Random();  
        StringBuffer sb = new StringBuffer();  
          
        for(int i = 0 ; i < length; ++i){  
            int number = random.nextInt(62);//[0,62)  
              
            sb.append(str.charAt(number));  
        }  
        return sb.toString();  
    }  

}
