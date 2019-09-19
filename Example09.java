
interface Animal {  //定义Animal接口
	int ID=1;  //定义全局变量
	void breathe();   //定义抽象方法
	void run();   //定义抽象方法

}

interface LabdAnimal extends Animal{   //接口继承接口
	void liveOnland();   //定义抽象方法

}

class Dog implements Animal {

	public void breathe() {  
		System.out.println("狗再呼吸");
	}
	public void run() {
		System.out.println("狗在跑");
	}
	public void liveOnland() {
		System.out.println("狗生活在陆地上");
	}
}
import java.util.Scanner;

public class Example06 {

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		//String str=sc.nextLine();
		Dog dog=new Dog();
		dog.run();
		dog.breathe();
		dog.liveOnland();

	}

}
