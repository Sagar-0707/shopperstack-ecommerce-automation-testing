package com.Shopperstack_Pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Welcome_page 
{
	public Welcome_page(WebDriver driver)
   {
		PageFactory.initElements(driver,this);
		
		}
//	@FindBy(xpath ="//button[@class='navbar_Loginbutton__O9-64']")
//	private WebElement loginbtn;
//
//   public WebElement getLoginbtn() 
//	{
//		return loginbtn;
//	}
	
// *** FIX THE LOCATOR HERE (It's almost certainly not id='loginBtn') ***
    
    // 💡 Option A (If the element is a button/link with the text "Login"):
    @FindBy(xpath = "//button[text()='Login']") 
    // OR: @FindBy(xpath = "//a[text()='Login']")
    private WebElement loginBtn; 
    
    // 💡 Option B (If the element is an ID that IS NOT 'loginBtn', e.g., 'loginLink'):
    // You must inspect the welcome page element to find the correct ID.
    
    // ... getter method ...
    public WebElement getLoginBtn() 
    {
        return loginBtn;
    }
	

}






