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
	public void login() throws AWTException{     //登录界面 
		System.out.println("\t\t\t欢迎来到学生宿舍管理系统！");
		Login.clear();
		System.out.println("\t\t\t\t1-登录\n\t\t\t\t2-注册\n\t\t\t\t0-退出");
		int choice=sc.nextInt();
		switch(choice){
		    case 0:break;
			case 1:denglu();break;
			case 2:zhuce();break;
			default :break;
		}
		
	}
	
	public void denglu() {       //登录
		
	}
	public void zhuce() {        //注册
		Student stu1=new Student();
		
		System.out.println("请输入学生账号：\n");
		String m1=sc.nextLine();
		//stu1.setname(num1);
		System.out.println("请输入密码：");
		String num=sc.nextLine();
		//stu1.setnum(mi1);
		System.out.println("请再次确认密码：");
		String m2=sc.nextLine();
		if(m2.equals(m1)) {
			System.out.println("\t\t注册成功！");
			
			//Login.login();
		}else {
			System.out.println("\t\t两次输入密码不一致！！！");
		}
	}
	public void 
	public static void clear() throws AWTException
    {
        Robot r = new Robot();
        r.mousePress(InputEvent.BUTTON3_MASK);       // 按下鼠标右键
        r.mouseRelease(InputEvent.BUTTON3_MASK);    // 释放鼠标右键
        r.keyPress(KeyEvent.VK_CONTROL);             // 按下Ctrl键
        r.keyPress(KeyEvent.VK_R);                    // 按下R键
        r.keyRelease(KeyEvent.VK_R);                  // 释放R键
        r.keyRelease(KeyEvent.VK_CONTROL);            // 释放Ctrl键
        r.delay(1000);       

    }
}
