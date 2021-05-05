import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.text.DateFormat;
import java.util.Date;

public class Birthday {
	private static SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
	private String birthday;
	private Date date;
	
	public Birthday(){}
	public Birthday(String birthday) {
		this.birthday = birthday;
	}
	public static boolean isValidDate(String inDate) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
        dateFormat.setLenient(false);
        try {
            dateFormat.parse(inDate.trim());
        } catch (ParseException pe) {
            return false;
        }
        return true;
    }
	
	final static String DATE_FORMAT = "dd-MM-yyyy";

	public static boolean isDateValid(String date) 
	{
		String[] dates = date.split("-");
		if(Integer.parseInt(dates[2])>2020){
			return false;
		}
    	try {
    	    DateFormat df = new SimpleDateFormat(DATE_FORMAT);
        	df.setLenient(false);
	      	df.parse(date);
        	return true;
        } catch (ParseException e) {
        	return false;
    	}	
	}

	public boolean isValid() 
	{
		return true;
	}
	
	
	public String getBirthday() {
		return birthday;
	}

	public void setBirthday(String birthday) {
		String[] temp;
		boolean isContaintAlpha = birthday.matches(".*[a-zA-Z]+.*");
		if(!isContaintAlpha){
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
			if(isDateValid(birthday))
				this.birthday = birthday;
			else
				this.birthday = "";
		}else{
			this.birthday = "";
		}
	}
	
	
}
