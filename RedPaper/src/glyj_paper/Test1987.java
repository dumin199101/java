package glyj_paper;

import java.math.BigInteger;

public class Test1987 {

     private static BigInteger result = new BigInteger("504");

     public static void main(String[] args) {
	       BigInteger[] arr = new BigInteger[4];
	       arr[0] = new BigInteger("1");
	       arr[1] = new BigInteger("9");
	       arr[2] = new BigInteger("8");
	       arr[3] = new BigInteger("7");
	      
           num(arr);
	       
//	       String[] compute = new String[4];
//	       compute[0] = "+";
//	       compute[1] = "-";
//	       compute[2] = "*";
//	       compute[3] = "/";
//	       
//	       for(String s : compute){
//	    	   if(s.equals("+")){
//	    		   
//	    	   }
//	       }
	       
	       
	       
	       
	       
	 }
     
     public static void num(BigInteger[] arr){
    	 for(BigInteger i : arr){
	    	   for(BigInteger j:arr){
	    		   for(BigInteger k : arr){
	    			   for(BigInteger l : arr){
	    				   if(Test1987.result == i.multiply(j).multiply(k).multiply(l)){
	    					   System.out.println(i+"*"+j+"*"+k+"*"+l+"="+(i.multiply(j).multiply(k).multiply(l)));
		    				   break;
	    				   }
	    			   }
	    		   }
	    	   }
	       }
     }
     
}
