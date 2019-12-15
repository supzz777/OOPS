package com.brideglabz.oops.commercialdataprocessing;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.List;
import java.util.Scanner;

public class LinkedList<T>
	{
		Node head;

		public class Node 
		{
			public T data;
			public Node next;

			public Node(T data2) {
				data = (T) data2;
				next = null;
			}
		}

		/*** Inserting an Elements *****/

		public void insert(T t) {
			Node new_node = new Node((T) t);
			new_node.next = null;
			if (head == null) {
				head = new_node;
			} else {
				Node temp = head;
				while (temp.next != null) {
					temp = temp.next;
				}
				temp.next = new_node;
			}
		}

		/**** Deleting Elements *****/

		public void delete(T data) {
			Node temp = head;
			Node previous = null;

			if (temp != null && temp.data == data) {
				head = temp.next;
			} else {
				while (temp != null && temp.data != data) {
					previous = temp;
					temp = temp.next;
				}
				if (temp == null) {
					return;
				}
				previous.next = temp.next;
			}
		}

		/*****
		 * Search Operation*****/

		public String search(T data) {

			Node temp = head;
			
			boolean flag = false;
			if (temp != null && temp.data == data) {
				head = temp.next;
			} else {
				while (temp != null) {
					if (temp.data == data)
						flag = true;
					temp = temp.next;
				}
			}
			if (flag) {
				System.out.println("\n" + data + " is Present..so Deleting**");
				delete(data);
			} else {
				System.out.println("\n" + data + " is not in the File..So inserting!!");
				insert(data);
			}
			return null;
		}

		/**** Displaying Data *****/

		public void display() {
			if (head == null) {
				System.out.println("List is Empty");
			} else {
				Node temp = head;
				while (temp != null) {
					System.out.print(temp.data + "-->");
					temp = temp.next;
				}
			}
		}
		@SuppressWarnings("resource")
		public static String readFromFile(String file) {
			String text ="";
			try {
				Scanner sc = new Scanner(new File(file));
				while (sc.hasNextLine()) 
				{
					text=text+sc.next()+" ";
				}
			   } 
			catch (FileNotFoundException e) 
			{
				System.out.println("File doesn't Exists");
			}
			return text;

		}
	public static String[] arrayToFile(String file) 
	{
		int count = 0;
			try {
				@SuppressWarnings("resource")
				Scanner sc = new Scanner(new File(file));
				
				while (sc.hasNextLine()) {
					
					count++;
					sc.nextLine();

				}
				String[] fileA = new String[count];
				@SuppressWarnings("resource")
				Scanner sc1 = new Scanner(new File(file));
				for (int i = 0; i < count; i++) 
				{
					fileA[i] = sc1.nextLine();
				}
					return fileA;
			
				
			}
	catch (FileNotFoundException e) {
				System.out.println("File NOt Found");
			}
			// return fileA;
			return null;

		}

		
		

		/*** Main Method ****/

		@SuppressWarnings("unused")
		public static void main(String args[]) 
		{
			LinkedList<String> uo = new LinkedList<String>();
			
				
				
			//List<Transactions> transactionList = new ArrayList<Transactions>();
			//for (int i = 0; i < transactionList.size(); i++) {
			//uo.insert(StockAccount.transactionList);
			uo.display();

			}

		@SuppressWarnings("unchecked")
		public void addAll1(List<Transaction> list) {
			for(int i=0;i<list.size();i++)
			{
				insert((T) list.get(i));
			}
			
		}

		

		
			
		
		
	

}
