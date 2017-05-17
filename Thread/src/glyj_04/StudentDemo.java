package glyj_04;
/**
 * 同一个数据出现多次：
 *     线程运行需要很少的时间片，get执行多次，set才执行一次
 *     解决：等待唤醒机制：set一次，get一次
 * 姓名跟年龄不匹配：
 *     线程运行的随机性
 *     解决：加锁
 * 解决：加锁
 *   不同种类的线程要加同一把锁
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
