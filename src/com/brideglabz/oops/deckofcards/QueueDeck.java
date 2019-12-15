package com.brideglabz.oops.deckofcards;


	
	
	public class QueueDeck
	{
		//linked list variables
		private Node front, rear; 
		
		//variable to check size 
		private int size;

		//linked list Node contains data and next
		private class Node
		{ 
			String data;
			Node next;
		} 
		
		//constructor of queue
		public QueueDeck()
		{
			front = null;
			rear = null;
			size = 0;
		}
		
		//check for empty condition
		public boolean isEmpty()
		{
			return (size == 0);
		}
		
		//inserting data to queue
		public void push(String data)
		{
			Node previous = rear;
			rear = new Node();
			rear.data = data;
			rear.next = null;
			
			if (isEmpty()) 
			{
				front = rear;
			}
			else 
			{
				previous.next = rear;
				System.out.print(data + "--->");
			}
			size++;
			
		}

	


}
