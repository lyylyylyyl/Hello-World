package xian;

public class TWO {

	public static void main(String[] args) {
		MyThread mythread=new MyThread();
		Thread thread=new Thread(mythread);
		thread.start();
		for(int i=0;i<50;i++) {
			System.out.println("main");
		}
	}

}
class MyThread implements Runnable{
	public void run() {
		for(int i=0;i<50;i++) {
			System.out.println("new");
		}
	}
	
}
