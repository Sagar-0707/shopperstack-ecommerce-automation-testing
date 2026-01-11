package com.Shopperstack_Pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AddressForm_page
{
	public AddressForm_page(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(id="Office")
	private WebElement officeRadiobutton;
	
	@FindBy(id="Name")
	private WebElement nameTextFiled;
	
	@FindBy(id="House/Office Info")
	private WebElement  houseTextFiled;
	
	@FindBy(id="Street Info")
	private WebElement  streetTextFiled;
	
	@FindBy(id="Landmark")
	private WebElement  landmarkTextFiled;
	
	@FindBy(id="Country")
	private WebElement  countryDropdown;
	
	@FindBy(id="State")
	private WebElement  stateDropdown;
	
	@FindBy(id="City")
	private WebElement  cityDropdown;
	
	@FindBy(id="Pincode")
	private WebElement  pincodeTextFiled;
	
	@FindBy(id="Phone Number")
	private WebElement  phonenumberTextFiled;
	
	
	@FindBy(id="addAddress")
	private WebElement  addAddressBtn;

 //getter method for  OfficeRadiobutton.......addAddressBtn
	
	public WebElement getOfficeRadiobutton() 
	{
		return officeRadiobutton;
	}


	public WebElement getNameTextFiled() 
	{
		return nameTextFiled;
	}


	public WebElement getHouseTextFiled() 
	{
		return houseTextFiled;
	}


	public WebElement getStreetTextFiled() 
	{
		return streetTextFiled;
	}


	public WebElement getLandmarkTextFiled() 
	{
		return landmarkTextFiled;
	}


	public WebElement getCountryDropdown()
	{
		return countryDropdown;
	}


	public WebElement getStateDropdown()
	{
		return stateDropdown;
	}


	public WebElement getCityDropdown() 
	{
		return cityDropdown;
	}


	public WebElement getPincodeTextFiled() 
	{
		return pincodeTextFiled;
	}


	public WebElement getPhonenumberTextFiled() 
	{
		return phonenumberTextFiled;
	}


	public WebElement getAddAddressBtn() 
	{
		return addAddressBtn;
	}
	
}






