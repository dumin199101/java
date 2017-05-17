package glyj_04;

public class GetThread implements Runnable{
	
	Student s;
	

	
	public GetThread(Student s){
		
		this.s = s;
		
	}
	
	@Override
	public void run() {
		
		
		while(true){
			
			
			 synchronized (s) {
				 
				 //消费者:有就等待
				 
				 if(!s.flag){
					 
					 try {
						s.wait();
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					 
				 }
				 
				 System.out.println("姓名：" + s.name+",年龄：" + s.age);
				
			}
			 
			 
			 
			 
		
			
			
			
		}
		
		
		
		 
		 
		
		
		
		   
		
		
		
		
	}
	
	
	
	
	

}
