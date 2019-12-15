package com.brideglabz.oops.commercialdataprocessing;

import java.util.List;

public class TransactionModel 
{
	private String transaction;
	
	private List<Transaction> transactionList;
	
	
	public String getTransaction()  
	{
		return transaction; 
	}

	public void setTransaction(String transaction) {
		this.transaction = transaction;
	}

	public List<Transaction> getTransactionList() {
		return transactionList;
	}

	public void setTransactionList(List<Transaction> transactionList) {
		this.transactionList = transactionList;
	}


	
}
