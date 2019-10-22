package xian;

public class Example01 {

	public static void main(String[] args) {
		MyThread mythread=new MyThread();
		mythread.run();
		while(true) {
			System.out.println("Main方法在运行");
		}

	}

}
class MyThread{
	public void run() {
		while(true) {
			System.out.println("Run方法在运行");
		}
	}
}
