package glyj_03;

public class GetThread implements Runnable{
	
	Student s;
	

	
	public GetThread(Student s){
		
		this.s = s;
		
	}
	
	@Override
	public void run() {
		
		
		while(true){
			
			
			 synchronized (s) {
				 
				 System.out.println("������" + s.name+",���䣺" + s.age);
				
			}
			 
			 
			 
			 
		
			
			
			
		}
		
		
		
		 
		 
		
		
		
		   
		
		
		
		
	}
	
	
	
	
	

}
