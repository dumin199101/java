package itcast_01;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Pattern对象跟Matcher对象
 * @author Administrator
 * 注意正则表达式是完全匹配
 */
public class RegexDemo7 {
    public static void main(String[] args) {
    	//模式对象
		Pattern p = Pattern.compile("a*b");
		//匹配器对象：
		Matcher m = p.matcher("aaaaab");
		if(m.matches()){
			System.out.println("good");
		}else{
			System.out.println("false");
		}
	}
}
