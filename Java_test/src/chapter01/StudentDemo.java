package chapter01;

public class StudentDemo {
    public static void main(String[] args) {
		Student s = new Student(22,"����","��");
		s.show();
		System.out.println("---------------------");
		System.out.println("����"+s.getName()+"�����䣺"+s.getAge()+",�Ա�:"+s.getSex());
		System.out.println("------------------");
	    Student.sleep(); //�������þ�̬����
	    s.sleep();  //������þ�̬����
	    
	     //������Ե�����ͨ���Դ������������õ�
	    System.out.println(s.address);
	}
}
