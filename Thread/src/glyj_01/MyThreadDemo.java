package glyj_01;

public class MyThreadDemo {
      public static void main(String[] args) {
		
    	   MyThread mt = new MyThread();
    	   
    	   MyThread mt2 = new MyThread();
    	   
    	   mt.start();
    	   
    	   mt2.start();
    	   
    	   
    	   System.out.println("���߳�:"+Thread.currentThread().getName());
    	  
	  }
}
