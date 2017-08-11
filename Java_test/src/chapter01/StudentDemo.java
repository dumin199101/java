package chapter01;

public class StudentDemo {
    public static void main(String[] args) {
		Student s = new Student(22,"杜民","男");
		s.show();
		System.out.println("---------------------");
		System.out.println("姓名"+s.getName()+"，年龄："+s.getAge()+",性别:"+s.getSex());
		System.out.println("------------------");
	    Student.sleep(); //类名调用静态方法
	    s.sleep();  //对象调用静态方法
	    
	     //这个可以调用是通过以创建的类来调用的
	    System.out.println(s.address);
	}
}
