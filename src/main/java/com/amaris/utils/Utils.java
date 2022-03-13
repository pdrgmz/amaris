package com.amaris.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Utils {
	
	private Utils() {
	}
	
	public static Date newDate(String date) throws ParseException{
		if(date == null) {			
			return new Date();
		}
		return new SimpleDateFormat(Constants.DATE_FORMAT).parse(date);
	}

}
