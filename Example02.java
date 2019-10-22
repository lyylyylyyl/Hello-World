package xian;

public class Example05 {

	public static void main(String[] args) {
		// TODO 自动生成的方法存根
		MyTHread myThread=new MyTHread();
		myThread.start();
		while(true) {
			System.out.println("Main方法在执行");
		}
	}
}
class MyTHread extends Thread{
	public void run() {
		while(true) {
			System.out.println("Run方法在执行");
		}
	}
}
