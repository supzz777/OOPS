package com.brideglabz.oops.commercialdataprocessing;

import java.util.List;
import java.util.NoSuchElementException;


		//Linked Queue Class
		public class LinkedQueue<T>
		{
			protected  Node<?> front;
			protected Node<?> rear;
			public static int size;
			
			
			class Node<T> 
			{
				 T data;
				Node<T> link;
				public Node<T> next;

				@SuppressWarnings("unchecked")
				// Constructors Of Node
				public Node() {
					link = null;
					data = (T) " ";
				}

				@SuppressWarnings("unchecked")
				public Node(T d, Node<?> n) {
					data = d;
					link = (Node<T>) n;
				}

				@SuppressWarnings("unchecked")
				// Getters Setters
				public void setLink(Node<?> n) {
					link = (Node<T>) n;
				}

				public void setData(T d) {
					data = d;
				}

				public Node<?> getLink() {
					return link;
				}

				public T getData() {
					return data;
				}
			}

	
			public LinkedQueue() 
			{
				front = null;
				rear = null;
				size = 0;
			}
	
			public boolean isEmpty() 
			{
				return front == null;
			}
	
			public int getSize() 
			{
				return size;
			}

			// Method For Inserting the Node
			public <T> void insert(T i) 
			{
				Node<T> new_node = new Node<T>(i, null);
				if (rear == null)
				{
					front = new_node;
					rear = new_node;
				} else {
					rear.setLink(new_node);
					rear = rear.getLink();
				}
				size++;
			}

			// Method For removing the Node
			public String remove() 
			{
				if (isEmpty())
				{
					System.out.println("no element to print");
				}
				Node<?> temp = front;
				front = temp.getLink();
				if (front == null)
					rear = null;
				size--;
				return (String) temp.getData();
			}

			// Method to peek front element
			public String peek() 
			{
				if (isEmpty())
				{
					System.out.println("no element to print");
				}
				return (String) front.getData();
			}

			// Display Linked Queue
			public  void display() 
			{
				if (size == 0) {
					System.out.print("Empty");
					return;
				}
				Node<?> ptr = front;
				while (ptr != rear.getLink()) {
					System.out.print(ptr.getData());
					ptr = ptr.getLink();
				}
			}


		public  void addAllLinkedQueue(List<Transaction> list)
		{
			
			for(int i=0;i<list.size();i++)
			{
				insert( list.get(i));
			}
		}
	
	
	}


