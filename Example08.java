
abstract class Animal {  //定义抽象类
	abstract void shout();  //定义抽象方法

}

public class Dog extends Animal {

	void shout() {		//实现抽象方法
		System.out.println("汪汪汪……");
	}
}
import java.util.Scanner;

public class Example06 {

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		//String str=sc.nextLine();
		Dog dog=new Dog();
		dog.shout();

	}

}
