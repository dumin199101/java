package itcast_01;

/*
 * Object clone()
 * int hashCode()
 * Class getClass()
 *         String  getName()
 * boolean equals():默认比较地址值
 * toString()
 * protected void finalize() :Exception:Throwable
 * protected Object clone(): interface:Cloneable Exception:cloneNotSupportedException
 *          
 */

public class ObjectDemo{
	
	
	
	public static void main(String[] args) throws CloneNotSupportedException {
          Stduent s = new Stduent();
          
          s.setName("杜民");
          s.setAge(24);
          s.setSex("男");
          
          
          
          //未重写toString方法：itcast_01.Stduent@1925a19
//          System.out.println(s);
          
          //重写toString
          System.out.println(s); //Stduent [name=杜民, age=24, sex=男]
          
          System.out.println("----------------");
          
          //根据地址值来计算出来的hash值，数据类型为整型
          System.out.println(s.hashCode());  //26368537
          
          System.out.println("---------------------");
          
          System.out.println(s.getClass().getName());
          
          System.out.println("---------------------");
          
          //未重写toString
          System.out.println(s.getClass().getName() + "@" + Integer.toHexString(s.hashCode()));
          
          
          System.out.println("---------------");
          
          
//          try {
//			s.finalize();
//		} catch (Throwable e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
          
          //clone方法返回的是Object类型：
          
          //多态方式接收：
//          Object s1 =  s.clone();
          
          //clone接收
          Stduent s1 = (Stduent) s.clone();
          
          System.out.println(s1);
          
          s.setAge(23);
          
          System.out.println(s);
          
          System.out.println(s1);
          
          //引用赋值：
          Stduent s3 = s;
          
          System.out.println(s3);
          
          
          
          
	}
}
