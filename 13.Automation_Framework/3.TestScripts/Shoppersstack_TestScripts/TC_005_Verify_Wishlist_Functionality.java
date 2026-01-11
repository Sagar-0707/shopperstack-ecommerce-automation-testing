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
import com.Shopperstack_Pom.ProductDetails_Page;
import com.Shopperstack_Pom.SearchResult_Page;
import com.Shopperstack_Pom.Wishlist_Page;

public class TC_005_Verify_Wishlist_Functionality extends Base_Test {

    @Test
    public void verifyWishlistCycle() throws EncryptedDocumentException, IOException, InterruptedException {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        
        // --- PRE-REQUISITE: FIND AND SELECT A PRODUCT ---
        System.out.println("Starting TC_005: Wishlist Add/Verify/Remove Cycle.");
        String searchProduct = "jacket"; // Search term
        
        // 1. Search for a product (assuming Home_page has getSearchTextField())
        homePage.getSearchTextField().sendKeys(searchProduct);
        homePage.getSearchTextField().sendKeys(Keys.ENTER);

        SearchResult_Page searchResultPage = new SearchResult_Page(driver);
        wait.until(ExpectedConditions.visibilityOf(searchResultPage.getResultsFoundText()));
        
        // 2. Click the first product link
        searchResultPage.getFirstProductLink().click();
        webDriverUtility.implicitWait(driver);

        ProductDetails_Page productDetailsPage = new ProductDetails_Page(driver);
        wait.until(ExpectedConditions.visibilityOf(productDetailsPage.getProductNameText()));
        
        // Store the product name for verification later
        String productTitle = productDetailsPage.getProductNameText().getText();
        System.out.println("Product selected: " + productTitle);


        // --- PART 1: ADD TO WISHLIST ---
        // Assuming ProductDetails_Page has a method like getAddToWishlistBtn()
        productDetailsPage.getAddToWishlistBtn().click(); 
        System.out.println("Product added to wishlist.");


        // --- PART 2: NAVIGATE AND VERIFY ---
        // Assuming Home_page has a method like getWishlistIcon()
        homePage.getWishlistIcon().click();
        
        Wishlist_Page wishlistPage = new Wishlist_Page(driver);
        wait.until(ExpectedConditions.visibilityOf(wishlistPage.getProductTitleInWishlist()));
        
        // Verification: Check if the product title in the wishlist matches the added product title
        String wishlistProductTitle = wishlistPage.getProductTitleInWishlist().getText();
        Assert.assertEquals(wishlistProductTitle, productTitle, "Verification Failed: Product title in Wishlist does not match the added product.");
        System.out.println("Verification successful: Product is present in the Wishlist.");


        // --- PART 3: REMOVE FROM WISHLIST ---
        wishlistPage.getRemoveButton().click();
        
        // Handle confirmation dialog/ popup (if one appears)
        // If a simple modal appears, you might need to click a confirmation button:
        // driver.findElement(By.xpath("//button[text()='Yes, Remove']")).click();

        // Verification: Wait for the " Wishlist " is empty" message to confirm removal
        wait.until(ExpectedConditions.visibilityOf(wishlistPage.getEmptyWishlistMessage()));
        Assert.assertTrue(wishlistPage.getEmptyWishlistMessage().isDisplayed(), "Verification Failed: Wishlist item was not successfully removed.");
        System.out.println("Product successfully removed from Wishlist. Test Passed.");
        
        webDriverUtility.getWebPageScreenShot(driver);
    }
}