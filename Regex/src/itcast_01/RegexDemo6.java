package itcast_01;

/**
 * ������ʽ���滻����
 * 
 * @author Administrator
 * 
 */
public class RegexDemo6 {
	public static void main(String[] args) {
         String str = "hello1223214world34324java";
         //�������滻Ϊ*
         String regex = "\\d";
         String ss = "*";
         String result = str.replaceAll(regex, ss);
         System.out.println(result);
	}
}
