import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

public class PersonProcesser {
	private File phonebookFile;
	private File instructionFile;
	private File outputFile;
	private File reportFile;
	private PhoneBook phonebook;
	
	// week 9 case study product processor class p18
	public PersonProcesser(String[] s) 
	{
		phonebookFile = new File(s[0]); 
		instructionFile = new File(s[1]); 
		outputFile = new File(s[2]);
		reportFile = new File(s[3]); 
		phonebook = new PhoneBook();
	}
	
	public void readInputFile() 
	{
		BufferedReader reader;
		try 
		{
			reader  = new BufferedReader(new FileReader(phonebookFile));
			String line = reader.readLine();
			System.out.println(line);
			while(line!=null) 
			{
				Person person = new Person();
				while(line != null && line.length()>0)
				{	
					line = line.trim();
					if(line.startsWith("name")) 
					{
						person.setName(line.substring(5));
					}else if(line.startsWith("birthday")) 
					{
						person.setBirthday(line.substring(9));
					}else if(line.startsWith("phone")) 
					{
						person.setPhone(line.substring(6));
					}else if(line.startsWith("email")) 
					{
						person.setEmail(line.substring(6));
					}else if(line.startsWith("address")) 
					{
						person.setAddress(line.substring(8));
					}else{
						String address = person.getAddress()+" "+line;
						person.setAddress(address);
					}
					line = reader.readLine();
				}
				if(!person.getName().equals("")&&!person.getBirthday().equals(""))
					phonebook.add(person);
				line = reader.readLine();
			}
			
		}catch(IOException e2) 
		{
			e2.printStackTrace();
		}
		System.out.println(phonebook.getContacts().size());
	}
	

	public void readInstruction() 
	{
		BufferedReader reader;
		try 
		{
			reader = new BufferedReader(new FileReader(instructionFile));
			String line = reader.readLine();
			while(line!=null) 
			{
				String[] inst = line.trim().split(" ");
				String keyword = inst[0];
				switch(keyword) 
				{ 
					case "query":
						String type = inst[1];
						String queryString="";
						if(type.equals("name")) 
						{
							for(int i=2; i<inst.length;i++) 
							{
								queryString = queryString + inst[i]+" ";
							}
							queryString = queryString.trim();
							
						}else 
						{
							queryString = inst[2];
						}
						ArrayList<Person> matchPerson = phonebook.query(type, queryString);
						break;
					case "save":
						saveResult();
							//System.out.println("Save result");
						break;
					case "add":
						Person person = addInst(line);
						phonebook.add(person);
						break;
					case "delete":
						String [] deleteInst = line.trim().split(";");
						String [] names = deleteInst[0].trim().split(" ");
						String name = "";
						for (int i=1; i <names.length; i++){
							name = name+names[i]+" ";
						}
						name = name.trim();
						if(deleteInst.length>0){
							String birthday = deleteInst[1].trim();
							phonebook.deleteByNameAndBirth(name,birthday);
						}else{
							phonebook.deleteByName(name);
						}
						break;
					default:
						break;
						
				}
				line = reader.readLine();
			}
		}catch(IOException e) 
		{
			System.out.println("The file not found");
		}
	}
	public Person addInst(String line) 
	{
		//split string line by ; type+label + value and label + value
		String [] inst = line.trim().split(";");
		Person person = new Person();
		for(int i=0; i<inst.length; i++) 
		{
			//split to substring in each word
			String[] queryInst = inst[i].trim().split(" ");
			//if the first queryInst start with add
			if(i == 0) 
			{
				String type = queryInst[1];
				String address ="";
				switch(type) 
				{
					case"name":
						String name ="";
						for(int j=2; j<queryInst.length; j++) 
						{
							name = name+queryInst[j] + " ";
						}
						name=name.trim();
						person.setName(name);
						break;
					case"birthday":
						person.setBirthday(queryInst[2]);break;
					case"email":
						person.setEmail(queryInst[2]);break;
					case"phone":
						person.setPhone(queryInst[2]);break;
					case"address":
						for(int j=2; j<queryInst.length; j++) 
						{
							address = address + queryInst[j]+" ";
						}
						address=address.trim();
						person.setAddress(address);
						break;
					default: 
					break;
				  }
					
			  }else 
			  {
				  String type = queryInst[0];
				  String address = "";
				  switch(type) 
				  {
				  	case"name":
				  		String name = "";
				  		for(int j=1; j<queryInst.length; j++) 
				  		{
				  			name = name + queryInst[j]+" ";
				  		}
				  		name = name.trim();
				  		person.setName(name);break;
				  	case"birthday":
				  		person.setBirthday(queryInst[1]); break;
				  	case"email":
				  		person.setEmail(queryInst[1]); break;
				  	case"phone":
				  		person.setPhone(queryInst[1]); break;
				  	case"address":
				  		for(int j=1; j< queryInst.length;j++) 
				  		{
				  			address = address + queryInst[j] + " ";
				  		}
				  		address = address.trim();
				  		person.setAddress(address);
				  		break;
				  	 default: 
						break;
				  }
			  }
		}
		return person;
	 }
	public void saveResult() 
	{
		try 
		{
			PrintWriter out = new PrintWriter(new FileOutputStream(outputFile));
			ArrayList<Person> contacts = phonebook.getContacts();
			for (int i=0; i<contacts.size();i++){
				if(i!=0){
					out.println();
				}
				if(!contacts.get(i).getName().equals("")){
					out.print("name: "+contacts.get(i).getName());
					out.print("\n");
				}
				if(!contacts.get(i).getBirthday().equals("")){
					out.print("birthday: "+contacts.get(i).getBirthday());
					out.print("\n");
				}
				if(!contacts.get(i).getAddress().equals("")){
					if(contacts.get(i).isValidAddress()){
						out.print("address: "+contacts.get(i).getAddress());
						out.print("\n");
					}
				}
				if(!contacts.get(i).getPhone().equals("")){
					out.print("phone: "+contacts.get(i).getPhone().replaceAll("^0+(?=.)", ""));
					out.print("\n");
				}
				if(!contacts.get(i).getEmail().equals("")){
					out.print("email: "+contacts.get(i).getEmail());
					out.print("\n");
				}
			}
			out.close();
		}catch(FileNotFoundException e1) 
		{
			e1.printStackTrace();
		}
	}
	
}
