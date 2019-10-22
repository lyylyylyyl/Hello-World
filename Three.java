package xian;

public class Three {

	public static void main(String[] args) {
		Teacher tc=new Teacher();
		new Thread(tc,"老师1").start();
		new Thread(tc,"老师2").start();
		new Thread(tc,"老师3").start();
	}
}
class Teacher implements Runnable{
	private int books=80;
	public void run() {
		while(true) {
			if(books>0) {
				Thread th=Thread.currentThread();
				String th_name=th.getName();
				System.out.println(th_name+"正在分发第"+books--+"本作业");
			}
		}
	}
}
