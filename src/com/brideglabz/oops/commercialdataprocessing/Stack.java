package com.brideglabz.oops.commercialdataprocessing;

import java.util.List;

public class Stack<T>
{

	  static int size=20;
	  static int top=-1;
	  static Object a[]=new Object[size];
	
	public static<T> void push(T s1)
	{
		if(top==size-1)
		{
			System.out.println("Stack is Full");
		}
		else
		{
			top++;
			a[top]= (Object) s1;
		}
	}
	public static void pop()
	{
		if(top==-1)
		{
			System.out.println("Stack is Empty");
		}
		else
		{
			top--;
		}
	}
	public void pushAll(List<Transaction> list) {
		for(int i=0;i<list.size();i++)
		{
			push( list.get(i));
		}
		
	}
	public static void display()
	{
		if(top>0)
		{
		for(int i=top;i>=0;i--)
		{
			System.out.println(a[i]);
			
		}
		}
		else
		{
			System.out.println("Nothing  to Display");
		}
	}
	
	@SuppressWarnings("static-access")
	public static void main(String[] args)
	{
		@SuppressWarnings("rawtypes")
		Stack st=new Stack();
		st.push("a");
		st.push("b");
		st.push("c");
		System.out.println();
		System.out.println("Elements After pushed onto the stack");
		System.out.println();
		st.display();
		
		st.pop();
		System.out.println();
		System.out.println("Elements After popped out of the stack");
		System.out.println();
		st.display();
		
		}
	

}
