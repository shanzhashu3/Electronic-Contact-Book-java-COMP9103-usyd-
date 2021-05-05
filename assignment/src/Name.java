public class Name {
	private String name;

	public Name(){}
	public Name(String name) {
		this.name = name;
	}
	
	public boolean isValid() {
		return name.matches("[a-zA-Z]+");
		
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		if(name.matches("[a-zA-Z\\s\'\"]+")){
			this.name = name;
		}else{
			this.name = "";
		}
	}
	
	
}

