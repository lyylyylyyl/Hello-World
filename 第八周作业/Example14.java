package xian;

public class Example14 {

	public static void main(String[] args) {
		DLThread d1=new DLThread(true);
		DLThread d2=new DLThread(false);
		new Thread(d1,"Chinese").start();
		new Thread(d2,"American").start();

	}

}
class DLThread implements Runnable{
	static Object chopsticks=new Object();
	static Object knifeAndFork=new Object();
	private boolean flag;
	DLThread(boolean flag){
		this.flag=flag;	
	}
	public void run() {
		if(flag) {
			while(true){
			synchronized (chopsticks) {
			System.out.println(Thread.currentThread().getName()+"---if---chopsticks");
			synchronized(knifeAndFork) {
				System.out.println(Thread.currentThread().getName()+"---if---knifeAndFork");
				
			     }
				}
			}
			}else {
				while(true) {
					synchronized(knifeAndFork) {
						System.out.println(Thread.currentThread().getName()+"---if---knifeAndFork");
						synchronized (chopsticks) {
							System.out.println(Thread.currentThread().getName()+"---if---chopsticks");
				             }
			        }
	            }
	       }
}
}
