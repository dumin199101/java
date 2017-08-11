package itcast_01;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 正则表达式的获取功能
 * @author Administrator
 *  Matcher对象的find跟group方法
 *  获取只含有三个字符的单词：\b\w{3}\b
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
