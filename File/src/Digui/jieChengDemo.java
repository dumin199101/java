package Digui;

import java.util.Scanner;

public class jieChengDemo {
       public static void main(String[] args) {
		   
    	   Scanner sc = new Scanner(System.in);
    	   
    	   int n = sc.nextInt();
    	   
    	   int res = jieCheng(n);
    	   
    	   System.out.println(res);
	   }

	private static int jieCheng(int n) {
		
		if(n==1){
			
			return n;
			
		}else{
			
			return n * jieCheng(n-1);
			
	       		
			
		}
	
		
		
	}
}
