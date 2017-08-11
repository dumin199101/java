package Digui;

import java.io.File;

public class Rename1 {
     public static void main(String[] args) {
	        File srcForlder = new File("E:\\wamp\\www\\test\\product_update\\lhh\\Public\\Mpr\\Book\\MPR_WWR\\62\\audio");
	      
	        File[] files = srcForlder.listFiles();
	        
	        for(File f : files){
	        	
	        	//System.out.println(f.getName());
	        	
//	        	System.out.println(f.getName().split("bak.mp3")[0]);
	        	
//	        	System.out.println(f.getName().split("bak.mp3")[0].concat(".mp3"));
	        	
//	        	String newName = f.getName().split("bak.mp3")[0].concat(".mp3");
	        	String newName = f.getName().split("bak.mp3")[0].concat(".mp3");
	        	
	        	File newFile = new File(srcForlder,newName);
	        	
	        	System.out.println(f.renameTo(newFile));
	        	
	        	
	        	
	        }
	        
	        
	 }
}
