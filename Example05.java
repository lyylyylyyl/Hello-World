package xian;

public class Example05 {

	public static void main(String[] args) {
		TicketWindow tw=new TicketWindow();
		new Thread(tw,"����1").start();
		new Thread(tw,"����2").start();
		new Thread(tw,"����3").start();
		new Thread(tw,"����4").start();
	}

}
class TicketWindow implements Runnable{
	private int ticket=100;
	public void run() {
		while(true) {
			if(ticket>0) {
				Thread th=Thread.currentThread();
				String th_name=th.getName();
				System.out.println(th_name+"���ڷ��۵�"+ticket--+"��Ʊ");
			}
		}
	}

}