package com.brideglabz.oops.commercialdataprocessing;

import java.io.File;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;


import org.codehaus.jackson.JsonParseException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;

import com.bridgelabz.oops.utility.OOPSUtility;

public class ServiceWork 
{ 
	static ObjectMapper mapper = new ObjectMapper(); 
	static CompanyModel companyModel = new CompanyModel();
	static CustomerModel customerModel = new CustomerModel(); 
	static TransactionModel transactionModel = new TransactionModel();
	 
	
	/*static ArrayList<Company> companyArrayList = new ArrayList<>();
	static ArrayList<Customer> customerArrayList = new ArrayList<>();
	static ArrayList<Transaction> transactionArrayList = new ArrayList<>();    */
	
	static DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("HHmmss");
	
	//companyArrayList.addAll(companyModel.getCompanylist());
			
	public static void buy(int indexOfCustomer,int customerBalance ,ArrayList companyArrayList ,ArrayList customerArrayList , ArrayList transactionArrayList  ) throws JsonParseException, JsonMappingException, IOException
	{
		//adding the model class of company into the ArrayList of Company class.
		
		//companyArrayList.addAll(companyModel.getCompanylist()); 
		
		 
		
		//customerArrayList.addAll(customerModel.getCustomerList());
		
		
		
	/* ArrayList<Company> companyArrayList = new ArrayList<>(); 
		 ArrayList<Customer> customerArrayList = new ArrayList<>();
	ArrayList<Transaction> transactionArrayList = new ArrayList<>(); */
		
	  
		System.out.println("--------------------------buy-----------------------");

		System.out.println("Please enter company ID: ");
		int companyId = OOPSUtility.IntegerInput();
		
		boolean isCompanyFound = false;
		int indexOfCompany=0;
		//companyArrayList.addAll(companyModel.getCompanylist()); 
		 
		//searching if the entered company Id matches with the available list of company Ids.
		for(int i=0;i <companyArrayList.size()-1;i++)
		{
			
			//if(companyId==companyModel.getCompanylist().get(i).getCompanyid())
			 if(companyId==((Company) companyArrayList.get(i)).getCompanyid())
			{
				isCompanyFound=true;
				indexOfCompany=i;
				break;
			}
			
		}
		
		
		
		
		
		if (isCompanyFound) //if company Id  matches with the entered Id.
		{
			
			//displaying all the necessay contents of that company.
			System.out.println("the Company you selected is:"+((Company) companyArrayList.get(indexOfCompany)).getCompanyname());
			System.out.println("the Company's total shares are:"+((Company) companyArrayList.get(indexOfCompany)).getCompanyshares());
			System.out.println("the Company's share price are:"+((Company) companyArrayList.get(indexOfCompany)).getCompanyshareprice());
			
			
			System.out.println();
			System.out.println("Please enter how much shares to buy: ");
			int numberOfCompanyShareToBuy =OOPSUtility.IntegerInput();
			
			//checking if the entered share is les than available share
			if (numberOfCompanyShareToBuy < ((Company) companyArrayList.get(indexOfCompany)).getCompanyshares())
			{
			
				 //checking if customer can buy that much shares ie. his account balance should be greater than share price
				if(customerBalance > numberOfCompanyShareToBuy*((Company) companyArrayList.get(indexOfCompany)).getCompanyshareprice())
						{	//deducing the customer balance.
							int newCustomerBalance = customerBalance -( numberOfCompanyShareToBuy*((Company) companyArrayList.get(indexOfCompany)).getCompanyshareprice() );
							
							//setting the new customer balance in the entry.
							((Customer) customerArrayList.get(indexOfCustomer)).setCustomerBalance(newCustomerBalance);
							
							//adding to the customer shares.
							((Customer) customerArrayList.get(indexOfCustomer)).setCustomerShares(
									((Customer) customerArrayList.get(indexOfCustomer)).getCustomerShares() + numberOfCompanyShareToBuy);
							
							//deducing no of shares from the company list.
							
							((Company) companyArrayList.get(indexOfCompany)).setCompanyshares(
									((Company) companyArrayList.get(indexOfCompany)).getCompanyshares() - numberOfCompanyShareToBuy);
							
							//calculating the new total value of the company i.e share price*no of shares.
							((Company) companyArrayList.get(indexOfCompany))
							.setCompanytotalvalue(((Company) companyArrayList.get(indexOfCompany)).getCompanyshareprice()
									* ((Company) companyArrayList.get(indexOfCompany)).getCompanyshares());
							
							
							
							
							//making object of transaction class.
							Transaction transaction = new Transaction();
							LocalDateTime now = LocalDateTime.now();  //displays current time in java.
							
							//setting transaction Id by concatenating date customer ID and company ID.
							String transactionId=dateTimeFormatter.format(now) + ((Customer) customerArrayList.get(indexOfCustomer)).getCustomerId()
									+ ((Company) companyArrayList.get(indexOfCompany)).getCompanyid();
							
							//setting all the values of the transaction field.
							transaction.setTransactionId(transactionId);
							transaction.setBuyer(((Customer) customerArrayList.get(indexOfCustomer)).getCustomerName());
							transaction.setSeller(((Company) companyArrayList.get(indexOfCompany)).getCompanyname());
							transaction.setTransactionAmount(
									numberOfCompanyShareToBuy * ((Company) companyArrayList.get(indexOfCompany)).getCompanyshareprice());
							transaction.setDateAndTime(dateTimeFormatter.format(now));
		
							//adding all the details to array list of transaction class.
							transactionArrayList.add(transaction);
							
							 transactionModel.setTransactionList(transactionArrayList);
							transactionModel.setTransaction("Transactions");
							
							mapper.writeValue(new File("/home/admin28/Desktop/FellowshipProgramsJavaSupzz/OOPS/Transaction.json"), transactionModel);
							
							System.out.println("Transaction has saved");

							
				
				}
				else
				{
					System.out.println("You dont have enough balance to buy the  shares.");
				}
			
			
			
			
			
			
			}
			else
			{
				System.out.println("Company don't have that much shares");
			}
			
			
			
		
	}
	else
	{
		System.out.println("Company not identified please enter right ID again...");
	}
	
		
	 
	}//method1 end.
	
	
	
