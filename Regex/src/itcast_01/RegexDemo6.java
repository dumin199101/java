package itcast_01;

/**
 * 正则表达式的替换功能
 * 
 * @author Administrator
 * 
 */
public class RegexDemo6 {
	public static void main(String[] args) {
         String str = "hello1223214world34324java";
         //把数字替换为*
         String regex = "\\d";
         String ss = "*";
         String result = str.replaceAll(regex, ss);
         System.out.println(result);
	}
}
