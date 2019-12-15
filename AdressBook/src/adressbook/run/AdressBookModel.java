package adressbook.run;

import java.util.List;



public class AdressBookModel 
{  
	private List<Person> personList;
	
	

	public List<Person> getPersonList() {
		return personList;
	}

	public void setPersonList(List<Person> personList) {
		this.personList = personList;
	}

	@Override
	public String toString()
	{
		return "AdressBookModel [personList=" + personList + ", getPersonList()=" + getPersonList() + ", getClass()="
				+ getClass() + ", hashCode()=" + hashCode() + ", toString()=" + super.toString() + "]";
	}
	
	

}
