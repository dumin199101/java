package MyThread2;

public class MyThread2 implements Runnable {

	@Override
	public void run() {
		// TODO Auto-generated method stub
		for(int x=0;x<200;x++){
			System.out.println("��ǰ���е��߳�����"+Thread.currentThread().getName()+",��ǰ��ӡ�����ݣ�"+x);
		}

	}

}
