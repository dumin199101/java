package itcast_03;

public class Father {
      public void show(){
    	  System.out.println("public");
      }
      
      void show2(){
    	  System.out.println("friendly");
      }
      
      protected void show3(){
    	  System.out.println("protected");
      }
      
      private void show4(){
    	  System.out.println("private");
      }
      
      public static void main(String[] args) {
		   Father f = new Father();
		   f.show();
		   f.show2();
		   f.show3();
		   f.show4();
	  }
      
      
}
