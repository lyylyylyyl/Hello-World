package xian;

public class Example13 {

	public static void main(String[] args) {
		// TODO �Զ����ɵķ������
		Ticket1 tw=new Ticket1();
		new Thread(tw,"�߳�һ").start();
		new Thread(tw,"�̶߳�").start();
		new Thread(tw,"�߳���").start();
		new Thread(tw,"�߳���").start();
	}

}
class Ticket1 implements Runnable{
	private int tickets=10;
	public void run() {
	while(true) {
		saleTicket();
		if(tickets<=0) break;
	}
	}

private synchronized void saleTicket() {
	if(tickets<0) {
		try {
			Thread.sleep(10);
		}catch(InterruptedException e) {
			e.printStackTrace();
		}
	}
	System.out.println(Thread.currentThread().getName()+"---������Ʊ"+tickets--);
}
}