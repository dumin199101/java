package Thread;

public class MyThread extends Thread{
	
	//���췽����
	public  MyThread(){
		super();
	}
	
	public MyThread(String name){
		 super(name);
	}
	
	
	
	//��дrun����
	public void run(){
		
		for(int x=0;x<200;x++){
			
			System.out.println("�߳�����"+Thread.currentThread().getName() +",��ǰ��ֵ��"+x);
			
		}
		
	}
}
