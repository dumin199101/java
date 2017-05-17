package chapter02;

public abstract class Animal {
      //成员变量：
	  private String name;
	  private int age;
	  private String color;
	  
	  //静态变量：
	  public static String country = "china";
	  
	  //final常量：只能被赋值一次
	  public final String str = "good good study,day day up";
	  
	  //构造代码块：在构造方法之前执行：
	  {
		  System.out.println("抽象类构造方法执行前：");
	  }
	  
	  //静态代码块：
	  static {
		  System.out.println("静态代码块随着类加载而加载");
	  }
	
	  
	  
	  //构造方法：
	  public Animal() {
			super();  //调用父类的无参构造：
			// TODO Auto-generated constructor stub
	  }
	  
		public Animal(String name, int age, String color) {
			super();
			this.name = name;
			this.age = age;
			this.color = color;
		}
		
		//成员方法：
		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}

		public int getAge() {
			return age;
		}

		public void setAge(int age) {
			this.age = age;
		}

		public String getColor() {
			return color;
		}

		public void setColor(String color) {
			this.color = color;
		}
		
		public void show(){
			//局部代码块：
			{
//				System.out.println("abc");
				System.out.println(this.str);
			}
			
			System.out.println("动物的名字："+this.name+"，动物的年龄："+age+"，动物的颜色："+this.color);
			
		}
		
		
		
		//抽象方法：
		public abstract void eat();
		
		
		//静态方法：
		public static void sleep(){
			//静态方法中：不能直接访问非静态成员,不能使用this或者super  //静态方法是属于类的而不是属于某一个成员的
//			System.out.println(this.age);
			System.out.println(Animal.country);
			System.out.println("吃完饭要睡觉！");
		}
		
		//最终方法：不允许子类重写：
		public  final void see(){
			 System.out.println("动物可以看东西");
		}
		
		
	  
	  
}
