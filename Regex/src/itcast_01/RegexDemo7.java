package itcast_01;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Pattern�����Matcher����
 * @author Administrator
 * ע��������ʽ����ȫƥ��
 */
public class RegexDemo7 {
    public static void main(String[] args) {
    	//ģʽ����
		Pattern p = Pattern.compile("a*b");
		//ƥ��������
		Matcher m = p.matcher("aaaaab");
		if(m.matches()){
			System.out.println("good");
		}else{
			System.out.println("false");
		}
	}
}
