package chapter01;

public class Person {
     //成员变量：
	   protected int age;
	   protected String name;
	   protected String sex;
	   
	   //无参构造：
		public Person() {
			super();
			// TODO Auto-generated constructor stub
		}

		//带参构造
		public Person(int age, String name, String sex) {
			super();
			this.age = age;
			this.name = name;
			this.sex = sex;
		}

		//成员方法：
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

		public String getSex() {
			return sex;
		}

		public void setSex(String sex) {
			this.sex = sex;
		}
		
		public void show(){
			
			System.out.println("姓名："+this.name+",年龄："+this.age+",性别："+this.sex);
			
		}
		
		
		
		
		
	   
	   
}




