package logic;

public class User {
	private int userId;
	private String userName;
	private String userPassword;
	private String userMail;
	public User(int userId,String userName,String userMail,String userPassword) {
		this.userId=userId;
		this.userName=userName;
		this.userPassword=userPassword;
		this.userMail=userMail;
	}
	public int getUserId() {
		return userId;
	}
	public String getUserMail() {
		return userMail;
	}
	public String getUserName() {
		return userName;
	}
	public String getUserPassword() {
		return userPassword;
	}
	public void setUserId(int id) {
		this.userId=id;
	}
	public void setUserName(String name) {
		this.userName=name;
	}
	public void setUserMail(String userMail) {
		this.userMail=userMail;
	}
	public void setUserPassword(String password) {
		this.userPassword=password;
	}
	@Override
	public String toString() {
		return "User [userId=" + userId + ", userName=" + userName + ", userPassword=" + userPassword + "]";
	}
	

}
