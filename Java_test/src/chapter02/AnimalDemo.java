package chapter02;

public class AnimalDemo {
	public static void main(String[] args) {
        
		//�������̬��ʵ������������ת�ͣ���������ָ���������
		Animal dog = new Dog();
		
		dog.setAge(10);
		dog.setName("�ƻ�");
		dog.setColor("��ɫ");
		
		System.out.println("�����Ļ�����Ϣ���£�\n���֣�"+dog.getName()+",���䣺"+dog.getAge()+",��ɫ��"+dog.getColor());
		
		
		//��̬����չ�ԣ�
		dog = new Dog("С��", 5, "��ɫ");
		
		dog.show();
		
		dog.eat();
		
		System.out.println("���շ������ã�");
		dog.see();
		
		System.out.println("��̬������������ã�");
		dog.sleep(); 
		
		System.out.println("��̬����������ã�");
		Dog.sleep();
		
		//��̬�ж�������з������ã�����ת�ͣ�����������ǿתΪ�������
		Dog d = (Dog) dog;
		
		System.out.println("�ӿ�ʵ���������й��ܣ�");
		d.jump();
		
		//���ʾ�̬������
		System.out.println("��̬������"+Dog.country);
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	}
}
