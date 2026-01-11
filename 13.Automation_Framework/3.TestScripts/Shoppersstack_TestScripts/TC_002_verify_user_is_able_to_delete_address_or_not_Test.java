package com.Shoppersstack_TestScripts;

import java.io.IOException;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.annotations.Test;

import com.Shopperstack_GenericUtility.Base_Test;
import com.Shopperstack_Pom.MyProfile_Page;
import com.Shopperstack_Pom.Myaddresses_Page;


public class TC_002_verify_user_is_able_to_delete_address_or_not_Test extends Base_Test
{
	@Test
	
	public void deleteAddress() throws InterruptedException, IOException
	{
		homePage.getAccountSettingBtn().click();
		homePage.getMyprofileBtn().click();
		
		MyProfile_Page myProfilePage= new MyProfile_Page(driver);
		myProfilePage.getMyAddressesBtn().click();
		
		Myaddresses_Page myaddressesPage=new Myaddresses_Page(driver);
		wait.until(ExpectedConditions.elementToBeClickable(myaddressesPage.getDeleteBtn())).click();
		wait.until(ExpectedConditions.elementToBeClickable(myaddressesPage.getYesBtn())).click();
		
		wait.until(ExpectedConditions.alertIsPresent());
		driver.switchTo().alert().accept();
		
		webDriverUtility.getWebPageScreenShot(driver);
		
	}

}






