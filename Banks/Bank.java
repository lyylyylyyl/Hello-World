package Banks;
import java.util.Scanner;

public class Bank {
	int account;
	private static User user;

	public static void main(String[] args) {
		Bank b=new Bank();
        b.login();
        b.operate();
		
	}
	public void operate() {
		Bank b=new Bank();
		while(true) {
			System.out.println("请输入您要进行的操作类型，按回车键能结束：");
			System.out.println("\t1—存款\n"+"\t2—取款\n"+"\t3—余额\n"+"\t0—退出");
			Scanner sc=new Scanner(System.in);
			String choice=sc.nextLine();
			if("1".equals(choice)||"2".equals(choice)){
				int num=0;
				try {
					System.out.print("输入存取的金额：");
					num=Integer.parseInt(sc.nextLine());
				}catch(Exception e) {
					System.err.println("\t金额输入错误！");
					continue;
				}
				switch(choice) {
				case "1":b.income(num);break;
				case "2":b.takeout(num);break;
				}	
				}else if("3".equals(choice)) {
					b.show();
			}else if("0".equals(choice)) {
				System.out.println("退出系统！");
				return;
			}else {
				System.out.println("请输入0~3之间的相关操作：");
			}
		}
	}
	public void login() {
		DBUtils dbutil=null;
		try {
			dbutil = DBUtils.getInstance();
		} catch (Exception e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
		System.out.println("欢迎进入网上银行系统！");
		while(true) {
			Scanner sc=new Scanner(System.in);
			System.out.println("请输入银行卡号：");
			String cardId=sc.nextLine();
			System.out.println("请输入银行卡密码：");
			String cardPwd=sc.nextLine();
			user=dbutil.getUser(cardId);
			if(dbutil.getUsers().containsKey(cardId)&&user.getCardPwd().equals(cardPwd)) {
				System.out.println("登录成功！欢迎"+user.getUserName()+"女士/先生");
				break;
			}else {
				System.err.println("银行卡号或密码错误！");
				continue;
			}
		}
		
	}
	public void income(int num) {
		account=user.getAccount()+num;
		user.setAccount(account);
		System.out.println("存入金额"+num+"元成功！");
		
	}
	public void takeout(int num) {
		if(user.getAccount()>=num) {
		account=user.getAccount()-num;
		user.setAccount(account);
		System.out.println("取出金额"+num+"元成功！");
		}else {
			System.err.println("余额不足，取款失败！");
		}
		
	}
	public void show() {
		account=user.getAccount();
		System.out.println("账户总额为"+account+"元");
	}

}
