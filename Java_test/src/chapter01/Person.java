package chapter01;

public class Person {
     //��Ա������
	   protected int age;
	   protected String name;
	   protected String sex;
	   
	   //�޲ι��죺
		public Person() {
			super();
			// TODO Auto-generated constructor stub
		}

		//���ι���
		public Person(int age, String name, String sex) {
			super();
			this.age = age;
			this.name = name;
			this.sex = sex;
		}

		//��Ա������
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
			
			System.out.println("������"+this.name+",���䣺"+this.age+",�Ա�"+this.sex);
			
		}
		
		
		
		
		
	   
	   
}




