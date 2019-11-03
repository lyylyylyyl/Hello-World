package xian;

public class Example13 {

	public static void main(String[] args) {
		// TODO 自动生成的方法存根
		Ticket1 tw=new Ticket1();
		new Thread(tw,"线程一").start();
		new Thread(tw,"线程二").start();
		new Thread(tw,"线程三").start();
		new Thread(tw,"线程四").start();
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
	System.out.println(Thread.currentThread().getName()+"---卖出的票"+tickets--);
}
}