package glyj_04;

public class SetThread implements Runnable{
	
	 Student s;
	 
	 int x = 0;
	
	 public SetThread(Student s){
		 
          this.s = s;
		 
		 
		 
	 }
	
	  @Override
		public void run() {
		     
		     
		    while(true){
		    	
		    	synchronized (s) {
		    		
		    		//生产者：有就等待：
		    		
		    		if(s.flag){
		    			
		    			try {
							s.wait();
						} catch (InterruptedException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
		    			
		    		}
		    		
		    		if(x%2==0){
			    		
			    		 
			    		 s.name = "杜民";
			    		 
			    		 s.age = 24;
			    		
			    		
			    		
			    	}else{
			    		
			    		s.name = "dumin";
			    		
			    		s.age = 22;
			    		
			    		
			    		
			    	}
			    	
			    	x++;
			    	
			    	//修改标记为真
			    	s.flag = true;
			    	
			    	
			    	//通知生产者来消费
			        s.notify();
			    	
			    	
		    		
		    		
					
				}
		    	
		    	
		    	
		    	
		    }
		  
		    
		  
			
		}

}
