
public class Animal {
	
	public Animal() {    //�޲�Animal���췽��
		System.out.println("����һֻ����");
	}
	public Animal(String name) {   //����Animal�вι��췽��
		System.out.println("����һֻ"+name);
	}

}

public class Dog extends Animal {

	void shout() {		
		System.out.println("����������");
	}
	public Dog(String name) {
		super(name);
	}
	public Dog() {
		
	}

}
import java.util.Scanner;

public class Example06 {

	public static void main(String[] args) {
		// TODO �Զ����ɵķ������
		Scanner sc=new Scanner(System.in);
		String str=sc.nextLine();
		Dog dog=new Dog(str);
		dog.shout();

	}

}
