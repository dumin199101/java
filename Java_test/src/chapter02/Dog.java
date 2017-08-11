package chapter02;

public class Dog extends Animal implements JumpImpl {
	
	//构造方法：
	public Dog() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Dog(String name, int age, String color) {
		super(name, age, color);
		// TODO Auto-generated constructor stub
	}
	

	@Override
	public void jump() {
		// TODO Auto-generated method stub
		System.out.println("经过训练的狗可以跳高");

	}

	

	@Override
	public void eat() {
		// TODO Auto-generated method stub
		System.out.println("狗吃骨头");

	}

}
