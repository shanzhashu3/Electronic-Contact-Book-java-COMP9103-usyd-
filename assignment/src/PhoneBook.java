import java.util.ArrayList;
public class PhoneBook {
	
	private ArrayList<Person> contacts;

	public PhoneBook() {
		contacts = new ArrayList<Person>();
	}

	public ArrayList<Person> getContacts() {
		return contacts;
	}
	
	public void setInventory(ArrayList<Person> contacts) 
	{
		this.contacts=contacts;
	}
	
	//add,delete, query, save
	public void add(Person person) 
	{
		if(person.getName()!=null && !person.getName().equals("") &&person.getBirthday()!=null && !person.getBirthday().equals("")){
			if(hasPerson(person) == null){
			contacts.add(person);
			}
		}
	}
	
	public Person hasPerson(Person person){
		for(Person p:contacts){
			if(p.getName().equals(person.getName())&&p.getBirthday().equals(person.getBirthday())){
				p.setName(person.getName());
				if(person.getPhone()!=null && !person.getPhone().equals("")){
					p.setPhone(person.getPhone());
				}
				if(person.getAddress()!=null && !person.getAddress().equals("")){
					p.setAddress(person.getAddress());
				}
				return p;
			}
		}
		return null;
	}

	public void deleteByName(String name){
		for(int i=0;i<contacts.size();i++){
			if(contacts.get(i).getName().equals(name))
				contacts.remove(i);
		}
	}

	public void deleteByNameAndBirth(String name, String birthday){
		String[] temp;
		if(birthday.matches("\\d+\\D\\d+\\D\\d+")) 
		{
			temp = birthday.split("\\D");
			if(temp.length ==3) 
			{
				for(int i =0; i<2; i++) 
				{
					if(temp[i].length()<2)
						temp[i] = "0" + temp[i];
				}
				birthday = temp[0]+ "-"+temp[1]+"-"+temp[2];
			}
		}
		for(int i=0;i<contacts.size();i++){
			if(contacts.get(i).getName().equals(name)&&contacts.get(i).getBirthday().equals(birthday))
				contacts.remove(i);
		}
	}
	
	public ArrayList<Person> query(String type, String queryString)
	{
		ArrayList<Person> matchesPerson = new ArrayList<Person>();
		switch(type) 
		{
		 	case"name":
		 		for(Person person:contacts) 
		 		{
		 			if(person.getName().equals(queryString)) 
		 			{
		 				matchesPerson.add(person);
		 			}
		 		}break;
		 	case"birthday":
		 		for(Person person:contacts) 
		 		{
		 			if(person.getBirthday().equals(queryString))
		 			{
		 				matchesPerson.add(person);
		 			}
		 		}break;
		 	case"phone":
		 		for(Person person:contacts) 
		 		{
		 			if(person.getPhone().equals(queryString))
		 			{
		 				matchesPerson.add(person);
		 			}
		 		}break;
		 	case"email":
		 		for(Person person:contacts) 
		 		{
		 			if(person.getEmail().equals(queryString)) 
		 			{
		 				matchesPerson.add(person);
		 			}
		 		}break;
		 	case"address":
		 		for(Person person:contacts) 
		 		{
		 			if(person.getAddress().equals(queryString)) 
		 			{
		 				matchesPerson.add(person);
		 			}
		 		}break;
		 	default:
		 		break;
		 		
		}
		return matchesPerson;
	}
	public void save() {};
	
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		for(Person person: contacts) 
		{
			sb.append(person.toString());
		}
		
		return sb.toString();
	}	
}