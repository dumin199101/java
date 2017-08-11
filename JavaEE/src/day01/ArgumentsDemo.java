package day01;

import java.util.Arrays;
import java.util.List;

import org.junit.Test;

/**
 * Arrays�������е�asList�������յĲ����Ƕ���������ջ������Ͳ���ת��
 * @author Administrator
 *
 */
public class ArgumentsDemo {
    
	@Test
	public void test(){
		
		sum(1,2,3,4,5,6);
		
	}
	

	public void sum(int ...args){
     
	     int sum = 0;
	     
	     for(int i : args){
	    	 
	    	 sum+=i;
	    	 
	     }
	     
	     System.out.println(sum);
    	
    	
    }
	
	@Test
	public void test2(){
		
		List<String> list = Arrays.asList("1","2","3");
		
		System.out.println(list);
		
		
		List<Integer> list2 = Arrays.asList(1,2,3,4);
		System.out.println(list2);
		
		int[] arr = {1,2,3,4,5};
		
		List list3 = Arrays.asList(arr);
		
		System.out.println(list3);
		
	}
	
}
