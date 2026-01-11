package com.Shoppersstack_TestScripts;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.testng.annotations.Test;

import com.Shopperstack_GenericUtility.Base_Test;
import com.Shopperstack_Pom.AddressForm_page;
import com.Shopperstack_Pom.MyProfile_Page;
import com.Shopperstack_Pom.Myaddresses_Page;


public class TC_001_verify_user_is_able_to_add_address_or_not_Test extends Base_Test
{
	@Test
	
	public void addAddress() throws EncryptedDocumentException,IOException, InterruptedException  
	{
		
		//System.out.println("address");      // changes in code
	
		homePage.getAccountSettingBtn().click();
		homePage.getMyprofileBtn().click();
		
		MyProfile_Page myProfilePage=new MyProfile_Page(driver);
		myProfilePage.getMyAddressesBtn().click();
		Thread.sleep(2000);
		
		Myaddresses_Page myaddressesPage=new Myaddresses_Page(driver);
		myaddressesPage.getAddAddressBtn().click();
		
		AddressForm_page addressFormPage=new AddressForm_page(driver);
		addressFormPage.getOfficeRadiobutton().click();
		
	addressFormPage.getNameTextFiled().sendKeys(fileUtility.readDataFromExcelFile("Sheet1", 0, 0));
	addressFormPage.getHouseTextFiled().sendKeys(fileUtility.readDataFromExcelFile("Sheet1", 1, 1));
	addressFormPage.getStreetTextFiled().sendKeys(fileUtility.readDataFromExcelFile("Sheet1", 1, 2));
	addressFormPage.getLandmarkTextFiled().sendKeys(fileUtility.readDataFromExcelFile("Sheet1", 1, 3));
		
	
	webDriverUtility.selectByvalue(addressFormPage.getCountryDropdown(),
			fileUtility.readDataFromPropertyFile("country"));
	
	webDriverUtility.selectByvalue(addressFormPage.getStateDropdown(),
			fileUtility.readDataFromPropertyFile("state"));
	
	webDriverUtility.selectByvalue(addressFormPage.getCityDropdown(),fileUtility.readDataFromPropertyFile("city"));
	
	
	addressFormPage.getPincodeTextFiled().sendKeys(fileUtility.readDataFromExcelFile("Sheet1", 1, 4));
	addressFormPage.getPhonenumberTextFiled().sendKeys(fileUtility.readDataFromExcelFile("Sheet1", 1, 5));
	
	
	myaddressesPage.getCloseBtn().click();
	
	
	//to take screenshot 
	
	webDriverUtility.getWebPageScreenShot(driver);

	}

}






