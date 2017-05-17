package MyThread2;

public class MyThread2 implements Runnable {

	@Override
	public void run() {
		// TODO Auto-generated method stub
		for(int x=0;x<200;x++){
			System.out.println("当前运行的线程名："+Thread.currentThread().getName()+",当前打印的数据："+x);
		}

	}

}
