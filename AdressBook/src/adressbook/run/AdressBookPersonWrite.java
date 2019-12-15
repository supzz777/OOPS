package adressbook.run;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

import org.codehaus.jackson.JsonParseException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;
public class AdressBookPersonWrite 
{
	public static void main(String[] args) throws JsonParseException, JsonMappingException, IOException
	{
		AdressBookModel model= new AdressBookModel();
		
		String adressBookOutput = "/home/admin28/Desktop/FellowshipProgramsJavaSupzz/AdressBook/AdressBookOutput.json";
		String person = "/home/admin28/Desktop/FellowshipProgramsJavaSupzz/AdressBook/person.json";
		ObjectMapper mapper= new ObjectMapper();
		
		ArrayList<Person> personArrayList = new ArrayList<Person>();
		
		//adding person
		
		Person person1 = new Person();  
		Person person2 = new Person(); 
		
		
		person1.setFirstName("supzz");
		person1.setLastName("kengar");
		
		Address address = new Address();
		address.setCity("panvel");
		address.setState("mh");
		address.setZip(410206); 
		person1.setAddress(address); 
		long mobile = 885022355;
		person1.setMobile(mobile);
		 
		
		person2.setFirstName("zinat");
		person2.setLastName("sheikh");
		
		Address address2 = new Address();
		address2.setCity("panvel");
		address2.setState("mh");
		address2.setZip(410206); 
		person2.setAddress(address);  
		long mobile2 = 2345655;
		person2.setMobile(mobile2);
		
		
		//adding to the Arraylist of person
		
		personArrayList.add(person1);
		personArrayList.add(person2);
		
		//adding the Arraylist to the model class.
		
		model.setPersonList(personArrayList);
		 
		 
		
		System.out.println(model.getPersonList().get(1).getFirstName());
		
		mapper.writeValue(new File(person), model); //adding onto the another file.
		System.out.println("writing done.");
		
		mapper.readValue(new File("/home/admin28/Desktop/FellowshipProgramsJavaSupzz/AdressBook/person.json"), model.getClass());
		
		//-------------------------------------------------------------------//
		    
		//edit person.  
		 Scanner sc = new Scanner(System.in);
		System.out.println("Enter Person's mobile number you want to edit:");
		Long searchMobileNo = sc.nextLong();
		int indexOfPerson = 0;
		boolean isFoundPerson = false; 
		 
		//searching for the person with same entered mobile number
		for(int i=0;i<model.getPersonList().size();i++)
		{
			if( searchMobileNo.equals(model.getPersonList().get(i).getMobile()) )
			
			{
				isFoundPerson = true; 
				indexOfPerson = i;
				System.out.println("Person found");
				break;
			} 
		} 
		  
		//if personFound is true. then
		if(isFoundPerson) 
		{
			personArrayList.get(indexOfPerson).getAddress().setCity("newroad pune");
			personArrayList.get(indexOfPerson).getAddress().setZip(414567);
			personArrayList.get(indexOfPerson).setMobile((long) 1234567770);
			
			System.out.println("Editing of yours is being completed");
		}
		else
		{
			System.out.println("Person not found.");
		}
		
		//--------------------------------------------------------------------------//
		
		
		
		//sort by last name
		
		for(int i=0;i<personArrayList.size()-1;i++)
		{
			for (int j=i+1;j<personArrayList.size()-1;j++)
			{
				if(personArrayList.get(i).getLastName().compareTo(personArrayList.get(j).getLastName())  >0)
				{
					Object temp = personArrayList.get(i);
					personArrayList.set(i, personArrayList.get(j));
					personArrayList.set(j , (Person) temp);

					
			    }
			}
		}
		model.setPersonList(personArrayList);
		
		//-------------------------------------------------------------------------------//
		
		//sort by zip number
		
		for(int i=0;i<personArrayList.size()-1;i++)
		{
			for (int j=i+1;j<personArrayList.size()-1;j++)
			{
				if( personArrayList.get(i).getAddress().getZip()  > personArrayList.get(j).getAddress().getZip() )
				{
					Object temp = personArrayList.get(i);
					personArrayList.set(i, personArrayList.get(j));
					personArrayList.set(j , (Person) temp);

					
				}
			}
		}
		
		model.setPersonList(personArrayList);
		 
		
		//write this in json file 	
		mapper.writeValue(new File(person), model);
		
		
		
		
	}//main end.

}//class end
