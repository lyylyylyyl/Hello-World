package Banks;
import java.util.HashMap;

public class DBUtils {
	private static DBUtils instance=null;
	private HashMap<String,User> users=new HashMap<String,User>();
	private DBUtils() {
		User u1=new User();
		//�����
		u1.setCardId("1001");
		u1.setCardPwd("123456");
		u1.setUserName("�����");
		u1.setCall("15836367788");
		u1.setAccount(10000);
		users.put(u1.getCardId(),u1);
		//ɳ����
		User u2=new User();
		u2.setCardId("1002");
		u2.setCardPwd("123456");
		u2.setUserName("ɳ����");
		u2.setCall("15836367799");
		u2.setAccount(11000);
		users.put(u2.getCardId(),u2);
		//��˽�
		User u3=new User();
		u3.setCardId("1003");
		u3.setCardPwd("123456");
		u3.setUserName("��˽�");
		u3.setCall("15836367700");
		u3.setAccount(8000);
		users.put(u3.getCardId(),u3);
	}
	//����ʽ����ģʽ
	public static DBUtils getInstance() {
		if(instance==null) {
			synchronized(DBUtils.class) {
				if(instance==null) {
					instance=new DBUtils();
				}
			}
		}
		return instance;
	}
	public User getUser(String cardId) {
		User user=(User)users.get(cardId);
		return user;
	}
	public HashMap<String,User> getUsers(){
		return users;
	}

}
