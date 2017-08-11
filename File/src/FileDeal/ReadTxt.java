package FileDeal;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class ReadTxt {
	public static void main(String[] args) throws IOException {
         
		   File srcFile = new File("E:\\wamp\\logs\\apache_error.log");
		   
		   BufferedReader br = new BufferedReader(new FileReader(srcFile));
		   
		   String s =null;
		   
		   while((s = br.readLine())!=null){
			   
			  
			    	
			    	System.out.println(s);
			    	
			   
			    
			    
			   
		   }
		   
		   
           
         
	}
}
