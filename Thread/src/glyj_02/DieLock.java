package glyj_02;
/**
 * 多线程死锁分析：
 *    1.两个锁对象不同，但是锁对象的嵌套中用到了同一个锁对象
 *    2.同步的嵌套，导致线程执行过程中因争夺资源而相互等待
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
