package MyThread2;

public class MyThreadDemo2 {
	
	public static void main(String[] args) {
		
		//½Ó¿Ú¶àÌ¬£º
		
		Runnable mt = new MyThread2();
		
		Thread t = new Thread(mt,"good");
		
		Thread t2 = new Thread(mt,"study");
		
		t.start();
		t2.start();
		
		
	}

}
