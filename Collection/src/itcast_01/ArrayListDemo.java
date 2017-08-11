package itcast_01;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

public class ArrayListDemo {
	public static void main(String[] args) {
        
		Collection<String> c = new ArrayList<String>();
        
		c.add("hello");
		c.add("world");
		
		Iterator<String> i = c.iterator();
		
		while(i.hasNext()){
			
			  System.out.println(i.next());
			
			
		}
		
		
		
        
	}
}
