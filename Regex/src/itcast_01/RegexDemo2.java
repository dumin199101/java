package itcast_01;

import java.util.Scanner;

public class RegexDemo2 {
     public static void main(String[] args) {
	      System.out.println("请输入要校验的QQ号：");
	      Scanner sc = new Scanner(System.in);
	      String qq = sc.nextLine();
	      boolean flag = checkQQ(qq);
	      System.out.println("CheckQQ:"+flag);
	 }

	private static boolean checkQQ(String qq) {
		boolean flag = true;
		String regex = "[1-9][0-9]{4,14}";
		if(!qq.matches(regex)){
			flag = false;
		}
		return flag;
	}
}
