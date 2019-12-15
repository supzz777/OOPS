package com.brideglabz.oops.inventorypulses;

import java.io.File;
import java.io.IOException;

import org.codehaus.jackson.JsonParseException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;
public class InventoryDetails     
{
	public static void main(String[] args) throws JsonParseException, JsonMappingException, IOException 
	{  
   
		 // for reading the inventory values.
		String path1 ="/home/admin28/Desktop/FellowshipProgramsJavaSupzz/OOPS/inventorydetails.json";
		String path2="/home/admin28/Desktop/FellowshipProgramsJavaSupzz/OOPS/inventory_detailsOutput.json";
		 
		
		File file = new File("/home/admin28/Desktop/inventorydetails.json");
		ObjectMapper mapper = new ObjectMapper();
  
		// method to write into file 
		InventoryDetailModel model = mapper.readValue(new File(path1), InventoryDetailModel.class);

		int total = 0; 
		 
		//we want only name and price per kg of product. 
		System.out.println("wheats : " + model.getRice().get(0).getName());
		System.out.println("Price : " + model.getRice().get(0).getPrice_per_kg()); 
		total += model.getRice().get(0).getPrice_per_kg(); 
		
		System.out.println("wheats : " + model.getWheats().get(0).getName());
		System.out.println("Price : " + model.getWheats().get(0).getPrice_per_kg());
		total += model.getWheats().get(0).getPrice_per_kg(); 
		
		
		System.out.println("pulses : " + model.getPulses().get(0).getName());
		System.out.println("Price : " + model.getPulses().get(0).getPrice_per_kg()); 
		total += model.getPulses().get(0).getPrice_per_kg();
		
		System.out.println("\nTotal : " + total); 
 
	// code for writing all details into new file
		model.setTotal(total);
		mapper.writeValue(new File(path2), model);
		System.out.println("\nWrite into file is completed!!!"); 
	} 

}
