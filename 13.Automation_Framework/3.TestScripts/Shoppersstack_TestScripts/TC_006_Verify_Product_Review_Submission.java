package com.Shoppersstack_TestScripts;

import java.io.IOException;
import java.time.Duration;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.Keys;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.Shopperstack_GenericUtility.Base_Test;
import com.Shopperstack_GenericUtility.Java_Utility;
import com.Shopperstack_Pom.ProductDetails_Page; 
import com.Shopperstack_Pom.ProductReview_Page; 
import com.Shopperstack_Pom.SearchResult_Page;  

import org.openqa.selenium.By; // (...TC_006 changes.....)

public class TC_006_Verify_Product_Review_Submission extends Base_Test {

    @Test
    public void submitAndVerifyReview() throws EncryptedDocumentException, IOException, InterruptedException {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        
        // Create a unique review title to verify later
     // Create a unique review title to verify later
        // 💡 HIGHLIGHTED CHANGE 2: Corrected 'javautility' object name to 'javaUtility' (assuming it's defined in Base_Test)
        String reviewTitle = "Auto Test Review " + Java_Utility.generateRandomNumber(); 
        String reviewBody = "This product performs as expected for automation testing.";
        String searchTerm = "t-shirt";

        // --- 1. FIND A PRODUCT TO REVIEW (Reusing search logic) ---
        System.out.println("Starting TC_006: Submitting and verifying a product review.");
        
        homePage.getSearchTextField().sendKeys(searchTerm);
        homePage.getSearchTextField().sendKeys(Keys.ENTER);

        SearchResult_Page searchResultPage = new SearchResult_Page(driver);
        wait.until(ExpectedConditions.visibilityOf(searchResultPage.getResultsFoundText()));
        searchResultPage.getFirstProductLink().click();
        webDriverUtility.implicitWait(driver);


        // --- 2. OPEN AND FILL THE REVIEW FORM ---
        ProductReview_Page reviewPage = new ProductReview_Page(driver);
        
        // Click the 'Write a Review' button and wait for form elements
        wait.until(ExpectedConditions.elementToBeClickable(reviewPage.getWriteReviewButton()));
        reviewPage.getWriteReviewButton().click();
        
        wait.until(ExpectedConditions.elementToBeClickable(reviewPage.getFiveStarRating()));
        reviewPage.getFiveStarRating().click();
        
        reviewPage.getReviewTitleTextField().sendKeys(reviewTitle);
        reviewPage.getReviewBodyTextArea().sendKeys(reviewBody);


        // --- 3. SUBMIT THE REVIEW ---
        reviewPage.getSubmitReviewButton().click();
        System.out.println("Review submitted with title: " + reviewTitle);
        
        // Verification 1: Check for the success message
        wait.until(ExpectedConditions.visibilityOf(reviewPage.getSuccessMessage()));
        Assert.assertTrue(reviewPage.getSuccessMessage().isDisplayed(), "Review submission failed: Success message not displayed.");

        

// --- 4. VERIFY THE REVIEW IS VISIBLE ON THE PAGE ---(TC_006_Verify_Product_Review_Submission )
        
   // Wait until the submitted review title is visible on the page (using the review title display element's locator)
   // The method requires a 'By' locator. We will use By.xpath() with the review title display's locator.
        String reviewTitleXpath = "//h4[contains(text(), '" + reviewTitle + "')]"; 
   // Create dynamic XPath
        
        
        
        
        
        
        wait.until(ExpectedConditions.textToBePresentInElementLocated(
            By.xpath(reviewTitleXpath), // Use By.xpath and the dynamic XPath
            reviewTitle
        ));
        
        Assert.assertTrue(driver.getPageSource().contains(reviewTitle), "Verification Failed: Submitted review title is not visible on the product page.");
        System.out.println("Review verification successful. Test Passed.");

        webDriverUtility.getWebPageScreenShot(driver);
    }
}