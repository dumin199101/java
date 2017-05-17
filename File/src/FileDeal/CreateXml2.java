package FileDeal;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class CreateXml2 {
   public static void main(String[] args) throws IOException{
	     File srcFolder = new File("E:\\wamp\\www\\test\\product_update\\lhhupdate\\Public\\Mpr\\Book\\MPR_CN\\62\\audio");
	     
	     FileInputStream fis = new FileInputStream("62.xml");
	     
	     FileOutputStream fos = new FileOutputStream("62-1.xml");
	     
	     int len = 0;
	     
	     while((len = fis.read())!=-1){
	    	 
	    	 fos.write(len);
//	    	 System.out.println(len);
	    	 
	    	 
	     }
	     
	     fos.close();
	     
	     fis.close();
	     
	     System.out.println("xml文件复制完成");
	     
   }
}
