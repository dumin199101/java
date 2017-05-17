package itcast_01;


//½Ó¿Ú£º
interface Person{
	
	public abstract void show();
	
}

class Student implements Person{
	
	 @Override
	public void show() {
		// TODO Auto-generated method stub
	       System.out.println("study");	
	}
	 
	 
	 
	
	
	
}



public class InnerDemo2 {
	
	public static void main(String[] args) {
		
	       Student s = new Student();
	       
	       s.show();
	       
	       System.out.println("--------------------");
	       
	       
	       Person p = new Person() {
			
				@Override
				public void show() {
					 System.out.println("studys");
				}
		   };
		   
		   p.show();
	       
		
	}

}
