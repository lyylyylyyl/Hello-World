
public class Animal {
	
	public Animal() {    //无参Animal构造方法
		System.out.println("我是一只动物");
	}
	public Animal(String name) {   //定义Animal有参构造方法
		System.out.println("我是一只"+name);
	}

}

public class Dog extends Animal {

	void shout() {		
		System.out.println("汪汪汪……");
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
		// TODO 自动生成的方法存根
		Scanner sc=new Scanner(System.in);
		String str=sc.nextLine();
		Dog dog=new Dog(str);
		dog.shout();

	}

}
