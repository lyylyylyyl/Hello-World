package xian;

public class Three {

	public static void main(String[] args) {
		Teacher tc=new Teacher();
		new Thread(tc,"��ʦ1").start();
		new Thread(tc,"��ʦ2").start();
		new Thread(tc,"��ʦ3").start();
	}
}
class Teacher implements Runnable{
	private int books=80;
	public void run() {
		while(true) {
			if(books>0) {
				Thread th=Thread.currentThread();
				String th_name=th.getName();
				System.out.println(th_name+"���ڷַ���"+books--+"����ҵ");
			}
		}
	}
}
