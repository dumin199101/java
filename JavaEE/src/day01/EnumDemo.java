package day01;

import org.junit.Test;

/**
 * 枚举：枚举中存储了该类的实例化对象
 * @author Administrator
 *
 */
public class EnumDemo {
     
	 @Test
	 public void test(){
		 print(Grade.B);
	 }
	
	 public void print(Grade g){
		 

		 System.out.println(g.getLocalValue());
		 
	 }
	
	 enum Grade{
		 
		 //相当于枚举的对象
    	 A("90-100"){
    		 public String getLocalValue(){
    			 return "优";
    		 }
    	 },B("80-90"){
    		 public String getLocalValue(){
    			 return "良";
    		 }
    	 },C("70-80"){
    		 public String getLocalValue(){
    			 return "中";
    		 }
    	 },D("60-70"){
    		 public String getLocalValue(){
    			 return "差";
    		 }
    	 };
    	 
    	 private Grade(){
    		 
    	 }
    	 
    	 private String value;
    	 
    	 //构造方法私有
    	 private Grade(String value){
    		 this.value = value;
    	 }
    	 
    	 public String getValue(){
    		 
    		 return this.value;
    		 
    	 }
    	 
    	 //定义一个抽象方法：
    	 public abstract String getLocalValue();
    	 
    	 
    	 
     }
     
}
