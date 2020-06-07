public class Admin {
	private String userName;
	private String password;
	
	public Admin(String a, String b) { 
		userName = a; 
		password = b; 
	}
	
	public String getUserName() {
		return userName; 
	}
	public String getPassword() {
		return password; 
	}
}
