package itcast_01;

import java.util.Scanner;

/**
 * ������ʽ�ķָ��
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
         System.out.println("������������䣺");
         Scanner sc = new Scanner(System.in);
         int age1 = sc.nextInt();
         if(age1>=beginAge&&age1<=endAge){
        	 System.out.println("good format");
         }else{
        	 System.out.println("bad format");
         }
 	}
}
