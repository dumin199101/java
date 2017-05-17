package itcast_04;

import itcast_03.Father;

public class Son extends Father {
     public static void main(String[] args) {
	     Father f = new Father();
	     f.show();
//	     f.show2();
//	     f.show3();

	     System.out.println("-------------------------------");
	     Son s = new Son();
	     s.show();
//	     s.show2();
	     s.show3();
	 }
}
