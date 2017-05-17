package day01;

import java.beans.BeanInfo;
import java.beans.IntrospectionException;
import java.beans.Introspector;
import java.beans.PropertyDescriptor;
import java.lang.reflect.Method;

import org.junit.Test;

/**
 *  Java��ʡ
 * @author Administrator
 *
 */
public class IntrospectorDemo {
    
	/**
	 * ��ȡJavaBean���е����ԣ�
	 * @throws Exception 
	 */
	@Test
	public void test1() throws Exception{
    	
//		BeanInfo info = Introspector.getBeanInfo(Person.class);
		BeanInfo info = Introspector.getBeanInfo(Person.class,Object.class);
		
		PropertyDescriptor[] pds = info.getPropertyDescriptors();
		
		for(PropertyDescriptor pd : pds){
			
			System.out.println(pd.getName());
			
		}
			
    }
	
	/**
	 * ����Bean��ָ�����ԣ�
	 * @throws Exception 
	 */
	
	@Test
	public void test2() throws Exception{
		
		Person p = new Person();
		
		PropertyDescriptor pd = new PropertyDescriptor("age", Person.class);
		
		Method method = pd.getWriteMethod();  //��ȡset������
		
		method.invoke(p, 23);
		
		Method method2 = pd.getReadMethod();  //get����
		
		int age = (int) method2.invoke(p);
		
		System.out.println(age);
		
		
		
	}
	
	@Test
	public void test3() throws Exception{
		
		PropertyDescriptor pd = new PropertyDescriptor("age",Person.class);
		
		Class type = pd.getPropertyType();
		
		System.out.println(type.getName());
		
		
		
		
	}
	
}
