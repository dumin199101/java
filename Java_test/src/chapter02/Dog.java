package chapter02;

public class Dog extends Animal implements JumpImpl {
	
	//���췽����
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
		System.out.println("����ѵ���Ĺ���������");

	}

	

	@Override
	public void eat() {
		// TODO Auto-generated method stub
		System.out.println("���Թ�ͷ");

	}

}
