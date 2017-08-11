package itcast_01;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/*
 * ������ʽ��
 */
public class RegexDemo {
	
	/**
	 * ��̬��ֻ�ܵ��þ�̬
	 * String.matches(String regex):�ж�һ���ַ����Ƿ�ƥ��������ʽ
	 * java.util.Regex�У�
	 *   �ַ���x \\ \r \n
	 *   �ַ��ࣺ[abc] a��b��c
	 *             [^abc]:����abc
	 *             [a-zA-Z]
	 *             [0-9]
	 *   Ԥ�����ַ��ࣺ
	 *            .:���������ַ�
	 *            \d:0-9
	 *            \D:[^0-9]
	 *            \s:�հ��ַ�
	 *            \w:�����ַ� [0-9A-Za-z_]
	 *    �߽�ƥ������
	 *            ^:��ͷ
	 *            $:��β
	 *            \b:���ʱ߽�,���ǵ����ַ��� Hello World?haha!
	 *    �����ʣ�
	 *         ����0��1
	 *         *:0����
	 *         +:1����
	 *         {n}:n��
	 *         {n,}:����n��
	 *         {n,m}:����n������m��
	 *    ������
	 *         �жϹ��ܣ�String���е�boolean matches(String regex)
	 *         �ָ�ܣ�String���е�String[] split(String regex)
	 *         �滻���ܣ�String���е�String replaceAll(String regex,String replacement)
	 *         ��ȡ���ܣ�Pattern:ģʽ����  Matcher:ƥ��������
	 *                     Pattern p = Pattern.compile("a*b")
	 *                     Matcher m = p.matcher("acccccb")
	 *                     boolean b = m.matches()
	 *                     
	 *                     Matcher�����find() boolean find():�Ƿ���ƥ����
	 *                                       group() String group():����ƥ��Ľ��
	 *                     
	 *         
	 */
	public static void main(String[] args) {
//         Scanner sc = new Scanner(System.in);
//         System.out.println("������һ��QQ�ţ�");
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
		
		   //ģʽ����
//         	 Pattern p = Pattern.compile("a*b");
//           
//           //ƥ��������
//           Matcher m = p.matcher("aaaaab");
//           
//           boolean flag = m.matches();
//           
//           System.out.println(flag);
           
		      String s = "hello world java";
		      
		      //ע��ƥ��ĵ��ʱ߽�
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
