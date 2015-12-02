package Model;

public class User {
	protected String UserName;
	protected String PassWord;
	protected double Money;
	protected double VIPpoint;
	
	public User() {}
	public User(String name, String password){
		UserName = name;
		PassWord = password;
		Money = 1000;
		VIPpoint = 0;
	}
	
	public User(String name, String password, double money, double vippoint){
		UserName = name;
		PassWord = password;
		Money = money;
		VIPpoint = vippoint;
	}

	public String getUserName() {
		return UserName;
	}

	public void setUserName(String userName) {
		UserName = userName;
	}

	public String getPassWord() {
		return PassWord;
	}

	public void setPassWord(String passWord) {
		PassWord = passWord;
	}

	public double getMoney() {
		return Money;
	}

	public void setMoney(double money) {
		Money = money;
	}

	public double getVIPpoint() {
		return VIPpoint;
	}

	public void setVIPpoint(double vIPpoint) {
		VIPpoint = vIPpoint;
	}
	
	
}
