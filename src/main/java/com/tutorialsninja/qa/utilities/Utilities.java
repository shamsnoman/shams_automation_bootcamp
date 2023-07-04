package com.tutorialsninja.qa.utilities;

import java.time.Duration;
import java.util.Date;

public class Utilities {

	public static String emailWithDateTimeStamp() {
		Date date = new Date();
		String emailDatetimeStamp = date.toString().replace(" ", "_").replace(":", "_");
		return "automation" + emailDatetimeStamp+"@email.com";
	}
	
	public final static int IMPLICIT_WAIT = 100;
	public static final int PAGELOAD_TIMEOUT = 100;
	public final static int SCRIPT_TIMEOUT = 1000;
	
	
	
	
	
}