	public static void sell(int indexOfCustomer ,int customerBalance ,ArrayList companyArrayList  , ArrayList customerArrayList , ArrayList transactionArrayList   ) throws JsonParseException, JsonMappingException, IOException
	{
		
		

		//adding the model class of company into the ArrayList of Company class.
		
		 
		
	
	
		System.out.println("----------------------------------sell---------------------------------------------");

		System.out.println("Enter number of shares you want to sell");

		int shareNumberSell = OOPSUtility.IntegerInput();
		
		System.out.println("Please enter company ID to whom you want to sell your shares to: ");
		int companyID = OOPSUtility.IntegerInput();
		
		int indexOfCompany=0;
		 boolean isCompanyFound = false;
		
		//searching if the entered company Id matches with the available list of company Ids.
				for(int i=0;i <companyArrayList.size()-1;i++)
				{
					
					//if(companyId==companyModel.getCompanylist().get(i).getCompanyid())
					 if(companyID==((Company) companyArrayList.get(i)).getCompanyid())
					{
						isCompanyFound=true;
						indexOfCompany=i;
						break;
					}
					
				}
				
		
		//if company ID is valid then ongoing with the further process.
		
		if (isCompanyFound)
		{
					//displaying all the details of the matched company.
				
					System.out.println(
							"The company you selected is: " + ((Company) companyArrayList.get(indexOfCompany)).getCompanyname());
					System.out.println("Company shares: " + ((Company) companyArrayList.get(indexOfCompany)).getCompanyshares());
					System.out.println(
							"Company share price: " + ((Company) companyArrayList.get(indexOfCompany)).getCompanyshareprice());
					
					//displaying the amount customer will b getting agter selling its xhares to company.
					int amountToGetToCustomer = shareNumberSell * ((Company) companyArrayList.get(indexOfCompany)).getCompanyshareprice() ;
					System.out.println("Amount you will get: " + amountToGetToCustomer);
					
					
					
					// company share increase
					
					if (shareNumberSell<= ((Customer) customerArrayList.get(indexOfCustomer)).getCustomerShares()) //given share should b less than customers total share.
					{
						//adding to the companys share.
						((Company) companyArrayList.get(indexOfCompany))
									.setCompanyshares(((Company) companyArrayList.get(indexOfCompany)).getCompanyshares() + shareNumberSell);
						
						
							// company TotalValue increase
						((Company) companyArrayList.get(indexOfCompany))
									.setCompanytotalvalue(((Company) companyArrayList.get(indexOfCompany)).getCompanyshareprice()
											* ((Company) companyArrayList.get(indexOfCompany)).getCompanyshares());
			
							// customer share decrease
						((Customer) customerArrayList.get(indexOfCustomer))
									.setCustomerShares(((Customer) customerArrayList.get(indexOfCustomer)).getCustomerShares() - shareNumberSell);
			
							// customer balance increase
			
						((Customer) customerArrayList.get(indexOfCustomer)).setCustomerBalance(
								((Customer) customerArrayList.get(indexOfCustomer)).getCustomerBalance() + amountToGetToCustomer);
				
						
						
						
						//starting with the transaction entry now.
						Transaction transaction = new Transaction();
						LocalDateTime now = LocalDateTime.now();
						
						String TransID=  dateTimeFormatter.format(now)
								+ ((Customer) customerArrayList.get(indexOfCustomer)).getCustomerId()
								+ ((Company) companyArrayList.get(indexOfCompany)).getCompanyid();
						
						
						//setting the values into the transaction file.
						
						transaction.setTransactionId(TransID);
						transaction.setBuyer(((Company) companyArrayList.get(indexOfCompany)).getCompanyname());
						transaction.setSeller(((Customer) customerArrayList.get(indexOfCustomer)).getCustomerName());
						transaction.setTransactionAmount(shareNumberSell * ((Company) companyArrayList.get(indexOfCompany)).getCompanyshareprice());
						transaction.setDateAndTime(dateTimeFormatter.format(now));
						
						//putting the transaction values to the array list .
						transactionArrayList.add(transaction);
						
						//setting transaction array list into transaction model.
						transactionModel.setTransactionList(transactionArrayList);
						transactionModel.setTransaction("Transactions");
						
						mapper.writeValue(new File("/home/admin28/Desktop/FellowshipProgramsJavaSupzz/OOPS/Transaction.json"), transactionModel);

						System.out.println(" Your Transaction has saved");

						
						
						
			
					}
					else
					{
						System.out.println("Company ID  not found  in the database please try again");
					}
					
		

		}
		else
		{
			System.out.println("Company not found please try again");
		}
		
	
		
	}//method2 end. 
	
