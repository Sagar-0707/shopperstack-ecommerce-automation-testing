package com.Shopperstack_Pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SearchResult_Page 
{
	 WebDriver driver;

    public SearchResult_Page(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    // Locator for the first product displayed in the search results
    // We target the link or image of the first result using index [1]
    // Note: You may need to inspect your site to fine-tune this XPath
    @FindBy(xpath = "(//div[contains(@class,'MuiCardContent-root')]//h3)[1]")
    private WebElement firstProductLink;

    // Locator for the search results count or a section header to verify the page loaded
    @FindBy(xpath = "//span[contains(text(),'results found')]")
    private WebElement resultsFoundText;

    // Getter method for the first product link
    public WebElement getFirstProductLink() {
        return firstProductLink;
    }

    // Getter method for verification text
    public WebElement getResultsFoundText() {
        return resultsFoundText;
    }
}