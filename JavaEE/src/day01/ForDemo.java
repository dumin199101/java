package day01;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import org.junit.Test;

/**
 * 增强for：只能遍历数组跟实现了iterable接口的集合 数组 set集合 List集合
 * 
 * @author Administrator
 * 
 */
public class ForDemo {
	
	
    @Test
	public void test1() {

		int[] arr = { 1, 43, 64, 2, 3, 454 };
		
		for(int i : arr){
			System.out.println(i);
		}

	}
    
    @Test
    public void test2(){
    	
    	ArrayList<Integer> list = new ArrayList<Integer>();
    	
    	list.add(20);
    	
    	list.add(30);
    	
    	list.add(40);
    	
    	for(Integer i : list){
    		
    		System.out.println(i);
    		
    	}
    	
    }
    
    @Test
    public void test3(){
    	
    	HashMap<String,String> hm = new HashMap<String,String>();
    	
    	hm.put("001", "hello");
    	hm.put("002", "world");
    	hm.put("003", "java");
    	
    	Set<String> keySet = hm.keySet();
    	
    	for(String key : keySet){
    		
    		System.out.println(hm.get(key));
    		
    	}
    	
    	System.out.println("--------------------------------");
    	
    	Set<Map.Entry<String,String>> mapEntry = hm.entrySet();
    	
    	for(Map.Entry<String,String> map : mapEntry){
    		
    		System.out.println(map.getKey()+"---"+map.getValue());
    		
    		
    	}
    	
    }
    
    
    
    
    
}