	public static void printReport( ArrayList transactionArrayList) throws JsonParseException, JsonMappingException, IOException
	{
		
		
		
	
		
		
		System.out.println("-------------------------------------report----------------------------------------");
		System.out.println();
		System.out.println();
		boolean hasNext = false;
		
		File file = new File("/home/admin28/Desktop/FellowshipProgramsJavaSupzz/OOPS/Transaction.json");
		
		for (int i = 0; i < transactionArrayList.size(); i++)
		{
				if(file.length()!= 0)
				{ 
					hasNext = true;
					
					
						System.out.print(((Transaction) transactionArrayList.get(i)).getTransactionId() + "\t\t");
						System.out.print(((Transaction) transactionArrayList.get(i)).getBuyer() + "\t");
						System.out.print(((Transaction) transactionArrayList.get(i)).getSeller() + "\t");
						System.out.print(((Transaction) transactionArrayList.get(i)).getTransactionAmount() + "\t\t\t");
						
						System.out.println();
						
					
				}		
				else
						
						System.out.println("Sorry , No transactions found.");
				
	
		}
			
		
	
	/*	if (hasNext) 
			{
				for (int i = 0; i < transactionArrayList.size()-1 ; i++)
				{
						if (i == 0) 
						{
							System.out.print("Transaction_ID\t");
							System.out.print("Buyer\t\t");
							System.out.print("Seller\t\t\t");
							System.out.print("Trans_Amt\t");
							System.out.println();
							
						}
						if (Character.getNumericValue(((Transaction) transactionArrayList.get(i)).getTransactionId().charAt(6)) == customerId)
						{		 
							System.out.print(((Transaction) transactionArrayList.get(i)).getTransactionId() + "\t");
							System.out.print(((Transaction) transactionArrayList.get(i)).getBuyer() + "\t\t");
							System.out.print(((Transaction) transactionArrayList.get(i)).getSeller() + "\t\t");
							System.out.print(((Transaction) transactionArrayList.get(i)).getTransactionAmount() + "\t");
							//System.out.println(((Transaction) transactionArrayList.get(i)).getDateAndTime() + "\t");
							System.out.println();
		
						}
	
				}
					
			} 
		else
		{
		
				System.out.println("Sorry , No transactions found.");
		}
		     */
		
		
		
	}//method3 end.

}//class end
