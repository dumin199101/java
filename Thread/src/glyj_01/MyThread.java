package glyj_01;

public class MyThread extends Thread {
    
	     @Override
	    public void run() {
	    	
	    	 for(int x=0;x<400;x++){
	    		 
	    		 System.out.println("�߳�����"+ getName() +",���ݣ�"+x);
	    		 
	    	 }
	    	 
	    	 
	    }
	
	
}
