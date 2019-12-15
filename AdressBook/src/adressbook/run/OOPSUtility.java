package adressbook.run;

import java.util.Date;
import java.util.Random;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Scanner;

/**
 * @author supzz
 *
 */
public class OOPSUtility
{

	
	static Scanner sc ;

	// method for taking the integer input form the user

	
	public static int IntegerInput()
	{ 
		sc = new Scanner(System.in);

		return sc.nextInt();
	}

	// method for taking the double input form the user

	public static double DoubleInput()
	{
		sc = new Scanner(System.in);

		return sc.nextDouble();
	}

	// method for taking the String input form the user

	public static String StringInput() 
	{
		sc = new Scanner(System.in);

		return sc.nextLine();
	}
	
	// method for printing the date by the user
	
	public static Date printDate(String date)
	{
		SimpleDateFormat sdf = new SimpleDateFormat("dd/mm/yyyy");
		try{
			return  (Date) sdf.parse(date);
		}
		catch(ParseException pe)
		{
			return null;
		}
	}

	public static char charScanner()
	{
		sc = new Scanner(System.in);
		return sc.next().charAt(0);
	}

	
	
	
	public static int calculateTotalValueOfStock(int numberOfShares, int sharePrice) 
	{
		return numberOfShares * sharePrice; 
	}

	
	public static String message(String fullname, String mobile, String str) {

		DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
		Date date = new Date();
		String firstName = fullname.substring(0, fullname.indexOf(' '));
		String strInput = str;
		String str1 = strInput.replaceAll("<<name>>", firstName);
		String str2 = str1.replaceAll("<<fullname>>", fullname);
		String str3 = str2.replaceAll("xxxxxxxxxx", mobile);
		String str4 = str3.replaceAll("Date", dateFormat.format(date));

		return str4;

	}
	
	
}
	
	

