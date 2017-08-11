package chapter01;

public class Student extends Person {
	
	public static String address="山东省";
	
    public Student() {
		super();
		// TODO Auto-generated constructor stub
		//this.address = "山东省";
	}

	public Student(int age, String name, String sex) {
		super(age, name, sex);
		// TODO Auto-generated constructor stub
		this.address = "淄博市";
	}

	public void eat(){
    	
    	System.out.println("学生要吃饭");
    	
    }
	
	public static void sleep(){
		
		//静态方法中只能调用静态成员
		
		System.out.println("您的地址太远了，"+address);
		
		System.out.println("睡觉");
	}
}


