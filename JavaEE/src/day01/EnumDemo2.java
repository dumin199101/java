package day01;

import org.junit.Test;

public class EnumDemo2 {
	 
	  @Test
	  public void testEnum(){
		  
		  print(Color.RED);
		 
		  Color[] colors = Color.values();
		  
		  for(Color color : colors){
			  System.out.println(color);
		  }
		  
		  
		  
		  
		  
	  }
	  
	  
	 
      private void print(Color c) {
		   
    	    System.out.println(c.name());
    	    System.out.println(c.ordinal());
    	   
    	  
		
	  }



	enum Color{
    	  RED,YELLOW,BLUE,BLACK;
      }
}
