package itcast_01;

public class Student extends Person {
    //Ñ§ºÅ 
	private int sno;
	//°à¼¶
	private String school;
	
		
	public int getSno() {
		return sno;
	}
	public void setSno(int sno) {
		this.sno = sno;
	}
	public String getSchool() {
		return school;
	}
	public void setSchool(String school) {
		this.school = school;
	}
	
    @Override
    public void show1() {
    	// TODO Auto-generated method stub
    	super.show1();
    	System.out.println("zi-public");
    }
    
    @Override
    void show2() {
    	// TODO Auto-generated method stub
    	super.show2();
    	System.out.println("zi-friendly");
    }
    
    @Override
    protected void show3() {
    	// TODO Auto-generated method stub
    	super.show3();
    	System.out.println("zi-protected");
    }
    
    private void show4() {
		// TODO Auto-generated method stub
    	System.out.println("zi-private");
	}
	
}
