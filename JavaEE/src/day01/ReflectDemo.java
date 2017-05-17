package day01;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

import org.junit.Test;

/**
 * 
 * @author Administrator
 *
 */
public class ReflectDemo {
     @Test
	 public void testReflect() throws Exception{
    	  
    	  
    	  Class c1 = Class.forName("day01.Person");
    	  
    	  //访问带参构造：
    	  Constructor con = c1.getConstructor(int.class,String.class);
    	  
    	  Person p = (Person) con.newInstance(22,"dumin");
    	  
    	  System.out.println(p.getName());
    	  
    	  Constructor[] cons = c1.getConstructors();
    	  
    	  for(Constructor c : cons){
    		   
    		  System.out.println(c);
    		  
    	  }
    	  
    	  System.out.println("-----------------------------------");
    	  
    	  Constructor[] cons1  = c1.getDeclaredConstructors();
    	  
    	  for(Constructor con1 : cons1){
    		  
    		   System.out.println(con1);
    		  
    	  }
    	  
    	  //访问私有构造：
    	  Constructor con2 = c1.getDeclaredConstructor(String.class);
    	  
    	  con2.setAccessible(true);
    	  
    	  Person p2 = (Person) con2.newInstance("杜民");
    	  
    	  System.out.println(p2.getName());
    	  
    	  System.out.println("------------------------------------------------------------");
    	  
    	  //通过反射访问成员方法：
    	  
    	  Method m = c1.getMethod("show");
    	  
    	  m.invoke(p);
    	  
    	  Method m2 = c1.getMethod("show2", int.class);
    	  
    	  int i =(int) m2.invoke(p, 3);
    	  
    	  System.out.println(i);
    	  
    	  
    	  //私有的成员方法 设置访问权限
    	  Method m3 = c1.getDeclaredMethod("show3");
    	  
    	  m3.setAccessible(true);
    	  
    	  m3.invoke(p);
    	  
    	  //访问静态成员方法,不需要对象：
    	  Method m4 = c1.getMethod("show4");
    	  
    	  m4.invoke(null);
    	  
    	  
    	  //反射main方法,接收的参数是数组：
    	  Method m5 = c1.getMethod("main",String[].class);
    	  
    	  m5.invoke(null,(Object)new String[]{"a","b"});
    	  
    	  
    	  
    	  
    	  
     }
}
