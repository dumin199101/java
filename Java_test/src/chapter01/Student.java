package chapter01;

public class Student extends Person {
	
	public static String address="ɽ��ʡ";
	
    public Student() {
		super();
		// TODO Auto-generated constructor stub
		//this.address = "ɽ��ʡ";
	}

	public Student(int age, String name, String sex) {
		super(age, name, sex);
		// TODO Auto-generated constructor stub
		this.address = "�Ͳ���";
	}

	public void eat(){
    	
    	System.out.println("ѧ��Ҫ�Է�");
    	
    }
	
	public static void sleep(){
		
		//��̬������ֻ�ܵ��þ�̬��Ա
		
		System.out.println("���ĵ�ַ̫Զ�ˣ�"+address);
		
		System.out.println("˯��");
	}
}


