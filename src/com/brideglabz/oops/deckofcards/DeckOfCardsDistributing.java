package com.brideglabz.oops.deckofcards;

import com.bridgelabz.oops.utility.OOPSUtility;

public class DeckOfCardsDistributing 
{
	//creating an array of suit
	String suitArray[]= new String[]{"Clubs", "Diamonds", "Hearts", "Spades"};
	//creating an array of rank
	String[]  rankArray= new String[]{"2", "3", "4", "5", "6", "7", "8", "9", "10","Jack", "Queen", "King", "Ace"};
	
	
	//finding the length of the arrays of rank and the suit.
	int suit= suitArray.length;
	int rank= rankArray.length; 
	
	String[] DD = new String[100]; 
	
	//creating an deck of cards array equal to the length of both rank and suit array 
	String deckOfCards[]= new String[suit*rank];
	 
	int index=0;
	
	 
	
	//method to store all the 52 cards in the deck of array and displaying them.
	public int deckOfCardsArray()
	{
		
		for(int i=0;i<suit;i++)
		{
			for(int j=0;j<rank;j++)
			{
				 deckOfCards[index]=suitArray[i]+"^"+rankArray[j];
				 System.out.println("   "+ deckOfCards[index]+"         ");
				index++;
			}
			System.out.println("");
		}
		 
		
		return index;
		
	}
	
	
	//method to shuffle all the 52 cards and then displaying them .
	public void shuffledeckOfCardsArray()
	{
	
		for(int i=0;i<deckOfCards.length;i++)
		{
			int j= (int) ((Math.random()*deckOfCards.length)+1);
			String temp =  deckOfCards[i];
			 deckOfCards[i]= deckOfCards[j];
			 deckOfCards[j]=temp;
		}
		
		
		for(int i=0;i<deckOfCards.length;i++)
		{
			System.out.println(deckOfCards[i]); 
		}
	} 
	
	
	//method to distribute 9 cards among 4 players 
	public void distributeDeckOfCards(int players, int cards)
	{
		
		//loop for no of  players
		for(int i=0;i<players;i++)
		{
			System.out.println();
			
			System.out.println("Player"+(i+1));
			
			System.out.println();
			
			
			//loop for distributing no of cards to these 4 players
			for(int j=0;j<cards;j++)
			{
				System.out.println(deckOfCards[i+j*players]);
			}
		} 
	}
		
		//method to distribute 9 cards among 4 players using 1D array
		
		
		public void distributeDeckOfCards1D(int players, int cards)
		{
			//loop for 4 players
			for(int i=0;i<players;i++)
			{
				System.out.println();
				
				System.out.println("Player"+(i+1));
				
				System.out.println();
				
				
				//loop for distributing 9 cards to these 4 players
				for(int j=0;j<cards;j++)
				{
					 DD[j]= deckOfCards[i+j*4];
				
					System.out.println(DD[j]);
				}
			}
		
		}
		
		
		//method to sort the array
	/*	public void sortDeckOfCards(String[] DD)
		{
			this.DD=DD;
			
			int j=0;
			for(int i=1;i<DD.length;i++)
			{
				j=i;
				String temp=DD[i];
				while(j>0 && DD[j-1] > temp)
				{
					DD[j]=DD[j-1];
					j=j-1;
				}
				DD[j]=temp;
			}
			
		}  */
		
		
		
		
		//method to distribute cards using the 2D array
		
	/*	public void distributeDeckOfCards2D(int players, int cards)
		{
			String array2D[][]= new String[players][cards];
			
			int k=0;
			for(int i=0;i<players;i++)
			{
				System.out.println("Person"+(i+1));
				System.out.println();
				for(int j=0;j<cards;j++) 
				{
					array2D[i][j]=deckOfCards[k];
					System.out.println(array2D[i][j]);
					k++;
				}
				System.out.println();
			}

		}  */
	
	public static void main(String[] args)
	{
		DeckOfCardsDistributing ds=new DeckOfCardsDistributing();
		
		System.out.println("deck of 52 cards are:");
		System.out.println();
		ds.deckOfCardsArray();
		System.out.println();
		
		System.out.println("Shuffled cards are");
		System.out.println();
		ds.shuffledeckOfCardsArray();
		System.out.println();
		
		
		
		//taking no of players from the user 
		System.out.println("how many players are in the game");
		int players=OOPSUtility.IntegerInput(); 
		
		//taking no of cards to be distributed among the players
		System.out.println("how many cards you want to distribute  in the game");
		int cards =OOPSUtility.IntegerInput(); 
		
		System.out.println(" distributed "+cards+" to the "+players+" are:");
		ds.distributeDeckOfCards(players,cards);
		
		System.out.println();
		System.out.println();
		
	//	ds.distributeDeckOfCards1D(players,cards);
		
		System.out.println();
		//ds.distributeDeckOfCards2D(players,cards);
		
	}


	

}
