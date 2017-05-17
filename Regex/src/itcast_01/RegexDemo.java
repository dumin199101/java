package itcast_01;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/*
 * 正则表达式：
 */
public class RegexDemo {
	
	/**
	 * 静态中只能调用静态
	 * String.matches(String regex):判断一个字符串是否匹配正则表达式
	 * java.util.Regex中：
	 *   字符：x \\ \r \n
	 *   字符类：[abc] a或b或c
	 *             [^abc]:除了abc
	 *             [a-zA-Z]
	 *             [0-9]
	 *   预定义字符类：
	 *            .:代表任意字符
	 *            \d:0-9
	 *            \D:[^0-9]
	 *            \s:空白字符
	 *            \w:单词字符 [0-9A-Za-z_]
	 *    边界匹配器：
	 *            ^:开头
	 *            $:结尾
	 *            \b:单词边界,不是单词字符的 Hello World?haha!
	 *    数量词：
	 *         ？：0或1
	 *         *:0或多次
	 *         +:1或多次
	 *         {n}:n次
	 *         {n,}:至少n次
	 *         {n,m}:至少n次至多m次
	 *    方法：
	 *         判断功能：String类中的boolean matches(String regex)
	 *         分割功能：String类中的String[] split(String regex)
	 *         替换功能：String类中的String replaceAll(String regex,String replacement)
	 *         获取功能：Pattern:模式对象  Matcher:匹配器对象
	 *                     Pattern p = Pattern.compile("a*b")
	 *                     Matcher m = p.matcher("acccccb")
	 *                     boolean b = m.matches()
	 *                     
	 *                     Matcher对象的find() boolean find():是否有匹配结果
	 *                                       group() String group():返回匹配的结果
	 *                     
	 *         
	 */
	public static void main(String[] args) {
//         Scanner sc = new Scanner(System.in);
//         System.out.println("请输入一个QQ号：");
//         
//         String qq = sc.nextLine();
//         
//         System.out.println("CheckQQ:"+checkQQ(qq));
		
//		    String s = "Hello,World,Java,Python";
//		    
//		    String pattern = ",";
//		    
//		    String[] ss = s.split(pattern);
//		    
//		    for(int x=0;x<ss.length;x++){
//		    	System.out.println(ss[x]);
//		    }
		
//		    String s = "E:\\Java\\Code";
//		    
//		    String pattern = "\\\\";
//		    
//		    String[] ss = s.split(pattern);
//		    
//		    for(int x=0;x<ss.length;x++){
//		    	System.out.println(ss[x]);
//		    }
		
//		   String s = "helloworld123456java";
//		   
//		   String pattern = "\\d";
//		   
//		   String result = s.replaceAll(pattern, "*");
//		   
//		   System.out.println(result);
		
		   //模式对象
//         	 Pattern p = Pattern.compile("a*b");
//           
//           //匹配器对象
//           Matcher m = p.matcher("aaaaab");
//           
//           boolean flag = m.matches();
//           
//           System.out.println(flag);
           
		      String s = "hello world java";
		      
		      //注意匹配的单词边界
		      Pattern p = Pattern.compile("\\b\\w{5}\\b");
		      
		      Matcher m = p.matcher(s);
		      
		      while(m.find()){
		    	  System.out.println(m.group());
		      }
		
         
	}
	
	public static boolean checkQQ(String qq){
		
		String regex = "[1][3][0-9]{9}";
		
		if(qq.matches(regex)){
			return true;
		}else{
			return false;
		}
		
		
	}
	
}
