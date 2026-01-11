package com.Shopperstack_GenericUtility;
	
public interface FrameWorkConstants
{
	
	Java_Utility javaUtility = new Java_Utility();
	
	final static String propertyFilepath ="./src/test/resources/testData/shopperproperty.properties";
	
	final static String excelFilePath ="./src/test/resources/testData/Data.xlsx";
	
	final static String screenshotPath ="./src/main/resources/screenshot/"+javaUtility.getLocalDateAndTime()+".png";
	
	final static String reportsPath ="./src/main/resources/reports/"+javaUtility.getLocalDateAndTime()+".html";
	
	
	final static String chromekey="webdriver.chrome.driver";
	
    final static String chromeValue="./src/main/resources/driver/chromedriver.exe";
	
	
	}








