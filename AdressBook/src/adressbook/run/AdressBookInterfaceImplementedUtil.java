package adressbook.run;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

import org.codehaus.jackson.map.ObjectMapper;


public class AdressBookInterfaceImplementedUtil implements AdressBookInterfaceUtil
{
	Scanner scanner = new Scanner(System.in); 
	int size = 0;
	
	String personpath = "/home/admin28/Desktop/FellowshipProgramsJavaSupzz/AdressBook/person.json"; 
	//String adressBookOutput = "/home/admin28/Desktop/FellowshipProgramsJavaSupzz/AdressBook/AdressBookOutput.json";
	String statename = "";
	static AdressBookModel model = new AdressBookModel();
	static ArrayList<Person> personArrayList = new ArrayList<Person>(); //list is an interface and arraylist is a class

	String search;
	int indexOfPerson;
	
	ObjectMapper mapper = new ObjectMapper();
	
	// to print person detail
	public static void printDetails(ArrayList<Person> personArrayList, String statename )
	{
		
		System.out.println("person details are:");
		
		personArrayList.forEach
		( i->  
				{
					if(!statename.isEmpty() && statename.equals(i.getAddress().getState()))
					{
						System.out.println(i.getFirstName()+"," +i.getLastName()+","+i.getMobile()
											+","+i.getAddress().getAddress()+","+i.getAddress().getCity()
											+","+i.getAddress().getState() +","+i.getAddress().getZip());
					}
					
			
				}

	    );
		
	}//method end
	
	
	
	// 1 method to read json file. 
	public void readJson() 
	{
		
		// checking whether file is empty or not
				File file = new File(personpath);
				if (file.exists() && file.length() != 0) 
				{
					try 
					{
						model= mapper.readValue(file,model.getClass());
						
					} 
					catch (IOException e) 
					{
						e.printStackTrace();
					}
					
					
					personArrayList.addAll(model.getPersonList()); //adding to the array list.
					size = personArrayList.size();

				}
		
	}//method1 end

	//2  method to create new Adress Book.
	public void createNewAddressBook() 
	{ 
		
		System.out.println("New Address Book is going to be created");
		
		System.out.println("please enter your state name: ");

		statename = scanner.next(); 

		boolean isFoundState = false;
		
		for (int i = 0; i < personArrayList.size(); i++) {
			if (personArrayList.get(i).getAddress().getState().equals(statename))
			{
				isFoundState = true;
				break;
			}
		}
		
		//if the state is found further process starts.
		
		if (!isFoundState)
		{

					
					boolean close = false;
					
					System.out.println("State is added");
		
					while (!close) 
					{
						System.out.println("Select option: \n"
											+ "1.add\n"
											+ "2.edit\n"
											+ "3.delete\n"
											+ "4.sort by last name\n"
											+ "5.sort by zip\n"
											+ "6.print\n"
											+ "7.close");
							System.out.println("enter your choice");	
						int choice = scanner.nextInt();
						switch (choice)
						{
								case 1:
											// add person
											addPerson();
											break;
								case 2:
											// edit person
											editPerson();
											break;
								case 3:
											// delete person
											deletePerson();
											break;
											
								case 4:
											// sort by last name
											sortByLastName();
											break;
								case 5:
											// sort by zip
											sortByZip();
											break;
								case 6:
											// print
						
											if (size > 0)
											{
												System.out.println("Printing all records...");
						
												AdressBookInterfaceImplementedUtil.printDetails(personArrayList, statename);
						 
											}
											else
											{
												System.out.println("There is no record to print...");
											}
											break;
								case 7:
											// close
											close = true;
											System.out.println("Closing...");
											break;
								default:
											System.out.println("Invalid option");
									
									
						}//switch end
						
						
						
					}//while end
		} 
		else
		{
			System.out.println("State exist please try again");
		}
		
		
		
		
	}//method2 end
	
