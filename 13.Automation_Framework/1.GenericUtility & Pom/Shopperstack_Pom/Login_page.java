package com.Shopperstack_Pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Login_page 
{
	public  Login_page(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(id="Email")
	private WebElement emailTextField;
	
	@FindBy(id="Password")
	private WebElement passwordtextfield;
	
	@FindBy(xpath="//span[text()='Login']")
	private WebElement loginBtn;

	//Genrate getter for .....
	
	public WebElement getEmailTextField() 
	{
		return emailTextField;
	}

	public WebElement getPasswordtextfield() 
	{
		return passwordtextfield;
	}

	public WebElement getLoginBtn() 
	{
		return loginBtn;
	}
	
}	
	
	
	





