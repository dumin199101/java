package Thread;

public class MyThreadDemo {
	public static void main(String[] args) {
		//�������̶߳���
		MyThread mt = new MyThread();
		MyThread mt2 = new MyThread("����");
		
		mt.setName("dumin");
		
		//
		
		//����
		mt.start();
		mt2.start();
		
		
	}

}
