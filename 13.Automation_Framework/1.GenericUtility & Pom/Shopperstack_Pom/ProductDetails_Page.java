package com.Shopperstack_Pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ProductDetails_Page {

    WebDriver driver;

    public ProductDetails_Page(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    // Locator for the "Add to Cart" button
    @FindBy(xpath = "//button[text()='add to cart']")
    private WebElement addToCartButton;

    // Locator for the product size selector (if present, use a generic one)
    // You may need to inspect the page for the correct size selection element
    @FindBy(xpath = "//button[@aria-label='Product Size']") 
    private WebElement productSizeSelector; 
    
    // Locator for the product name on the details page
    @FindBy(xpath = "//h1")
    private WebElement productNameText;
    
    
 // ------------------------------------------------------------------
    // ADD LOCATOR FOR ADD TO WISHLIST BUTTON....)
    // ------------------------------------------------------------------
    // Locator for the Add to Wishlist button/icon (often a heart icon)
    @FindBy(xpath = "//button[@aria-label='Add to wishlist' or @data-testid='AddToWishlist']") 
    private WebElement addToWishlistBtn;
    
    //i am changing name here (so we are adding 1 here)
    // ------------------------------------------------------------------
    
    

    // Getter method for the Add to Cart button
    public WebElement getAddToCartButton() {
        return addToCartButton;
    }

    // Getter method for the product name
    public WebElement getProductNameText() {
        return productNameText;
    }
    
    // Getter method for the product size selector
    public WebElement getProductSizeSelector() 
    {
        return productSizeSelector;
    }
    
 // ------------------------------------------------------------------
    // 💡 HIGHLIGHTED CHANGE: ADD THE MISSING GETTER METHOD (Fixes the error)
    // ------------------------------------------------------------------
    public WebElement getAddToWishlistBtn() {
        return addToWishlistBtn;
    }
    // ------------------------------------------------------------------
     
}