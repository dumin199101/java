package itcast_01;

/**
 * 基类：人
 * 
 * @author Administrator
 * 
 */
public class Person {
	private int age;
	private String name;
	private String addr;

	public Person() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Person(int age, String name, String addr) {
		super();
		this.age = age;
		this.name = name;
		this.addr = addr;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddr() {
		return addr;
	}

	public void setAddr(String addr) {
		this.addr = addr;
	}

	@Override
	public String toString() {
		return "Person [age=" + age + ", name=" + name + ", addr=" + addr + "]";
	}
	
	//public方法
	public void show1(){
		 System.out.println("public");
	}
	
	//默认方法
	void show2(){
		System.out.println("friendly");
	}
	
	//protected方法
	protected void show3(){
		System.out.println("protected");
	}
	
	private static void show4(){
		System.out.println("private");
	}
	

}
