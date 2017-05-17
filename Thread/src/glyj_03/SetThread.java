package glyj_03;

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
		    		
		    		if(x%2==0){
			    		
			    		 
			    		 s.name = "∂≈√Ò";
			    		 
			    		 s.age = 24;
			    		
			    		
			    		
			    	}else{
			    		
			    		s.name = "dumin";
			    		
			    		s.age = 22;
			    		
			    		
			    		
			    	}
			    	
			    	x++;
		    		
		    		
					
				}
		    	
		    	
		    	
		    	
		    }
		  
		    
		  
			
		}

}
