package xian;

public class Example09 {

	public static void main(String[] args) {
		Thread t1=new YieldThread("�߳�A");
		Thread t2=new YieldThread("�߳�B");
		t1.start();
		t2.start();

	}

}
class YieldThread extends Thread{
	public YieldThread(String name) {
		super(name);
	}
	public void run() {
		for(int i=1;i<=10;i++) {
			System.out.println(Thread.currentThread().getName()+"---"+i);
			if(i==3) {
				System.out.println("�߳��ò���");
				Thread.yield();
			}
		}
	}
}
