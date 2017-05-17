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
		System.out.println("不带返回值的成员方法");
	}
	
	public int show2(int i){
		System.out.println("带返回值的成员方法");
		return i;
	}
	
	private void show3(){
		System.out.println("私有的成员方法");
	}
	
	public static void show4(){
		System.out.println("静态成员方法");
	}
	
	public static void main(String[] args) {
		System.out.println("main方法");
	}
	

}
