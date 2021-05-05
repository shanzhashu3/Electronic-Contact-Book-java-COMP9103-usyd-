public class Phone {
	private String phone;
	
	public Phone() {}
	public Phone(String phone) 
	{
		this.phone = phone;
	}
	
	public boolean isValid() 
	{
		return phone.matches("^\\(0|[1-9]\\d{5,9})$");
	}
	
	
	public String getPhone() {
		return phone;
	}

	public boolean checkPhone(String inputPhone) 
	{
		return inputPhone.matches("[0-9]+");
	}

	public void setPhone(String phone) {
		if(checkPhone(phone))
			this.phone = phone;
	}
	
	
}
