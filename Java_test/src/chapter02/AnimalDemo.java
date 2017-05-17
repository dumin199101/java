package chapter02;

public class AnimalDemo {
	public static void main(String[] args) {
        
		//抽象类多态：实例化狗，向上转型：父类引用指向子类对象
		Animal dog = new Dog();
		
		dog.setAge(10);
		dog.setName("黄黄");
		dog.setColor("黄色");
		
		System.out.println("狗狗的基本信息如下：\n名字："+dog.getName()+",年龄："+dog.getAge()+",颜色："+dog.getColor());
		
		
		//多态的扩展性：
		dog = new Dog("小红", 5, "红色");
		
		dog.show();
		
		dog.eat();
		
		System.out.println("最终方法调用：");
		dog.see();
		
		System.out.println("静态方法：对象调用：");
		dog.sleep(); 
		
		System.out.println("静态方法：类调用：");
		Dog.sleep();
		
		//多态中对象的特有方法调用：向下转型：将父类引用强转为子类对象：
		Dog d = (Dog) dog;
		
		System.out.println("接口实现子类特有功能：");
		d.jump();
		
		//访问静态变量：
		System.out.println("静态常量："+Dog.country);
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	}
}
