package itcast_01;

import java.util.Scanner;

/**
 * 正则表达式的分割功能
 * 
 * @author Administrator
 * 
 */
public class RegexDemo4 {
	public static void main(String[] args) {
         String age = "18-24";
         String ages[] = age.split("-");
         int beginAge = Integer.parseInt(ages[0]);
         int endAge = Integer.parseInt(ages[1]);
         System.out.println("请输入你的年龄：");
         Scanner sc = new Scanner(System.in);
         int age1 = sc.nextInt();
         if(age1>=beginAge&&age1<=endAge){
        	 System.out.println("good format");
         }else{
        	 System.out.println("bad format");
         }
 	}
}
