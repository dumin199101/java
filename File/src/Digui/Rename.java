package Digui;

import java.io.File;

public class Rename {
	
	public static void main(String[] args) {
		
	    File file = new File("E:\\wamp\\www\\test\\product_update\\lhh\\Public\\Mpr\\Book\\MPR_WWR\\62\\audio");
	    
	    File[] files = file.listFiles();
	    
	    for(File f : files){
	    	 
//	    	System.out.println(f);
	    	//执行改名操作：
	    	String name = f.getName();
	    	
	    	//System.out.println(name);
	    	
           String[] s = name.split(".mp3");
           
           int i = Integer.parseInt(s[0]);
           
           i = i+1;
           
           String string = String.valueOf(i);
           
           //System.out.println(string);
           
           String newName =string.concat("bak.mp3");
           
          
           
           
           File newFile = new File(file,newName);
           
           
           
          System.out.println(f.renameTo(newFile)); 
           
           
           
           
           
	    	
	    }
	
	
	}

}
