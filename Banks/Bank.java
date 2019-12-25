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
			System.out.println("��������Ҫ���еĲ������ͣ����س����ܽ�����");
			System.out.println("\t1�����\n"+"\t2��ȡ��\n"+"\t3�����\n"+"\t0���˳�");
			Scanner sc=new Scanner(System.in);
			String choice=sc.nextLine();
			if("1".equals(choice)||"2".equals(choice)){
				int num=0;
				try {
					System.out.print("�����ȡ�Ľ�");
					num=Integer.parseInt(sc.nextLine());
				}catch(Exception e) {
					System.err.println("\t����������");
					continue;
				}
				switch(choice) {
				case "1":b.income(num);break;
				case "2":b.takeout(num);break;
				}	
				}else if("3".equals(choice)) {
					b.show();
			}else if("0".equals(choice)) {
				System.out.println("�˳�ϵͳ��");
				return;
			}else {
				System.out.println("������0~3֮�����ز�����");
			}
		}
	}
	public void login() {
		DBUtils dbutil=null;
		try {
			dbutil = DBUtils.getInstance();
		} catch (Exception e) {
			// TODO �Զ����ɵ� catch ��
			e.printStackTrace();
		}
		System.out.println("��ӭ������������ϵͳ��");
		while(true) {
			Scanner sc=new Scanner(System.in);
			System.out.println("���������п��ţ�");
			String cardId=sc.nextLine();
			System.out.println("���������п����룺");
			String cardPwd=sc.nextLine();
			user=dbutil.getUser(cardId);
			if(dbutil.getUsers().containsKey(cardId)&&user.getCardPwd().equals(cardPwd)) {
				System.out.println("��¼�ɹ�����ӭ"+user.getUserName()+"Ůʿ/����");
				break;
			}else {
				System.err.println("���п��Ż��������");
				continue;
			}
		}
		
	}
	public void income(int num) {
		account=user.getAccount()+num;
		user.setAccount(account);
		System.out.println("������"+num+"Ԫ�ɹ���");
		
	}
	public void takeout(int num) {
		if(user.getAccount()>=num) {
		account=user.getAccount()-num;
		user.setAccount(account);
		System.out.println("ȡ�����"+num+"Ԫ�ɹ���");
		}else {
			System.err.println("���㣬ȡ��ʧ�ܣ�");
		}
		
	}
	public void show() {
		account=user.getAccount();
		System.out.println("�˻��ܶ�Ϊ"+account+"Ԫ");
	}

}
