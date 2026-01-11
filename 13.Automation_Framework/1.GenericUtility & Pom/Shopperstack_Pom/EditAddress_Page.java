package com.Shopperstack_Pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class EditAddress_Page {
    public EditAddress_Page(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    

    @FindBy(id = "Home") // Example: You might want to change the address type during edit
    private WebElement homeRadiobutton;

    @FindBy(id = "Name")
    private WebElement nameTextFiled;

    @FindBy(id = "House/Office Info")
    private WebElement houseTextFiled;

    @FindBy(id = "Street Info")
    private WebElement streetTextFiled;

    @FindBy(id = "Landmark")
    private WebElement landmarkTextFiled;

    @FindBy(id = "Country")
    private WebElement countryDropdown;

    @FindBy(id = "State")
    private WebElement stateDropdown;

    @FindBy(id = "City")
    private WebElement cityDropdown;

    @FindBy(id = "Pincode")
    private WebElement pincodeTextFiled;

    @FindBy(id = "Phone Number")
    private WebElement phonenumberTextFiled;
    
    // CRITICAL: The ID for the update button is usually different from the Add button's ID ("addAddress")
    @FindBy(id = "Update Address") // **VERIFY THIS ID/LOCATOR** on the Edit Address modal/page
    private WebElement updateAddressBtn;
    
    
    // --- Getter Methods for all elements ---

    public WebElement getHomeRadiobutton() {
        return homeRadiobutton;
    }

    public WebElement getNameTextFiled() {
        return nameTextFiled;
    }

    public WebElement getHouseTextFiled() {
        return houseTextFiled;
    }

    public WebElement getStreetTextFiled() {
        return streetTextFiled;
    }

    public WebElement getLandmarkTextFiled() {
        return landmarkTextFiled;
    }

    public WebElement getCountryDropdown() 
    {
        return countryDropdown;
    }

    public WebElement getStateDropdown() {
        return stateDropdown;
    }

    public WebElement getCityDropdown() {
        return cityDropdown;
    }

    public WebElement getPincodeTextFiled() {
        return pincodeTextFiled;
    }

    public WebElement getPhonenumberTextFiled() {
        return phonenumberTextFiled;
    }

    public WebElement getUpdateAddressBtn() {
        return updateAddressBtn;
    }
}