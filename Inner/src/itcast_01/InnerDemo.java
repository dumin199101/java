package itcast_01;

class Outer{
	
	  private int num = 10;
	  
	  private static int num2 = 100;
	
	 //成员内部类
	   public class Inner{
		   
		    public void show(){
		    	
		    	 System.out.println("Inner");
		    	
		    	
		    	
		    }
		   
	   }
	   
	   public void method(){
		   
		     Inner i = new Inner();
		     
		     i.show();
		   
	   }
	   
	   //为了安全性使用private修饰：
	   private class Inner2{
		   
		     public void show(){
		    	 
		    	     System.out.println("Inner2_private");
		    	 
		     }
		   
		   
	   }
	   
	   public void method2(){
		   
		     Inner2 i = new Inner2();
		     
		     i.show();
		   
	   }
	   
	   //静态内部类：
	   public static class Inner3{
		   
		      
		     public static void show(){
		    	 
		    	   System.out.println(num2);
		    	 
		     }
		     
		     
		     public void show1(){
		    	 
		    	  System.out.println(num2);
		    	 
		     }
		   
		   
	   }
	   
	   //成员内部类：
	   public void method3(){
		   
		     //内部类访问局部变量必须加final修饰
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


//测试类：
public class InnerDemo {
	
	 
	
	
	public static void main(String[] args) {
       
		  
		  //调用：
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
		  
		  //静态直接通过类名调用
		  Outer.Inner3.show();
		  
		  oi2.show1();
		  
		  System.out.println("------------------------");
		  
		  
		  o.method3();
		  
		  System.out.println("------------------------");
		  
		  
		  
		  
		  
		  
		  
		  
		  
		  
		  
		
	}
}

