
interface Animal {  //定义Animal接口
	void shout();

}

class Dog implements Animal {             //定义dog类实现animal接口
	public void shout() {             //实现shout方法
		System.out.println("汪汪汪……");
	}
}

public class Cat implements Animal {           //定义cat类实现animal接口
	public void shout() {                  //实现shout方法
		System.out.println("喵喵……");
	}

}

import java.util.Scanner;

public class Example06 {

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		//String str=sc.nextLine();
		Dog dog=new Dog();
		Animal an1=new Cat();
		Animal an2=new Dog();
		animalShout(an1);
		animalShout(an2);
//		dog.run();
//		dog.breathe();
//		dog.liveOnland();

	}
	public static void animalShout(Animal an) {
		an.shout();
	}

}
