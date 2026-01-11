package com.Shopperstack_Pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Myaddresses_Page 
 {
	public Myaddresses_Page (WebDriver driver)
  {
	  PageFactory.initElements(driver, this);
  }
  
   @FindBy(xpath = "//button[text()='Add Address']")
  private WebElement addAddressBtn;
  
  
  
  // this is for edit address Button....(Changes for edit address)
  //@FindBy(xpath = "//svg[@id='editaddress_fl']/parent::button") 
  //private WebElement editAddressBtn;
  
  @FindBy(xpath = "(//button[contains(@aria-label, 'edit') or contains(@aria-label, 'Edit') or span[contains(@class,'MuiButton-startIcon')]])[1]") 
  private WebElement editAddressBtn;
  
//Alternatively, if the Edit icon is always the first icon on the page, use this:
//@FindBy(xpath = "(//button[span[contains(@class,'MuiButton-startIcon')]])[1]") 
//private WebElement editAddressBtn;
  
  
  
  
 
  
  
  
  @FindBy(xpath = "(//span[contains(@class,'MuiButton-startIcon MuiButton')])[2]")
  private WebElement deleteBtn;
  
  @FindBy(xpath = "//button[text()='Yes']")
  private WebElement yesBtn;
  
  @FindBy(xpath = "//button[@aria-label='close']")
  private WebElement closeBtn;
  
  
  //Genrate getter.....
  

  public WebElement getCloseBtn()
  {
  	return closeBtn;
  }
  
  
 public WebElement getAddAddressBtn() 
{
	return addAddressBtn;
	
}

public WebElement getDeleteBtn() 
{
	return deleteBtn;
}

public WebElement getYesBtn() 
{
	return yesBtn;
}




//getter method for EDit address section.....(changes for edit address)

public WebElement getEditBtn() 
{
    return editAddressBtn;
}


  
 }






