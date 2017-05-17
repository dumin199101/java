package day01;

import org.junit.Test;

/**
 * ö�٣�ö���д洢�˸����ʵ��������
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
		 
		 //�൱��ö�ٵĶ���
    	 A("90-100"){
    		 public String getLocalValue(){
    			 return "��";
    		 }
    	 },B("80-90"){
    		 public String getLocalValue(){
    			 return "��";
    		 }
    	 },C("70-80"){
    		 public String getLocalValue(){
    			 return "��";
    		 }
    	 },D("60-70"){
    		 public String getLocalValue(){
    			 return "��";
    		 }
    	 };
    	 
    	 private Grade(){
    		 
    	 }
    	 
    	 private String value;
    	 
    	 //���췽��˽��
    	 private Grade(String value){
    		 this.value = value;
    	 }
    	 
    	 public String getValue(){
    		 
    		 return this.value;
    		 
    	 }
    	 
    	 //����һ�����󷽷���
    	 public abstract String getLocalValue();
    	 
    	 
    	 
     }
     
}