	// 3 method to open the  Adress Book.
	public void openAddressBook() 
	{
		
				System.out.println("Open Address Book");
				
				HashMap<String, String> map = new HashMap<>();
				for (int i = 0; i < personArrayList.size(); i++) 
				{
					map.put(personArrayList.get(i).getAddress().getState(), personArrayList.get(i).getAddress().getState());
				}
				System.out.println("states available " + map.keySet()); //  map.keySet()-- displays all the key values i.e states.
				System.out.println("Enter state");
				statename = scanner.next();
				boolean isFoundState = false;
				for (int i = 0; i < personArrayList.size(); i++)
				{
					if ( personArrayList.get(i).getAddress().getState().equals(statename) )
					{
						isFoundState = true;
						break;
					}
				}
				
				//if state found then start with the process.
				if (isFoundState)
				{
					System.out.println("->State is found<-");
					boolean close = false;
		 
					while (!close) 
					{
						System.out.println("Select option: \n"
											+ "1.addaddPerson\n"
											+ "2.editeditPerson\n"
											+ "3.deletedeletePerson\n"
											+ "4.sort by last name\n"
											+ "5.sort by zip\n"
											+ "6.print\n"
											+ "7.quit");
						System.out.println("enter a no of your choice");	
						int choice = scanner.nextInt();
						switch (choice) 
						{
						case 1:
									// add person
									addPerson();
									break;
						case 2:
									// edit person
									editPerson();
									break;
						case 3:
									// delete person
									deletePerson();
									break;
						case 4:
								// sort by last name
								sortByLastName();
	
								break;
						case 5:
								// sort by zip
	
								sortByZip();
	
								break;
		
						case 6:
								// print
								if (size > 0) 
								{
									System.out.println("Printing all records...");
	
									AdressBookInterfaceImplementedUtil.printDetails(personArrayList, statename);
	
								} else
									System.out.println("There is no record to print...");
	
								break;
						case 7:
								// close
								close = true;
								System.out.println("Closing...");
								break;
						default:
							System.out.println("Invalid option");
						}
					}

				} else
					System.out.println("something went wrong");

				

		
	}//method 3 end

	//4  method to create new add person to Adress Book.
	public void addPerson() 
	{
		System.out.println("Adding the person details...");
		Person person = new Person();

		System.out.println("Enter mobile number of the person");
		Long mobileNo = scanner.nextLong();
		// validating mobile is not taken by anyone
		boolean isMobileTaken = false;
		for (int i = 0; i < personArrayList.size(); i++) 
		{
			if (personArrayList.get(i).getMobile() == mobileNo)
			{
				isMobileTaken = true;
				break;
			}
		}
		
		if (isMobileTaken) 
		{
			System.out.println("This person is already taken");
		} 
		else 
		{
			person.setMobile(mobileNo);
			System.out.println("Enter person first name: ");
			person.setFirstName(scanner.next());
			System.out.println("Enter person last name: ");
			person.setLastName(scanner.next());
			System.out.println("Enter address Details: ");
			
			
			Address address = new Address();
			System.out.println("Enter address: ");
			address.setAddress(scanner.next());
			System.out.println("Enter city: ");
			address.setCity(scanner.next());
			
			address.setState(statename);
			System.out.println("Enter zip: ");
			address.setZip(scanner.nextInt());

			person.setAddress(address);
 
			personArrayList.add(person); 

			System.out.println();
			System.out.println("Person added"); 
			
			size++;

		}

		
	}//method 4 end

	//5  method to edit a person to Adress Book.
	public void editPerson()  
	{
		
		if (size > 0) 
				{
					System.out.println("Enter Persons mobile number you want to edit:");
					Long searchMobile = scanner.nextLong();
					indexOfPerson = 0;
					boolean isFoundPerson = false;
					for (int i = 0; i < personArrayList.size(); i++) 
					{
						if (searchMobile == personArrayList.get(i).getMobile())
						{
							isFoundPerson = true;
							indexOfPerson = i; 
							break;
						}
					}
					
					if (isFoundPerson) 
					{
		
						System.out.println("enter new address");
						personArrayList.get(indexOfPerson).getAddress().setAddress(scanner.next());
						System.out.println("enter new city name");
						personArrayList.get(indexOfPerson).getAddress().setCity(scanner.next());
						System.out.println("enter new zip");
						personArrayList.get(indexOfPerson).getAddress().setZip(scanner.nextInt());
		
						personArrayList.get(indexOfPerson).setMobile(searchMobile);
		
						System.out.println();
						System.out.println("Edit completed");
		
					} 
					else
						System.out.println("No person found with this number");
		}
		else
		{
			System.out.println("There is no record to edit");
		}

		
		
	}//method 5 end

