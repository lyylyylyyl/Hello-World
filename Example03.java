package xian;

public class Example03 {

	public static void main(String[] args) {
		// TODO �Զ����ɵķ������
		MyThread mythread=new MyThread();
		Thread thread=new Thread(mythread);
		thread.start();
		while(true) {
			System.out.println("main������ִ��");
		}
	}
}
class MyThread implements Runnable{
	public void run() {
		System.out.println("RUN����");
	}
}
