package com.qwic.assessment.qaAssesment.Util;

public class OsPath {
	
	//Provide browser exe path based on OS
	public static String getPath(String browser) 
	{
		String OS=System.getProperty("os.name");
		String driverPath=null;
		if(OS.toUpperCase().contains("WINDOWS"))
		{
			if(browser.toUpperCase().contains("CHROME"))
			{
				driverPath=".//src//test//resources//Config//chromedriver.exe";
			}
			else if(browser.toUpperCase().contains("FF")||browser.toUpperCase().contains("FIRE"))
			{
				driverPath=".//src//test//resources//Config//geckodriver.exe";
				
			}
		}
		else if(OS.toUpperCase().contains("MAC"))
		{
			if(browser.toUpperCase().contains("CHROME"))
			{
				driverPath=".//src//test//resources//Config//chromedriver";
			}
			else if(browser.toUpperCase().contains("FF")||browser.toUpperCase().contains("FIRE"))
			{
				driverPath=".//src//test//resources//Config//geckodriver";
			}
		}
		return driverPath;
	}

	
}
