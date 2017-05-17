package day01;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;

import org.junit.Test;

//反射：字段
public class ReflectDemo2 {
    @Test
	public void testField() throws Exception{
    	
    	Class c = Class.forName("day01.Person");
    	
    	Constructor con =  c.getConstructor(int.class,String.class);
    	
    	Person p = (Person) con.newInstance(22,"dumin");
    	
    	Field field = c.getDeclaredField("age");
    	
    	field.setAccessible(true);
    	
    	int age = (int) field.get(p);
    	
    	System.out.println(age);
    	
    	field.set(p, 24);
    	
    	System.out.println(p.getAge());
    	
    	System.out.println("------------------------------------");
    	
    	//静态成员
    	Field field2 = c.getField("tel");
    	
    	int tel = (int) field2.get(p);
    	
    	System.out.println(tel);
    	
    	System.out.println("-----------------------------------------");
    	
    	//获取字段的类型：
    	Class fieldType = field2.getType();
    	
    	System.out.println(fieldType.getName());
    	
    }
}
