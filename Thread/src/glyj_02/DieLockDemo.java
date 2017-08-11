package glyj_02;

public class DieLockDemo {
	
	public static void main(String[] args) {
		
		 
		 
		 
		 DieLock lock = new DieLock(true);

		 DieLock lock2 = new DieLock(false);
		 
		 lock.start();
		 
		 lock2.start();
		 
		 
		
		
	}

}
