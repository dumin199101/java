package glyj_04;
/**
 * ͬһ�����ݳ��ֶ�Σ�
 *     �߳�������Ҫ���ٵ�ʱ��Ƭ��getִ�ж�Σ�set��ִ��һ��
 *     ������ȴ����ѻ��ƣ�setһ�Σ�getһ��
 * ���������䲻ƥ�䣺
 *     �߳����е������
 *     ���������
 * ���������
 *   ��ͬ������߳�Ҫ��ͬһ����
 * 
 * @author Administrator
 *
 */
public class StudentDemo {
	
	public static void main(String[] args) {
		
		 Student s = new Student();
		 
		 GetThread gt = new GetThread(s);
		 
		 SetThread st = new SetThread(s);
		 
		 
		 Thread t = new Thread(gt);
		 
		 Thread t2 = new Thread(st);
		 
		 
		 t.start();
		 
		 t2.start();
		
		
		
		
	}
	

}
