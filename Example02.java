package xian;

public class Example05 {

	public static void main(String[] args) {
		// TODO �Զ����ɵķ������
		MyTHread myThread=new MyTHread();
		myThread.start();
		while(true) {
			System.out.println("Main������ִ��");
		}
	}
}
class MyTHread extends Thread{
	public void run() {
		while(true) {
			System.out.println("Run������ִ��");
		}
	}
}
