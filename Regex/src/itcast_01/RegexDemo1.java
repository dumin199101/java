package itcast_01;

import java.util.Scanner;

/**
 * У�飺 1��5-15λ������ 2������0��ͷ
 * 
 * @author Administrator
 * 
 */
public class RegexDemo1 {
	public static void main(String[] args) {
         //����¼�����ݣ�����У�飺
		 System.out.println("������У�����ݣ�");
		 Scanner sc = new Scanner(System.in);
		 String qq = sc.nextLine();
		 boolean flag = checkQQ(qq);
		 System.out.println("CheckQQ:"+flag);
	}

	//ʹ��Character��isDigit�����ж��ַ��Ƿ�Ϊ����
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
