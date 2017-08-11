package itcast_01;

class Outer{
	
	  private int num = 10;
	  
	  private static int num2 = 100;
	
	 //��Ա�ڲ���
	   public class Inner{
		   
		    public void show(){
		    	
		    	 System.out.println("Inner");
		    	
		    	
		    	
		    }
		   
	   }
	   
	   public void method(){
		   
		     Inner i = new Inner();
		     
		     i.show();
		   
	   }
	   
	   //Ϊ�˰�ȫ��ʹ��private���Σ�
	   private class Inner2{
		   
		     public void show(){
		    	 
		    	     System.out.println("Inner2_private");
		    	 
		     }
		   
		   
	   }
	   
	   public void method2(){
		   
		     Inner2 i = new Inner2();
		     
		     i.show();
		   
	   }
	   
	   //��̬�ڲ��ࣺ
	   public static class Inner3{
		   
		      
		     public static void show(){
		    	 
		    	   System.out.println(num2);
		    	 
		     }
		     
		     
		     public void show1(){
		    	 
		    	  System.out.println(num2);
		    	 
		     }
		   
		   
	   }
	   
	   //��Ա�ڲ��ࣺ
	   public void method3(){
		   
		     //�ڲ�����ʾֲ����������final����
		     final int num4 = 1000;
		   
		     class Inner{
		    	 
		    	   public void show3(){
		    		   
		    		    System.out.println(num4);
		    		   
		    	   }
		    	 
		     }
		     
		     Inner i = new Inner();
		     
		     i.show3();
		    
		   
		   
	   }
	
	
}


//�����ࣺ
public class InnerDemo {
	
	 
	
	
	public static void main(String[] args) {
       
		  
		  //���ã�
		  Outer.Inner oi = new Outer().new Inner();
		  
		  oi.show();
		  
		  System.out.println("--------------------");
		
		  Outer o = new Outer();
		  
		  o.method();
		  
		  System.out.println("-------------------");
		  
		  o.method2();
		  
		  
		  System.out.println("-------------------");
		  
		  
		  Outer.Inner3 oi2 = new Outer.Inner3();
		  
//		  oi2.show();
		  
		  //��ֱ̬��ͨ����������
		  Outer.Inner3.show();
		  
		  oi2.show1();
		  
		  System.out.println("------------------------");
		  
		  
		  o.method3();
		  
		  System.out.println("------------------------");
		  
		  
		  
		  
		  
		  
		  
		  
		  
		  
		  
		
	}
}

