package com.Shopperstack_Pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Wishlist_Page {

    WebDriver driver;

    public Wishlist_Page(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    // Locator for the product name/title in the Wishlist table/list
    // Note: You will need to inspect your site to fine-tune this XPath
    @FindBy(xpath = "//div[contains(@class,'MuiPaper-root')]//h3")
    private WebElement productTitleInWishlist;
    
    // Locator for the Delete/Remove button on the first item in the Wishlist
    @FindBy(xpath = "(//button[contains(@aria-label,'Delete') or contains(text(),'Remove')])[1]")
    private WebElement removeButton;

    // Locator for an element that indicates the Wishlist is empty
    @FindBy(xpath = "//h3[contains(text(),'Your wishlist is empty')]")
    private WebElement emptyWishlistMessage;

    // Getter methods
    public WebElement getProductTitleInWishlist() {
        return productTitleInWishlist;
    }

    public WebElement getRemoveButton() {
        return removeButton;
    }
    
    public WebElement getEmptyWishlistMessage() {
        return emptyWishlistMessage;
    }
}