package DAZY;
import java.awt.AWTException;      //
import java.awt.Robot;             //
import java.awt.event.InputEvent;  //
import java.awt.event.KeyEvent;    //
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Login {
	Scanner sc=new Scanner(System.in);
	public void login() throws AWTException{     //��¼���� 
		System.out.println("\t\t\t��ӭ����ѧ���������ϵͳ��");
		Login.clear();
		System.out.println("\t\t\t\t1-��¼\n\t\t\t\t2-ע��\n\t\t\t\t0-�˳�");
		int choice=sc.nextInt();
		switch(choice){
		    case 0:break;
			case 1:denglu();break;
			case 2:zhuce();break;
			default :break;
		}
		
	}
	
	public void denglu() {       //��¼
		
	}
	public void zhuce() {        //ע��
		Student stu1=new Student();
		
		System.out.println("������ѧ���˺ţ�\n");
		String m1=sc.nextLine();
		//stu1.setname(num1);
		System.out.println("���������룺");
		String num=sc.nextLine();
		//stu1.setnum(mi1);
		System.out.println("���ٴ�ȷ�����룺");
		String m2=sc.nextLine();
		if(m2.equals(m1)) {
			System.out.println("\t\tע��ɹ���");
			
			//Login.login();
		}else {
			System.out.println("\t\t�����������벻һ�£�����");
		}
	}
	public void 
	public static void clear() throws AWTException
    {
        Robot r = new Robot();
        r.mousePress(InputEvent.BUTTON3_MASK);       // ��������Ҽ�
        r.mouseRelease(InputEvent.BUTTON3_MASK);    // �ͷ�����Ҽ�
        r.keyPress(KeyEvent.VK_CONTROL);             // ����Ctrl��
        r.keyPress(KeyEvent.VK_R);                    // ����R��
        r.keyRelease(KeyEvent.VK_R);                  // �ͷ�R��
        r.keyRelease(KeyEvent.VK_CONTROL);            // �ͷ�Ctrl��
        r.delay(1000);       

    }
}
