package glyj_treeset;

import java.util.Comparator;
import java.util.TreeSet;

public class TreeSetDemo {
	public static void main(String[] args) {
        TreeSet<Student> ts = new  TreeSet<Student>(new Comparator<Student>() {
        	
        	 @Override
        	public int compare(Student o1, Student o2) {
        		// TODO Auto-generated method stub
        		int result = Integer.parseInt(o1.getAge()) - Integer.parseInt(o2.getAge());
        		
        		return result;
        	}
        	
        	
		});
        
        
        Student s1 = new Student("22","dumin");
        Student s2 = new Student("20","dumin2");
        Student s3 = new Student("2","dumin3");
		
		Student s4 = new Student();
		s4.setName("dumin4");
		s4.setAge("2");
        
        ts.add(s1);
        ts.add(s2);
        ts.add(s3);
		ts.add(s4);
        
        for(Student s : ts){
        	
        	System.out.println(s.getName()+"----"+s.getAge());
        	
        }
        
        
	}
}