	// 6 method to delete a person to Adress Book.
	public void deletePerson()
	{
		
		if (size > 0)
		{
				System.out.println("Enter Persons mobile number you want to delete:");
				Long Mobilesearch = scanner.nextLong();
				indexOfPerson = 0;
				boolean isFoundPerson = false;
				for (int i = 0; i < personArrayList.size(); i++) 
				{
					if (Mobilesearch.equals(personArrayList.get(i).getMobile()) )
					{
						isFoundPerson = true;
						indexOfPerson = i;
						break;
					}
				}
				if (isFoundPerson)
				{
					personArrayList.remove(indexOfPerson); //inbuilt function remove of arrayList.
					size--;
					System.out.println();
					System.out.println("Delete completed");
				} 
				else
				{
					System.out.println("No person found with this number");
				}
		} 
		else
		{
			System.out.println("No records to delete");
		}
		
	}//method 6 end

	// 7 method to sort a person by itz last name .
	public void sortByLastName() 
	{
		if (size > 1)
		{
				System.out.println("Sorting by Last name is selected");
	
				for (int i = 0; i < personArrayList.size() - 1; i++) 
				{
					for (int j = i+1; j < personArrayList.size() - 1; j++) 
					{
	
						if (personArrayList.get(i).getLastName().compareTo(personArrayList.get(j ).getLastName()) > 0) 
						{
							Object temp = personArrayList.get(i);
							personArrayList.set(i, personArrayList.get(j));
							personArrayList.set(j , (Person) temp);
	
						}
					}
				}
		}
		else
		{
			System.out.println("Less records to sort");

		}
	
		
	}//method 7 end

	// 8 method to sort a person by itz zip number  .
	public void sortByZip()
	{
		
		if (size > 1) 
		{
			System.out.println("Sorting by zip");

			for (int i = 0; i < personArrayList.size() - 1; i++)
			{
				for (int j = i +1; j < personArrayList.size()  - 1; j++) 
				{

					if ( personArrayList.get(i).getAddress().getZip() > personArrayList.get(j).getAddress().getZip() ) 
					{
						Object temp = personArrayList.get(i);
						personArrayList.set(i, personArrayList.get(j));
						personArrayList.set(j , (Person) temp);

					}				
				}
			}
		}
		else
		{
			
		}
		
		
	}//method 8 end

	
	// 9 method to save inside the adress book .
	public void save()
	{
		System.out.println("Save Address Book");

		System.out.println("->Saving address book into json file<-");
		
		model.setPersonList(personArrayList);
		try 
		{
			mapper.writeValue(new File(personpath ), model);
			
		}
		catch (IOException e) 
		{

			System.out.println("some error occured.");
		}
		
		System.out.println();
		System.out.println("Writing into file successful....");

		
	}//method 9 end

	// 10 method to saveAs() inside the adress book .
	public void saveAs() throws FileNotFoundException 
	{
		
		System.out.println("------------Save As Address Book--------------");

		
		System.out.println("This option requires path where you want to store file");
		
		System.out.println("for continue press 'y' for yes and 'n' for no");
		
		if (scanner.next().charAt(0) == 'y') 
		{
			String pathInput = "/home/admin28/Desktop/FellowshipProgramsJavaSupzz/AdressBook/AdressBookOutput.json"; 
			
			// checking whether path is valid or not
			System.out.println("Enter whole file path");
			pathInput = scanner.next();
			
			if (new File(pathInput).exists())
			{
				
				// writing into file
				System.out.println("->Saving address book into file<-");
				model.setPersonList(personArrayList);
				try 
				{
					mapper.writeValue(new File(pathInput),model);
					//JsonUtil.writeMapper(pathInput, model);
				} 
				catch (IOException e) 
				{
					System.out.println("some error occured.");
					
				}
				
				System.out.println("Writing into file successful....");
			} 
			else 
			{
				throw new FileNotFoundException("You cannot rewrite existing file");
			}
		}
		else
		{
			System.out.println("Save as function not performed successsfully.");
		}
		
		
		
	}//method 10 end
	
	

	
	

}
