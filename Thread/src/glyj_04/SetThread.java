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
		    		
		    		//�����ߣ��о͵ȴ���
		    		
		    		if(s.flag){
		    			
		    			try {
							s.wait();
						} catch (InterruptedException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
		    			
		    		}
		    		
		    		if(x%2==0){
			    		
			    		 
			    		 s.name = "����";
			    		 
			    		 s.age = 24;
			    		
			    		
			    		
			    	}else{
			    		
			    		s.name = "dumin";
			    		
			    		s.age = 22;
			    		
			    		
			    		
			    	}
			    	
			    	x++;
			    	
			    	//�޸ı��Ϊ��
			    	s.flag = true;
			    	
			    	
			    	//֪ͨ������������
			        s.notify();
			    	
			    	
		    		
		    		
					
				}
		    	
		    	
		    	
		    	
		    }
		  
		    
		  
			
		}

}
