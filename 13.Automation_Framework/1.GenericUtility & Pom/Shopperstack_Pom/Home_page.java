package com.Shopperstack_Pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Home_page 
{
	public Home_page(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//span[contains(@class,'BaseBadge-badge MuiBadge-badge MuiBadge')]")
	private WebElement accountSettingBtn;
	
	@FindBy(xpath = "//li[text()='My Profile']")
	private WebElement myProfileBtn;

	
	@FindBy(xpath = "//li[text()='Logout']")
	private WebElement logOutBtn;
	
	//Genrate getter for accountSettingBtn,myprofileBtn,logOutBtn.
	
	
	// ------------------------------------------------------------------------------------------
    // 💡 CHANGE 1: ADD LOCATOR FOR SEARCH FIELD(...TC_004_Verify_User_Can_Search_And_Add_Product_To_Cart)
    // -------------------------------------------------------------------------------------------
    // Locator for the Search input field (adjust XPath if needed after inspection)
	//@FindBy(xpath = "//input[@id='Search' or name='search']")
	@FindBy(id = "search")
    private WebElement searchTextField;
	
	
	// ------------------------------------------------------------------------------------------
    // ****************** FIX 2: ADDED SEARCH BUTTON LOCATOR ******************
    // -------------------------------------------------------------------------------------------
    @FindBy(id = "searchBtn") // *** NEW LOCATOR for the magnifying glass icon ***
    private WebElement searchButton;
    // -------------------------------------------------------------------------
	
    // ------------------------------------------------------------------------------------------	
 // ------------------------------------------------------------------------------------------
    // ADD LOCATOR FOR CART COUNT ELEMENT (...TC_004_Verify_User_Can_Search_And_Add_Product_To_Cart)
    // -------------------------------------------------------------------------------------------
    // Locator for the Cart Icon/Counter (adjust XPath after inspection)
    
    
    @FindBy(xpath = "//span[@data-testid='cart-count']")
    private WebElement cartCountElement;
    
    
    //TC_005.....
    
    
    
    // -------------------------------------------------------------------------------------- 
    
 // ------------------------------------------------------------------------------------------
    // ADD LOCATOR FOR WISHLIST ICON(.........TC_005_Verify_Wishlist_Functionality)
    // -------------------------------------------------------------------------------------------
    @FindBy(xpath = "//a[@data-testid='favorites' or @href='/wishlist']") 
    private WebElement wishlistIcon;
    // ------------------------------------------------------------------------------------------
    
    // ---------------------------------------------------------------------------------------
    
    
 // ****************** NEW LOCATOR FOR CATEGORY DROPDOWN ******************//(TC_004)
    @FindBy(id = "category") 
    private WebElement categoryDropdown;
    // ****************** END NEW LOCATOR ******************
    
    //getter method for Category
    
 // ****************** NEW GETTER FOR CATEGORY DROPDOWN ******************//(Tc...004)
    public WebElement getCategoryDropdown()
    {
        return categoryDropdown;
    }
    
    
    
    
  
    
    //getter method for search button.....(TC_004 changes add this)
    
    
 // --------------------------------------------------------------------------------------------
    public WebElement getSearchButton() // *** NEW GETTER METHOD ***
    {
        return searchButton;
    }
    // --------------------------------------------------------------------------
    
    
    


	public WebElement getAccountSettingBtn() 
	{
		return accountSettingBtn;
	}


	public WebElement getMyprofileBtn() 
	{
		return myProfileBtn;
	}

   public WebElement getLogOutBtn() 
	{
		return logOutBtn;
	}
   
   
     //TC_004...
   
    //---------------------------------------------------------------------------------------------
   //  ADD GETTER METHOD (...TC_004_Verify_User_Can_Search_And_Add_Product_To_Cart)
   // --------------------------------------------------------------------------------------------
   public WebElement getSearchTextField()
   {
       return searchTextField;
   }
   // ------------------------------------------------------------------------------------------
   
 //---------------------------------------------------------------------------------------------
   //  ADD GETTER METHOD FOR CART COUNT ELEMENT (...TC_004_Verify_User_Can_Search_And_Add_Product_To_Cart)
   // --------------------------------------------------------------------------------------------
   public WebElement getCartCountElement()
   {
       return cartCountElement;
   }
   // ----------------------------------------------------------------------------------------
   
   
   
   
   //Tc_005.....
   
 //---------------------------------------------------------------------------------------------
   //ADD GETTER METHOD FOR WISHLIST ICON(............TC_005_Verify_Wishlist_Functionality)
   // --------------------------------------------------------------------------------------------
   public WebElement getWishlistIcon()
   {
       return wishlistIcon;
   }
   // -------------------------------------------------------------------------
   
   
   
   
// -------------------------------------------------------------------------
   // 💡 HIGHLIGHTED CHANGE: ADD THE MISSING LOGOUT(TC_007_Verify_Password_Change_And_Login_With_New_Password)
   // -------------------------------------------------------------------------
   public void logout() {
       accountSettingBtn.click();
       logOutBtn.click();
   }
   // ------------------------------------------------------------------------
   
   
   

 }






