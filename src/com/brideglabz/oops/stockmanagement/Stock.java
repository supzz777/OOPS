package com.brideglabz.oops.stockmanagement;

import java.io.File;
import java.io.IOException;

import org.codehaus.jackson.JsonParseException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;


public class Stock  
{  
	public static void main(String[] args) throws JsonParseException, JsonMappingException, IOException
	{
		String stockpath = "/home/admin28/Desktop/FellowshipProgramsJavaSupzz/JsonReadWrite/stock.json";
		String stockoutputPath = "/home/admin28/Desktop/FellowshipProgramsJavaSupzz/JsonReadWrite/stockOutput.json";
  
		ObjectMapper mapper = new ObjectMapper(); 

		StockModel data = mapper.readValue(new File(stockpath), StockModel.class);
		
		  
		System.out.println("Stock Report"); 
		
		//stock report of green mehendi.
		System.out.println("Stock Name: " + data.getGreenMehendiList().get(0).getStock_name());
		System.out.println("Stock Price: " +data.getGreenMehendiList().get(0).getShare_price());
		System.out.println("Stock Number of Shares: " + data.getGreenMehendiList().get(0).getNumber_of_shares());
		System.out.println();
		
		
		
			//multiplying the two values i.e no. of shares and share price and passing the value into TotalValueOfStock.
		                          
		int totalValueOfGreen =data.getGreenMehendiList().get(0).getNumber_of_shares()*
		data.getGreenMehendiList().get(0).getShare_price();
		System.out.println("Total value of Stock Parle -->" + totalValueOfGreen);

		data.getGreenMehendiList().get(0).setTotalValueOfStock(totalValueOfGreen);
		
		System.out.println("TotalValueOfStock of parle :" +data.getGreenMehendiList().get(0).getTotalValueOfStock());

		//--------------------------------------------------------------------------------------------------------------//
		
		//stock report of nupur mehendi.
		
		System.out.println();
		System.out.println("Stock Name: " + data.getNupurMehendiList().get(0).getStock_name());
		System.out.println("Stock Price: " + data.getNupurMehendiList().get(0).getShare_price());
		System.out.println("Stock Number of Shares: " + data.getNupurMehendiList().get(0).getNumber_of_shares());
		System.out.println(); 
		
			
		int totalValueOfNupur =/* OOPSUtility.calculateTotalValueOfStock(*/data.getNupurMehendiList().get(0).getNumber_of_shares()*
				data.getNupurMehendiList().get(0).getShare_price();
		System.out.println("Total value of Stock Marie -->" + totalValueOfNupur);
		data.getNupurMehendiList().get(0).setTotalValueOfStock(totalValueOfNupur);
		
		System.out.println("TotalValueOfStock of parle :" +data.getNupurMehendiList().get(0).getTotalValueOfStock());

		//----------------------------------------------------------------------------------------------------------------//
		
		//stock report of lal mehendi.
		
		System.out.println();
		System.out.println("Stock Name: " + data.getLalMehendiList().get(0).getStock_name());
		System.out.println("Stock Price: " + data.getLalMehendiList().get(0).getShare_price());
		System.out.println("Stock Number of Shares: " + data.getLalMehendiList().get(0).getNumber_of_shares());
		System.out.println();
		
		
		int totalValueOfLal =/* OOPSUtility.calculateTotalValueOfStock(*/data.getLalMehendiList().get(0).getNumber_of_shares()*
				data.getLalMehendiList().get(0).getShare_price();
		System.out.println("Total value of Stock Oreo -->" + totalValueOfLal);
		data.getLalMehendiList().get(0).setTotalValueOfStock(totalValueOfLal);
		
		System.out.println("TotalValueOfStock of parle :" +data.getLalMehendiList().get(0).getTotalValueOfStock());
		
		//--------------------------------------------------------------------------------------------------------------//
 
		
		//stock report of heena mehendi.
		
		
		System.out.println();
		System.out.println("Stock Name: " + data.getHeenaMehendiList().get(0).getStock_name());
		System.out.println("Stock Price: " + data.getHeenaMehendiList().get(0).getShare_price());
		System.out.println("Stock Number of Shares: " + data.getHeenaMehendiList().get(0).getNumber_of_shares());
		System.out.println();
		
		
		int totalValueOfHeena =/* OOPSUtility.calculateTotalValueOfStock(*/data.getHeenaMehendiList().get(0).getNumber_of_shares()*
				data.getHeenaMehendiList().get(0).getShare_price();
	 	System.out.println("Total value of Stock Tiger -->" + totalValueOfHeena);
		data.getHeenaMehendiList().get(0).setTotalValueOfStock(totalValueOfHeena);

		int totalValueOfAllStock = totalValueOfGreen + totalValueOfNupur + totalValueOfLal + totalValueOfHeena;
		
		
		//----------------------------------------------------------------------------------------------------------------//

		data.setTotalValueOfAllStock(totalValueOfAllStock); 
		System.out.println();
		System.out.println("Total count of all stocks -->" + totalValueOfAllStock);
		System.out.println();
		System.out.println("Stock Report");
		
		
		// code for writing all details into new file
		mapper.writeValue(new File(stockoutputPath), data);
		System.out.println("\nWrite into file is completed!!!");  
	}

}
