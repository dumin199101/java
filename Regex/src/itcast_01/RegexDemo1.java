package itcast_01;

import java.util.Scanner;

/**
 * 校验： 1）5-15位的数字 2）不以0开头
 * 
 * @author Administrator
 * 
 */
public class RegexDemo1 {
	public static void main(String[] args) {
         //键盘录入数据，进行校验：
		 System.out.println("请输入校验数据：");
		 Scanner sc = new Scanner(System.in);
		 String qq = sc.nextLine();
		 boolean flag = checkQQ(qq);
		 System.out.println("CheckQQ:"+flag);
	}

	//使用Character的isDigit方法判断字符是否为数字
	private static boolean checkQQ(String qq) {
		// TODO Auto-generated method stub
		boolean flag = true;
		if(qq.length()>=5&&qq.length()<=15){
			if(!qq.startsWith("0")){
				char[] chs = qq.toCharArray();
				for(int i=0;i<chs.length;i++){
					if(!Character.isDigit(chs[i])){
						flag = false;
						break;
					}
				}
			}else{
				flag = false;
			}
		}else{
			flag = false;
		}
		return flag;
	}
}
