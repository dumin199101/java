package day01;

import javax.sound.sampled.ReverbType;

import org.junit.Test;

/**
 * ��дһ�����ͷ�����ʵ�����������
 * @author Administrator
 *
 */
public class FanxingDemo3 {
    
	public static void main(String[] args) {
		
		Integer[] arr = {11,2,3,5345,342,123,13};
		
	    reverse(arr);
	    
	    //�������飺
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
