package com.Shoppersstack_TestScripts;

import java.io.IOException;
import java.time.Duration;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.Keys;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import com.Shopperstack_GenericUtility.Base_Test;
import com.Shopperstack_Pom.ProductDetails_Page;
import com.Shopperstack_Pom.SearchResult_Page;
import org.openqa.selenium.support.ui.Select;

public class TC_004_Verify_User_Can_Search_And_Add_Product_To_Cart extends Base_Test {

    @Test
    public void c() throws EncryptedDocumentException, IOException, InterruptedException {
       
    	// --- 1. FIX: SELECT 'ALL' CATEGORY FIRST --------------------------------------
        // *** FIX 3: SELECT THE "ALL" CATEGORY FROM DROPDOWN ***
        wait.until(ExpectedConditions.visibilityOf(homePage.getCategoryDropdown()));
        Select s = new Select(homePage.getCategoryDropdown());
        
        // Select the "all" option (assuming it is the first index or has a visible text "all")
        s.selectByVisibleText("all"); // Or s.selectByIndex(0);
        // -------------------------------------------------------------------------
    	
    	
   
    	
    	// --- 2. SEARCH FOR PRODUCT ----------------------------------------------------------------
        System.out.println("Starting TC_004: Search for a product.");

        // Assuming Home_page has a search input field element
        String searchProduct = "laptop"; // You can read this from Excel/Property file too
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        
     // *** FIX 1: ADDED EXPLICIT WAIT FOR SYNCHRONIZATION (Resolves NoSuchElementException) ***
        wait.until(ExpectedConditions.visibilityOf(homePage.getSearchTextField())); 
        
        // Enter the product name
        homePage.getSearchTextField().sendKeys(searchProduct);
        
        // *** FIX 2: CHANGED Keys.ENTER to CLICK ACTION (Resolves search not submitting) ***
        homePage.getSearchButton().click(); // *** CALLING THE NEWLY ADDED GETTER ***
        
        

        // --- 2. NAVIGATE TO SEARCH RESULTS ----------------------------------------------------
        SearchResult_Page searchResultPage = new SearchResult_Page(driver);
        webDriverUtility.implicitWait(driver); // Use utility wait

        // Optional: Assert that results are displayed
        WebDriverWait wait1 = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait1.until(ExpectedConditions.visibilityOf(searchResultPage.getResultsFoundText()));
        
        System.out.println("Search results page loaded.");
        
        // --- 3. SELECT THE FIRST PRODUCT ------------------------------------------------------
        searchResultPage.getFirstProductLink().click();
        webDriverUtility.implicitWait(driver);

        // --- 4. ADD TO CART -------------------------------------------------------------------
        ProductDetails_Page productDetailsPage = new ProductDetails_Page(driver);
        
        // Optional: If the site requires size selection first
        // productDetailsPage.getProductSizeSelector().click(); 
        // Example: Wait for the Add to Cart button to be clickable
        wait1.until(ExpectedConditions.elementToBeClickable(productDetailsPage.getAddToCartButton()));
        
        productDetailsPage.getAddToCartButton().click();
        
        
        // --- 5. VERIFICATION ---------------------------------------------------------------------
        
        // Optional: Wait for a confirmation message or check the cart count element
        // Assuming the cart count element is on the Home_page and its text is updated
        wait1.until(ExpectedConditions.textToBePresentInElement(homePage.getCartCountElement(), "1")); 
        
        System.out.println("Product added to cart successfully. Verification done.");
        webDriverUtility.getWebPageScreenShot(driver);
    }
}