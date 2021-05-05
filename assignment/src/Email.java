public class Email {
	private String email;

	public Email(){}
	public Email(String email) {
		this.email = email;
	}
	
	public boolean isValid() 
	{
		return (email != null&&email.matches("^[\\w-_\\.+]*[\\w-_\\.]\\@([\\w]+\\.)+[\\w]+[\\w]$"));
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		if(email.matches("^[\\w-_\\.+]*[\\w-_\\.]\\@([\\w]+\\.)+[\\w]+[\\w]$"))
			this.email = email;
		else 
			this.email = "";
	}
	
	
}
