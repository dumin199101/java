package chapter02;

public abstract class Animal {
      //��Ա������
	  private String name;
	  private int age;
	  private String color;
	  
	  //��̬������
	  public static String country = "china";
	  
	  //final������ֻ�ܱ���ֵһ��
	  public final String str = "good good study,day day up";
	  
	  //�������飺�ڹ��췽��֮ǰִ�У�
	  {
		  System.out.println("�����๹�췽��ִ��ǰ��");
	  }
	  
	  //��̬����飺
	  static {
		  System.out.println("��̬�������������ض�����");
	  }
	
	  
	  
	  //���췽����
	  public Animal() {
			super();  //���ø�����޲ι��죺
			// TODO Auto-generated constructor stub
	  }
	  
		public Animal(String name, int age, String color) {
			super();
			this.name = name;
			this.age = age;
			this.color = color;
		}
		
		//��Ա������
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
			//�ֲ�����飺
			{
//				System.out.println("abc");
				System.out.println(this.str);
			}
			
			System.out.println("��������֣�"+this.name+"����������䣺"+age+"���������ɫ��"+this.color);
			
		}
		
		
		
		//���󷽷���
		public abstract void eat();
		
		
		//��̬������
		public static void sleep(){
			//��̬�����У�����ֱ�ӷ��ʷǾ�̬��Ա,����ʹ��this����super  //��̬������������Ķ���������ĳһ����Ա��
//			System.out.println(this.age);
			System.out.println(Animal.country);
			System.out.println("���극Ҫ˯����");
		}
		
		//���շ�����������������д��
		public  final void see(){
			 System.out.println("������Կ�����");
		}
		
		
	  
	  
}
