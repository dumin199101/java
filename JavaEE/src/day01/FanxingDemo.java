package day01;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import org.junit.Test;

/**
 * ·ºÐÍ
 * @author Administrator
 *
 */
public class FanxingDemo {
    @Test
	public void test(){
    	HashMap<Integer,String> hm = new HashMap<Integer, String>();
    	
    	hm.put(1, "hello");
    	hm.put(2, "world");
    	hm.put(3, "java");
    	
    	Set<Integer> keySet = hm.keySet();
    	
    	for(Integer key : keySet){
    		
    		System.out.println(hm.get(key));
    		
    	}
    	
    	System.out.println("---------------------------");
    	
    	Set<Map.Entry<Integer, String>> entrySet = hm.entrySet();
    	
    	for(Map.Entry<Integer, String> set : entrySet){
    		
    		 System.out.println(set.getKey()+"---"+set.getValue());
    		
    	}
    	

    	
    	
    }
}
