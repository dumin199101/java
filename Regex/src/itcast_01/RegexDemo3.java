package itcast_01;

import java.util.Scanner;

/**
 * 正则表达式判断功能：判断手机号码是否符合要求：
 *    1.以13或者18开头
 *    2.只能是数字
 *    3.11位
 * @author Administrator
 *
 */
public class RegexDemo3 {
    public static void main(String[] args) {
		System.out.println("请输入手机号码：");
		Scanner sc = new Scanner(System.in);
		String phone = sc.nextLine();
		boolean flag = checkPhone(phone);
		System.out.println("checkPhone:"+flag);
	}

	private static boolean checkPhone(String phone) {
		// TODO Auto-generated method stub
		boolean flag = true;
		String regex = "[1][38]\\d{9}";
		if(!phone.matches(regex)){
			flag = false;
		}
		return flag;
	}
}
