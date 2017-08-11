package FileDeal;



import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;


public class CreateXml {
     public static void main(String[] args) throws IOException {
		  
    	 File srcFolder = new File("E:\\wamp\\www\\test\\product_update\\lhhupdate\\Public\\Mpr\\Book\\MPR_CN\\62\\audio");
    	 
    	 File[] fileArr = srcFolder.listFiles();
    	 
    	 FileOutputStream fos = new FileOutputStream("62.xml");
    	 
    	 fos.write("<body page=\"176\">".getBytes());
    	 
    	 fos.write("\r\n".getBytes());
    	 
    	
    	 for(int x=1;x<fileArr.length;x++){
    		 
    		 
    		fos.write(("<block mp3=\"audio/" + x + ".mp3\"/>").getBytes());
    		
    		fos.write("\r\n".getBytes());
    		  
    		  
    		 
    		 
    	 }
    	 
    	 fos.write("</body>".getBytes());
    	
		  
    	 System.out.println("xml文件创建完成");
    	 
    	 fos.close();
    	 
    	 
		  
		  
	 }
}
