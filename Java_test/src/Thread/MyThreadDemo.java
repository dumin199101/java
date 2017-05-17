package Thread;

public class MyThreadDemo {
	public static void main(String[] args) {
		//创建多线程对象：
		MyThread mt = new MyThread();
		MyThread mt2 = new MyThread("杜民");
		
		mt.setName("dumin");
		
		//
		
		//启动
		mt.start();
		mt2.start();
		
		
	}

}
