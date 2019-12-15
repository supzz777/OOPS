package com.brideglabz.oops.deckofcards;

import java.util.Arrays;

public class DeckOfCardsSorting 
{
	static String suitArray[]= new String[]{"Clubs", "Diamonds", "Hearts", "Spades"};
	
	static String[]  rankArray= new String[]{"2", "3", "4", "5", "6", "7", "8", "9", "10","Jack", "Queen", "King", "Ace"};
	 
	QueueDeck queueDeck = new QueueDeck();
	
	//finding the length of the arrays of rank and the suit.
	int suit= suitArray.length;
	int rank= rankArray.length; 
	
	String[][] DD = new String[100][100];
	
	//creating an deck of cards array equal to the length of both rank and suit array 
	String deckOfCards[]= new String[suit*rank];
	 
	int index=0;
	
	//-----------method 1-------------------------------//
	
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
	
	
	//-----------method 2-------------------------------//
	
	
	//method to shuffle all the 52 cards and then displaying them .
	public void shuffledeckOfCardsArray()
	{
	
		for(int i=0;i<deckOfCards.length;i++)
		{
			int j= (int) (Math.random()*deckOfCards.length);
			String temp =  deckOfCards[i];
			 deckOfCards[i]= deckOfCards[j];
			 deckOfCards[j]=temp;
		}
		
		
		for(int i=0;i<deckOfCards.length;i++)
		{
			System.out.println(deckOfCards[i]);
		}
		
	} 
	
	//-----------method 3-------------------------------//
	
	
	//method for distributing the cards
	
	public void distributeDeckOfCards1D(int players, int cards)
	{
		//loop for n players
		for(int i=0;i<players;i++)
		{
			System.out.println();
			
			System.out.println("Player"+(i+1));
			
			System.out.println();
			
			
			//loop for distributing 9 cards to these 4 players
			for(int j=0;j<cards;j++)
			{
				 DD[i][j]= deckOfCards[i+j*4];
				 
				System.out.println(DD[i][j]);
				
			
				
			}
		}
	
	} 
	
	
	
	//-----------method 4-------------------------------//
	
	//method for distributing the cards inside the queue
	
	
	public static void deckOfCardsQueue(String[] suits, String[] ranks) 
	{

		String array[][] = new String[20][20];

		// initialize deck
		int numberOfCards = suits.length * ranks.length;
		String[] deck = new String[numberOfCards];

		// initialize deck
		for (int i = 0; i < ranks.length; i++) {
			for (int j = 0; j < suits.length; j++) {
				deck[suits.length * i + j] = ranks[i] + "->" + suits[j];
				// System.out.print(""+(deck[suits.length*i + j]));
			}
		}

		// shuffle cards
		for (int i = 0; i < numberOfCards; i++)
		{
			int random = i + (int) ( Math.random() * (numberOfCards - i) );
			String temp = deck[random];
			deck[random] = deck[i];
			deck[i] = temp;
		}

		QueueDeck queueDeck = new QueueDeck();
		// distribute 9 cards to 4 player
		for (int i = 0; i < 4; i++) 
		{
			System.out.print("Player" + (i + 1) + "\n");
			for (int j = 0; j < 9; j++) 
			{
				array[i][j] = (deck[i + j * 4]);
				// System.out.println(" " + array[i][j]);
				queueDeck.push(array[i][j]);
				// System.out.println("" + queue);
			}
			System.out.println("\n");
		}
	}//method end
	
	
	//----------------------------------------//
	/*	QueueDeck queueDeck = new QueueDeck();
		
		public void distributeDeckOfCards1DinsideQueue(int players, int cards)
		{
			//loop for n players
			for(int i=0;i<players;i++)
			{
				System.out.println();
				
				System.out.println("Player"+(i+1));
				
				System.out.println();
				
				
				//loop for distributing 9 cards to these 4 players
				for(int j=0;j<cards;j++)
				{
					 DD[i][j]= deckOfCards[i+j*4];
					 
					 queueDeck.push(DD[i][j]);
					System.out.println(DD[j]);
				}
				
				
			}
		
		} 
		
	
	
	//method for sorting 
	
	public void sorting()
	{
			String[] arr = new String[9];
			
			
			char[] last1 = new char[2];
			char[] last2 = new char[2];
			
			String temp1, temp2, temp3, temp4;
			
			for (int p = 0; p < 4; p++)
			{
				for (int j = 0; j < 9; j++)
				{
					arr[j] =DD[p+j*4] ; //gaping the no of players and then passing the next card to the same player.
			
				}
			
		
	//	System.out.println();
		for (int i = 0; i < arr.length - 1; i++)
		{
			for (int j = 0; j < arr.length - i - 1; j++) 
			{
					temp1 = arr[j];
					temp2 = arr[j + 1];
				
					last1[0] = temp1.charAt(temp1.length() - 2);
					last1[1] = temp1.charAt(temp1.length() - 1);
					
					
					last2[0] = temp2.charAt(temp2.length() - 2);
					last2[1] = temp2.charAt(temp2.length() - 1);
					
					if (Arrays.compare(last1, last2) > 0) 
					{
						temp3 = arr[j];
						arr[j] = arr[j + 1];
						arr[j + 1] = temp3;
				
					}
		
			}
	
		}
	
			//	System.out.println();
		queue.enQueue("For Player " + p + " : \n");
		for (int j = 0; j < 9; j++) 
		{
			temp4 = arr[j].substring(0, arr[j].length() - 2);
			// System.out.print(temp4+"-->");
			queue.enQueue(temp4 + "-->");
		}
		// System.out.println();
		queue.enQueue("\n");
		
		
		}
		// printing the queue
		System.out.println(queue.showQueueWithoutSpace());
	
	
	}             */
	
	
	
	
	
	
	//main method
	public static void main(String[] args)
		{
			DeckOfCardsSorting ds=new DeckOfCardsSorting();
			
			System.out.println("deck of 52 cards are:");
			System.out.println();
			ds.deckOfCardsArray();
			System.out.println();
			
			
			
			System.out.println("the shuffled cards are:");
			
			ds.shuffledeckOfCardsArray(); //output in vertical manner
			
			System.out.println(Arrays.toString(ds.deckOfCards));   //output in horizontal manner
			
			
			ds.distributeDeckOfCards1D(4, 9);
			
			//ds.distributeDeckOfCards1DinsideQueue(4,9);
			
			ds.deckOfCardsQueue(suitArray, rankArray);
			
		
		  }
			
			
			
			

		

	
}
