package com.brideglabz.oops.commercialdataprocessing;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import org.codehaus.jackson.JsonParseException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;

import com.bridgelabz.oops.utility.OOPSUtility;

public class CompanyDataQueue 
{
	
	//main started
	public static void main(String[] args) throws JsonParseException, JsonMappingException, IOException
	{
		
		
		//providing the path of each and every file. 

		String pathOfCompany = "/home/admin28/Desktop/FellowshipProgramsJavaSupzz/OOPS/Company.json";
		
	 	String pathOfCustomer = "/home/admin28/Desktop/FellowshipProgramsJavaSupzz/OOPS/Customer.json";
		
		String pathOfTransaction = "/home/admin28/Desktop/FellowshipProgramsJavaSupzz/OOPS/Transaction.json"; 
		
		
		//making the objects of all the 3 model classes present.
		
		CompanyModel companyModel = new CompanyModel();
		CustomerModel customerModel = new CustomerModel();
		TransactionModel transactionModel = new TransactionModel();
		
		ObjectMapper mapper = new ObjectMapper();
		
		
		//reading the company json file with the help of model class object.
		companyModel = 	mapper.readValue(new File("/home/admin28/Desktop/FellowshipProgramsJavaSupzz/OOPS/Company.json"), CompanyModel.class /*companyModel.getClass()*/);
				
		
		//reading the customer json file with the help of model class object.
		customerModel = mapper.readValue(new File("/home/admin28/Desktop/FellowshipProgramsJavaSupzz/OOPS/Customer.json"), CustomerModel.class);
			 	
		
		//putting the transaction json file inside a file.
		File file = new File("/home/admin28/Desktop/FellowshipProgramsJavaSupzz/OOPS/Transaction.json");
		
		//storing inside a file to check if the file is not empty and then reading the file.
		if(file.length()!=0) 
		{
		 	//read the transaction json file.
			transactionModel = mapper.readValue(new File("/home/admin28/Desktop/FellowshipProgramsJavaSupzz/OOPS/Transaction.json"), TransactionModel.class);
		}
		
		
		//putting the class of company customer and the transaction into an arraylist.
		
		//ArrayList -->It raises its size according to new elements and decreases the size when the elements are removed.
				//---> allows you to retrieve the elements by their index.
		ArrayList<Company> companyArrayList = new ArrayList<>();
		ArrayList<Customer> customerArrayList = new ArrayList<>();
		ArrayList<Transaction> transactionArrayList = new ArrayList<>();
		
		//adding the model class of company into the ArrayList of Company class.
		companyArrayList.addAll(companyModel.getCompanylist()); 
		
		 
		
		customerArrayList.addAll(customerModel.getCustomerList());
		
		
		
		//if transaction list if not empty then add model of transaction into Arraylist of Transaction class.
		if(transactionModel.getTransactionList()!=null)
		{
			transactionArrayList.addAll(transactionModel.getTransactionList());
			 
		} 
		
		
		
		System.out.println("welcome to the property Shares Dealer.");
		
		System.out.println("please enter your customer ID:");
		
		int customerId = OOPSUtility.IntegerInput();
		
		int indexOfcustomer=0;
		//searching if the entered customer Id is matching with the Id of present data.
		boolean customerIdFound= false;
		
		for(int i=0; i<customerArrayList.size()-1 ;i++)
		{
			if(customerId==customerModel.getCustomerList().get(i).getCustomerId())
			//if(customerId==customerArrayList.get(i).getCustomerId());
			{
				customerIdFound=true;
				indexOfcustomer = i;
				break;
				
			}
		}
		
		
		
		

		boolean exit = false;
		if(customerIdFound) //if true 
		{
			while(!exit) //while not exit
			{
				//displayin the customer name
				System.out.println("Hello:"+customerArrayList.get(indexOfcustomer).getCustomerName());
			 	
				//displayin the customer balance
				int customerBalance = customerArrayList.get(indexOfcustomer).getCustomerBalance();
				System.out.println("You have Balance: " + customerBalance);
				
				
				System.out.println("Please select options\n" 
						+ "1. buy shares\n" 
						+ "2. sell shares\n"
					 	+ "3. print report\n" 
						+ "4. Transaction Printing Using LinkedList\n"
						+ "5. exit");
			 	
				int makeChoice = OOPSUtility.IntegerInput(); 
				switch(makeChoice) 
				{
					case 1:		
								
								ServiceWork.buy(indexOfcustomer, customerBalance , companyArrayList , customerArrayList , transactionArrayList);
								break;
								 
								
								
								
					case 2 : 
							
							   ServiceWork.sell(indexOfcustomer, customerBalance , companyArrayList , customerArrayList ,transactionArrayList );
									
								break;
					case 3: 
						
								ServiceWork.printReport( transactionArrayList);
								break;
		 						
								
				    case 4: 	LinkedQueue<Transaction> list=new LinkedQueue<Transaction>();
								
								System.out.println("Transaction In Linked Queue");
								
								list.addAllLinkedQueue(transactionModel.getTransactionList());
								list.display();
								System.out.println();
								break;
								
					
							
					case 5:	exit = true;
							System.out.println("Thank you for using service");
							break;
					
					default:  System.out.println("Please select the option correctly Mam/Sir.");
								
						
				
				}//switch end
				
			}//while end
			
		
		
		}// if end
		
		
		
		
	}//main end

	

}
