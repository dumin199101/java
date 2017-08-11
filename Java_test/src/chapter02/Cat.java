package chapter02;

public class Cat extends Animal {
	
	
    //构造方法：
	public Cat() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Cat(String name, int age, String color) {
		super(name, age, color);
		// TODO Auto-generated constructor stub
	}
	
	

	@Override
	public void eat() {
		// TODO Auto-generated method stub
		System.out.println("猫吃鱼");

	}

}
