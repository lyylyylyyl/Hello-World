
public class Single02 {
	private static Single02 instance;
	private Single02() {}
	public static Single02 getInstance() {
		if(instance==null) {
			instance=new Single02();
		}
		return instance;
	}

}
public class Single {
	private static Single INSTANCE =new Single();
	private Single() {}
	public static Single getInstance() {
		return INSTANCE;
	}

}
import java.util.Scanner;

public class Example01 {

	public static void main(String[] args) {
		System.out.println("��ѡ����ģʽ��1-����ʽ\n2-����ʽ");
		Scanner sc=new Scanner(System.in);
		int choice=sc.nextInt();
		if(choice==1) {
			Single s1=Single.getInstance();
		Single s2=Single.getInstance();
		System.out.println("����ʽ�����");
		System.out.println(s1==s2);
		}else if(choice==2) {
			Single02 s3=Single02.getInstance();
			Single02 s4=Single02.getInstance();
			System.out.println("����ʽ�����");
			System.out.println(s3==s4);
			
		}
		

	}

}
