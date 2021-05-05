public class Address {
private String address;
	
	public Address(){}
	public Address(String address) 
	{
		this.address=address;
	}
	
	public boolean isValid() 
	{	
		String []addressArray = address.trim().split(", ");
		String [] postcode = addressArray[addressArray.length-1].split(" ");
		if(!postcode[postcode.length-1].matches("[0-9]+")){
			return false;
		}
		return true;
	}
	
	

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}
	
}