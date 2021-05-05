public class Person {
	private Name name;
	private Birthday birthday;
	private Phone phone;
	private Email email;
	private Address address;
	
	//similar to page 7 of lecture week 9 
	public Person() {
		// TODO Auto-generated constructor stub
		name = new Name("");
		birthday = new Birthday("");
		phone = new Phone("");
		email = new Email("");
		address = new Address("");
	}
	
	public Person(String s) 
	{
		String[] temp = s.trim().split(";");
		
		for(int i=0; i <temp.length; i++) 
		{
			temp[i] = temp[i].trim();
			
			if(temp[i].startsWith("name")) 
			{
				name = new Name(temp[i]);
			}
			else if(temp[i].startsWith("birthday")) 
			{
				birthday = new Birthday(temp[i]);
			}
			else if(temp[i].startsWith("address")) 
			{
				address = new Address(temp[i]);
			}
			else if(temp[i].startsWith("phone")) 
			{
				phone = new Phone(temp[i]);
			}
			else if(temp[i].startsWith("email")) 
			{
				email = new Email(temp[i]);
			}
			
		}
	}
	

	public boolean isValidToAdd() 
	{
		return validName()&&validBirthday()&&validAddress()&&validPhone()&&validEmail();
	}

	public boolean validName() {
		// TODO Auto-generated method stub
		if(name == null) 
		{
			return true;
		}
		return name.isValid();
	}
	
	public boolean validBirthday() {
		// TODO Auto-generated method stub
		if(birthday == null) 
		{
			return true;
		}
		return birthday.isValid();
	}

	public boolean validAddress() {
		// TODO Auto-generated method stub
		if(address ==null ) 
		{
			return true;
		}
		return address.isValid();
	}
	
	private boolean validPhone() {
		// TODO Auto-generated method stub
		if(phone == null) 
		{
			return true;
		}
		return phone.isValid();
	}


	private boolean validEmail() {
		// TODO Auto-generated method stub
		if(email==null) 
		{
			return true;
		}
		return email.isValid();
	}
	
	public String getName() {
		return name.getName();
	}

	public String getBirthday() {
		return birthday.getBirthday();
	}
	
	public String getPhone() {
		return phone.getPhone();
	}
	
	public String getAddress() {
		return address.getAddress();
	}
	
	public String getEmail() {
		return email.getEmail();
	}

	public boolean isValidAddress(){
		return this.address.isValid();
	}
	
	public void setBirthday(String birthday) {
		this.birthday.setBirthday(birthday);
	}

	public void setName(String name) {
		this.name.setName(name);
	}

	public void setPhone(String phone) {
		this.phone.setPhone(phone);
	}

	public void setEmail(String email) {
		this.email.setEmail(email);
	}

	public void setAddress(String address) {
		this.address.setAddress(address);
	}

	//need to modification later
	@Override
	public String toString() {
		String details = "";
		if(name!=(null)&& !name.getName().equals("")) {details = details+"name: " + name.getName() + "\n";}
		if(birthday!=(null)&& !birthday.getBirthday().equals("")) {details = details + "birthday: " + birthday.getBirthday()+ "\n";}
		if(address!=(null)&& !address.getAddress().equals("")) {details = details + "address: " + address.getAddress() + "\n";}
		if(phone!=(null) && !phone.getPhone().equals("")) {details = details + "phone: " + phone.getPhone() + "\n";}
		if(email!=(null)&& !email.getEmail().equals("")) {details = details + "email: " + email.getEmail() + "\n" ;}
		return details;
	}
	
	
}

