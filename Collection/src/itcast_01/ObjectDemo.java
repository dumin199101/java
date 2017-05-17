package itcast_01;

/*
 * Object clone()
 * int hashCode()
 * Class getClass()
 *         String  getName()
 * boolean equals():Ĭ�ϱȽϵ�ֵַ
 * toString()
 * protected void finalize() :Exception:Throwable
 * protected Object clone(): interface:Cloneable Exception:cloneNotSupportedException
 *          
 */

public class ObjectDemo{
	
	
	
	public static void main(String[] args) throws CloneNotSupportedException {
          Stduent s = new Stduent();
          
          s.setName("����");
          s.setAge(24);
          s.setSex("��");
          
          
          
          //δ��дtoString������itcast_01.Stduent@1925a19
//          System.out.println(s);
          
          //��дtoString
          System.out.println(s); //Stduent [name=����, age=24, sex=��]
          
          System.out.println("----------------");
          
          //���ݵ�ֵַ�����������hashֵ����������Ϊ����
          System.out.println(s.hashCode());  //26368537
          
          System.out.println("---------------------");
          
          System.out.println(s.getClass().getName());
          
          System.out.println("---------------------");
          
          //δ��дtoString
          System.out.println(s.getClass().getName() + "@" + Integer.toHexString(s.hashCode()));
          
          
          System.out.println("---------------");
          
          
//          try {
//			s.finalize();
//		} catch (Throwable e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
          
          //clone�������ص���Object���ͣ�
          
          //��̬��ʽ���գ�
//          Object s1 =  s.clone();
          
          //clone����
          Stduent s1 = (Stduent) s.clone();
          
          System.out.println(s1);
          
          s.setAge(23);
          
          System.out.println(s);
          
          System.out.println(s1);
          
          //���ø�ֵ��
          Stduent s3 = s;
          
          System.out.println(s3);
          
          
          
          
	}
}
