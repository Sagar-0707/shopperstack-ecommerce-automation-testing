package com.Shopperstack_GenericUtility;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Random;

public class Java_Utility 
{
	public int genrateRandomNumber() 
	{
		Random r=new Random();
	    int num =r.nextInt(1000);
	    return num;
	}
	
	
	public String getLocalDate() 
	{
		String date = LocalDate.now().toString().replace("-", "");
		return date;
	}
	
	public String getLocalDateAndTime() 
	{
		String datetime = LocalDateTime.now().toString().replace("-", "").replace(":", "").replace(".", "");
		return datetime;
		
	}


	public static String generateRandomNumber() {
		// TODO Auto-generated method stub
		return null;
	}

}






