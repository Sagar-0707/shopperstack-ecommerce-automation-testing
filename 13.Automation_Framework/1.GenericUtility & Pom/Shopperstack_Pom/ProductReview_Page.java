package com.Shopperstack_Pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ProductReview_Page {

    WebDriver driver;

    public ProductReview_Page(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    // --- Review Form Elements ---
    
    // Locator for the "Write a Review" button 
    @FindBy(xpath = "//button[contains(text(),'Write a Review') or contains(text(),'Add Review')]")
    private WebElement writeReviewButton;
    
    // Locator for the Star Rating element (e.g., clicking the 5th star)
    // Note: Adjust the index [5] if your site uses a different star implementation
    @FindBy(xpath = "//div[@role='radiogroup']/label[5]") 
    private WebElement fiveStarRating;

    // Locator for the Review Title text field
    @FindBy(xpath = "//input[@name='reviewTitle']")
    private WebElement reviewTitleTextField;

    // Locator for the Review Body (Description) text area
    @FindBy(xpath = "//textarea[@name='reviewBody']")
    private WebElement reviewBodyTextArea;

    // Locator for the Submit Review button
    @FindBy(xpath = "//button[text()='Submit Review' or @type='submit']")
    private WebElement submitReviewButton;

    // --- Verification Elements ---
    
    // Locator to find the submitted Review Title on the page (use a general locator if possible)
    @FindBy(xpath = "//h4[@class='MuiTypography-root MuiTypography-h4']") 
    private WebElement reviewTitleDisplay;
    
    // Locator for a general success message after submission
    @FindBy(xpath = "//div[contains(text(),'Review submitted successfully')]")
    private WebElement successMessage;


    // Getter methods
    public WebElement getWriteReviewButton() {
        return writeReviewButton;
    }

    public WebElement getFiveStarRating() {
        return fiveStarRating;
    }

    public WebElement getReviewTitleTextField() {
        return reviewTitleTextField;
    }

    public WebElement getReviewBodyTextArea() {
        return reviewBodyTextArea;
    }

    public WebElement getSubmitReviewButton() {
        return submitReviewButton;
    }

    public WebElement getReviewTitleDisplay() {
        return reviewTitleDisplay;
    }
    
    public WebElement getSuccessMessage() {
        return successMessage;
    }
}