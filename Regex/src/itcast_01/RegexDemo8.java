package itcast_01;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * ������ʽ�Ļ�ȡ����
 * @author Administrator
 *  Matcher�����find��group����
 *  ��ȡֻ���������ַ��ĵ��ʣ�\b\w{3}\b
 */
public class RegexDemo8 {
   public static void main(String[] args) {
	   String s = "da jia hao,wo jin tian hen kai xin ";
	   Pattern p = Pattern.compile("\\b\\w{3}\\b");
	   Matcher m = p.matcher(s);
	   while(m.find()){
		   System.out.println(m.group());
	   }
   }
}
