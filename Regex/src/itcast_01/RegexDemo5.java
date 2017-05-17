package itcast_01;

import java.util.Arrays;

public class RegexDemo5 {
	public static void main(String[] args) {
         String s = "12 33 21 4 42";
         String[] string = s.split(" ");
         int[] arr = new int[string.length];
         for(int i=0;i<string.length;i++){
        	 arr[i] = Integer.parseInt(string[i]);
         }
         Arrays.sort(arr);
         StringBuilder sb = new StringBuilder();
         for(int i=0;i<arr.length;i++){
        	 sb.append(arr[i]).append(" ");
         }
         String result = sb.toString().trim();
         System.out.println("result:"+result);
	}
}
