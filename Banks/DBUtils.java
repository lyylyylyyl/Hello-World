package Banks;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.io.UnsupportedEncodingException;
import java.util.HashMap;

//public class DBUtils implements Serializable{
//	private static DBUtils instance = null;
//	private HashMap<String, User> users = new HashMap<String, User>();
//
//	private DBUtils()throws Exception {
//		
//		FileInputStream fis =new FileInputStream("user.txt");
//		ObjectInputStream ois=new ObjectInputStream(fis);
//		users=(HashMap<String, User>)ois.readObject();
//		
//		
//		
//	}
//	
//	public static DBUtils getInstance() throws Exception {
//		if (instance == null) {
//			synchronized (DBUtils.class) {
//				if (instance == null) {
//					instance = new DBUtils();
//				}
//			}
//		}
//		return instance;
//	}
//
//	public User getUser(String cardID) {
//		User user = (User) users.get(cardID);
//		return user;
//	}
//
//	public HashMap<String, User> getUsers() {
//		return users;
//	}
//	public void flash()throws Exception {
//		FileOutputStream out = new FileOutputStream("user.txt");
//		ObjectOutputStream bos = new ObjectOutputStream(out);
//		bos.writeObject(users);
//		bos.close();
//		out.close();
//	}
//}
//	
public class DBUtils {
	private static DBUtils instance=null;
	private HashMap<String,User> users=new HashMap<String,User>();
	private DBUtils() {
		getUsersFromInputStream("user.txt");
	}
	private void getUsersFromInputStream(String isName) {
		try {
			FileInputStream fs=new FileInputStream(isName);
			byte[] content=new byte[2048];
			int i=0;
			int conInteger=0;
			while(true) {
				try {
					conInteger=fs.read();
				} catch (IOException e) {
					// TODO 自动生成的 catch 块
					e.printStackTrace();
				}
				if(-1==conInteger) {
					break;
				}else if('\r'==(char)conInteger||'\n'==(char)conInteger) {
					try {
						this.processUserString(new String(content,"GBK").trim());
					} catch (UnsupportedEncodingException e) {
						// TODO 自动生成的 catch 块
						e.printStackTrace();
					}
					i=0;
				}
				
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		
		
	}
	public void processUserString(String userString) {
		String[] userFields=userString.split(",");
		User u=new User();
		u.setCardId(userFields[0]);
		u.setCardPwd(userFields[1]);
		u.setUserName(userFields[2]);
		u.setCall(userFields[3]);
		u.setAccount(Integer.parseInt(userFields[4]));
		users.put(u.getCardId(), u);
	}
	//懒汉式单例模式
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
