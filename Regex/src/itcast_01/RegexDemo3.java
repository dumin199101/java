package itcast_01;

import java.util.Scanner;

/**
 * ������ʽ�жϹ��ܣ��ж��ֻ������Ƿ����Ҫ��
 *    1.��13����18��ͷ
 *    2.ֻ��������
 *    3.11λ
 * @author Administrator
 *
 */
public class RegexDemo3 {
    public static void main(String[] args) {
		System.out.println("�������ֻ����룺");
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
