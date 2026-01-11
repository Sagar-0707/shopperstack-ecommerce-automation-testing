package com.Shopperstack_Pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MyProfile_Page 
{
	public MyProfile_Page (WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	
	
	@FindBy(xpath = "//div[text()='My Addresses']" )
	private WebElement myAddressesBtn;    
	
	
	//TC_007....
	
	// ------------------------------------------------------------------
  // ADD LOCATOR FOR CHANGE PASSWORD (TC_007_Verify_Password_Change_And_Login_With_New_Password)
    // ------------------------------------------------------------------
    @FindBy(xpath = "//div[text()='Change Password' or @id='Change Password']")
    private static WebElement changePasswordLink;
    // ------------------------------------------------------------------


	
	
	 //genrate getter method for this myAddressesBtn
	public WebElement getMyAddressesBtn()
	{
		return myAddressesBtn;
	}

	//TC_007....
	
	// ------------------------------------------------------------------
    //ADD GETTER METHOD FOR CHANGE PASSWORD LINK (TC_007_Verify_Password_Change_And_Login_With_New_Password)
    // ------------------------------------------------------------------
    public static WebElement getChangePasswordLink()
    {
        return changePasswordLink;
    }
    // ------------------------------------------------------------------
	
}






