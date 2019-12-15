package com.bridgelabz.oops.utility;

import java.io.IOException;

import org.codehaus.jackson.JsonParseException;
import org.codehaus.jackson.map.JsonMappingException;

import com.brideglabz.oops.repository.JsonUtil;




public class StockAccountUtility
{
	//this method will read the customer accounts and will return it
	
	public static Object stockAccount(String fileName, Object object)
			throws JsonParseException, JsonMappingException, IOException 
	{
		return JsonUtil.readMapper(fileName, object.getClass());
	}

	
	
	
	
	//save the data
	
	public static String save(String filename, Object object)
			throws JsonParseException, JsonMappingException, IOException {
		JsonUtil.writeMapper(filename, object);
		return "Saving successful";
	}

	
}
