package day01;

import org.junit.Test;

/**
 * ʹ��ö��ʵ��һ�����ڵ�ö��
 * 
 * @author Administrator
 * 
 */
public class EnumDemo3 {
	@Test
	public void test() {
          print(Week.Monday);
          
	}
	
	public void print(Week w){
		
		System.out.println(w.getLocalName(w));
		
	}

	enum Week {
		Monday("����һ"), Tuesday("���ڶ�"), Wednesday("������"), Thursday("������"), Friday("������"), Saturday("������"), Sunday("������");

		private Week() {
		}

		private String localName;

		private Week(String localName) {
			this.localName = localName;
		}

		public  String getLocalName(Week w) {
			return this.localName;
		}

	}
}
