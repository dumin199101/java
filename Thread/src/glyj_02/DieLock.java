package glyj_02;
/**
 * ���߳�����������
 *    1.����������ͬ�������������Ƕ�����õ���ͬһ��������
 *    2.ͬ����Ƕ�ף������߳�ִ�й�������������Դ���໥�ȴ�
 * @author Administrator
 *
 */
public class DieLock  extends Thread{
	
	  
	  private boolean flag;
	 
	  public DieLock(boolean flag){
		  
		   this.flag = flag;
		 
	  }
	  
	  @Override
		public void run() {
		  
		     while(true){
		    	 
		    	 
		    	 if(flag==true){
			    	 
		    	      synchronized (MyLock.LockA) {
		    	    	  
		    	    	   System.out.println("if LockA");
		    	    	   
		    	    	   synchronized (MyLock.LockB) {
		    	    		    
		    	    		    System.out.println("if LockB");
							
						   }
		    	    	   
						
					  }
		    	 
		    	 
			     }else{
			    	 
			    	 synchronized (MyLock.LockB) {
		    	    	  
		    	    	   System.out.println("else LockB");
		    	    	   
		    	    	   synchronized (MyLock.LockA) {
		    	    		    
		    	    		    System.out.println("else LockA");
							
						   }
		    	    	   
						
					  }
			    	 
			    	 
			    	 
			    	 
			    	 
			     }
		    	 
		    	 
		    	 
		     }
		  
		     
		  
		   
			
		  
		  
		  
		}

	  
	
}
