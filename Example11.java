4-14
interface Animal {  //定义Animal接口
	void shout();

}

public class Cat implements Animal {    //定义cat类实现animal接口
	public void shout() {                //实现shout方法
		System.out.println("喵喵……");
	}
	void sleep() {                     //定义sleep（）方法
		System.out.println("猫在睡觉");
	}

}

public class Example06 {

	public static void main(String[] args) {
		Cat cat=new Cat();
		animalShout(cat);

	}
	public static void animalShout(Animal animal){
		Cat cat =(Cat) animal;     //将animal强转为cat类型
		cat.shout();               //调用cat中shout方法
		cat.sleep();              //调用cat中sleep方法
		//animal.shout();
		//animal.sleep();    出错：提示没有animal.sleep()方法
	}

}


4-15

interface Animal {  //定义Animal接口
	void shout();

}

class Dog implements Animal {  
	public void shout() {     
		System.out.println("汪汪汪……");
	}
}


public class Cat implements Animal {    //定义cat类实现animal接口
	public void shout() {                //实现shout方法
		System.out.println("喵喵……");
	}
	void sleep() {
		System.out.println("猫在睡觉");
	}

}

public class Example06 {

	public static void main(String[] args) {
		Dog dog=new Dog();
		animalShout(dog);
	}
	public static void animalShout(Animal animal){
		if(animal instanceof Cat) {     //判断animal是否是cat类的实例对象
		Cat cat =(Cat)animal;     //将animal强转为cat类型
		cat.shout();               //调用cat中shout方法
		cat.sleep();    //调用cat中sleep方法
		} else {
			System.out.println("this animal is not a cat");
		}
	}

}
