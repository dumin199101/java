package day01;

import java.util.Date;

public class Person {
	private int age;
	private String name;
	private Date birthday;
	
	public Date getBirthday() {
		return birthday;
	}

	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}

	public static int tel=110;

	public Person() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	private Person(String name){
		
		super();
		
		this.name = name;
		
		
	}

	public Person(int age, String name) {
		super();
		this.age = age;
		this.name = name;
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

	@Override
	public String toString() {
		return "Person [age=" + age + ", name=" + name + "]";
	}
	
	public void show(){
		System.out.println("��������ֵ�ĳ�Ա����");
	}
	
	public int show2(int i){
		System.out.println("������ֵ�ĳ�Ա����");
		return i;
	}
	
	private void show3(){
		System.out.println("˽�еĳ�Ա����");
	}
	
	public static void show4(){
		System.out.println("��̬��Ա����");
	}
	
	public static void main(String[] args) {
		System.out.println("main����");
	}
	

}
