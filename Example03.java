package xian;

public class Example03 {

	public static void main(String[] args) {
		// TODO 自动生成的方法存根
		MyThread mythread=new MyThread();
		Thread thread=new Thread(mythread);
		thread.start();
		while(true) {
			System.out.println("main方法在执行");
		}
	}
}
class MyThread implements Runnable{
	public void run() {
		System.out.println("RUN方法");
	}
}
