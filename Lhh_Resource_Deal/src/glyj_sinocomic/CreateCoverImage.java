package glyj_sinocomic;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;

/**
 * 按照指定规则生成封面路径
 * 生成规则：/bookimg/20160818/1(对50取余作为上层文件夹)/当前时间戳+_rand(10000,99999)
 * @author Administrator
 *
 */
public class CreateCoverImage {
	
	public static void main(String[] args) throws IOException{
		
		String s = "/bookimg/20160823/";
		
		File srcFile = new File("D:\\连环画平台图书批量入库\\CreateCoverImage_hywy.txt");
		
		BufferedWriter bw = new BufferedWriter(new FileWriter(srcFile));
		
		Random r = new Random();
		
//		long timestamp = System.currentTimeMillis();
		
		for(int i=2374;i<=2513;i++){
			
			int random =r.nextInt(99999);
			
//			System.out.println(String.valueOf(timestamp) + "_" +  Integer.toString(random));
			
//			System.out.println(s +  getRandomString(13) +"_" + Integer.toString(random)+".jpg");
			
			
			
			//按照子序列创建并散列文件夹
			
			int parentName = i % 50;
			
//			File parentFolder = new File("D:\\连环画平台图书批量入库\\BookCover", String.valueOf(parentName));
//			
//			if(!parentFolder.exists()){
//				
//				  parentFolder.mkdir();
//				
//			}
			
			//生成图片名称：
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
