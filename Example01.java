package xian;

public class Example01 {

	public static void main(String[] args) {
		MyThread mythread=new MyThread();
		mythread.run();
		while(true) {
			System.out.println("Main����������");
		}

	}

}
class MyThread{
	public void run() {
		while(true) {
			System.out.println("Run����������");
		}
	}
}
