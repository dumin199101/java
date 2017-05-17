package Thread;

public class MyThread extends Thread{
	
	//构造方法：
	public  MyThread(){
		super();
	}
	
	public MyThread(String name){
		 super(name);
	}
	
	
	
	//重写run方法
	public void run(){
		
		for(int x=0;x<200;x++){
			
			System.out.println("线程名："+Thread.currentThread().getName() +",当前数值："+x);
			
		}
		
	}
}
