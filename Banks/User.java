package Banks;

public class User {
	private String call;
	private int account;
	private String userName;
	private String cardPwd;
	private String cardId;
	public void setCall(String Call) {
		this.call=Call;
	}
	public String getCall() {
		return call;
	}
	public void setAccount(int Account) {
		this.account=Account;
	}
	public int getAccount() {
		return account;
	}
	public void setUserName(String Name) {
		this.userName=Name;
	}
	public String getUserName() {
		return userName;
	}
	public void setCardPwd(String Pwd) {
		this.cardPwd=Pwd;
	}
	public String getCardPwd() {
		return cardPwd;
	}
	public void setCardId(String Id) {
		this.cardId=Id;
	}
	public String getCardId() {
		return cardId;
	}
}
