package day01;

import javax.sound.sampled.ReverbType;

import org.junit.Test;

/**
 * 编写一个泛型方法，实现数组的逆序
 * @author Administrator
 *
 */
public class FanxingDemo3 {
    
	public static void main(String[] args) {
		
		Integer[] arr = {11,2,3,5345,342,123,13};
		
	    reverse(arr);
	    
	    //遍历数组：
	    for(int i : arr){
	    	System.out.println(i);
	    }
		
		
	}
	
	
	
	public static <T> void reverse(T[] arr){
	     int start = 0;
	     int end = arr.length - 1;
	     
	     while(true){
	    	 
	    	 if(start>=end){
	    		 
	    		 break;
	    		 
	    	 }
	    	 
	    	 T temp = arr[start];
	    	 arr[start] = arr[end];
	    	 arr[end] =  temp;
	    	 
	    	 start++;
	    	 end--;
	    	 
	    	 
	     }
	     
	     
	     
    }
}
