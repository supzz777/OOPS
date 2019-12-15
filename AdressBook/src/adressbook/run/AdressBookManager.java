package adressbook.run;

import java.io.IOException;
import java.util.Scanner;

import org.codehaus.jackson.JsonParseException;
import org.codehaus.jackson.map.JsonMappingException; 

public class AdressBookManager 
{
	//calling the implemented class of adress boook here using switch case.
	public static void main(String[] args)throws InterruptedException, JsonParseException, JsonMappingException, IOException
	{ 
		  
		AdressBookInterfaceImplementedUtil util = new AdressBookInterfaceImplementedUtil();
		util.readJson(); // readJson is the method in implemented class.
		Scanner sc = new Scanner(System.in);

		// getting file if exist and if it is json the reading it again
		// and getting all the objects and lists of json into program
		
		boolean isExitAddressBook = false;
		System.out.println("Address book manager\n");
		while (!isExitAddressBook) 
		{

			System.out.println("Select menu");
			System.out.println(   "1. New Address Book\n"
								+ "2. Open Address Book\n"
								+ "3. Save Address Book\n"
								+ "4. SaveAs Address Book\n" 
								+ "5. Quit");
			int choice = sc.nextInt();
			switch (choice)
			{
			case 1 : util.createNewAddressBook();  
						break;
						
						 
			case 2: 	util.openAddressBook(); 
						break;
						
						
			case 3:    util.save();
						break;
						
						 
			case 4:   util.saveAs();
						break;
						
						
			case 5:    System.out.println("Quit Address Book");
						isExitAddressBook = true;
						break;	
						
						
			default:    System.out.println("Invalid option");
						break;

				
				
			}//switch end
			
			
			
		}//while end
			
		
		
		
		
	}// main end
			

}//class end
