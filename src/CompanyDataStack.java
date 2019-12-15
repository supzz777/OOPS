

import java.io.File;
import java.io.IOException;

import java.util.List;

import org.codehaus.jackson.JsonParseException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.type.TypeReference;




public class CompanyDataStack  
{
	public static void main(String[] args) throws JsonParseException, JsonMappingException, IOException
	{
		ObjectMapper mapper = new ObjectMapper();
		 
		String pathOfTransactionFile = "/home/admin28/Desktop/FellowshipProgramsJavaSupzz/OOPS/t.json"; 
		
		//List<Transaction> trans = new ArrayList<Transaction>(); 
//		List<Transaction> trans=  (List<Transaction>) mapper.readValue( new File(pathOfTransactionFile), Transaction.class);
//		System.out.println(trans);
//		System.out.println(trans.get(0).getSeller());
		
		TypeReference<List<Transaction>> typeReference = new TypeReference<List<Transaction>>() {};
		List<Transaction> trans = mapper.readValue(new File(pathOfTransactionFile), typeReference);
		System.out.println(trans);
	
	
 
	
		
		
		 
		
		
	}

}
