package adressbook.run;

import java.io.FileNotFoundException;

public interface AdressBookInterfaceUtil
{		
	
	    //1
		void readJson();
		
		//2
		void createNewAddressBook();
		
		//3
		void addPerson();
	
		//4
		void editPerson();
		
		//5
		void deletePerson();
		
		//6
		void sortByLastName();
		
		//7
		void sortByZip();
		
		//8
		void save();
		
		//9
		void saveAs() throws FileNotFoundException;
			

}
