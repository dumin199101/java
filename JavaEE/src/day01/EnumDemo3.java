package day01;

import org.junit.Test;

/**
 * 使用枚举实现一个星期的枚举
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
		Monday("星期一"), Tuesday("星期二"), Wednesday("星期三"), Thursday("星期四"), Friday("星期五"), Saturday("星期六"), Sunday("星期天");

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
