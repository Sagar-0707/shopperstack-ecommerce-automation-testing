package com.Shoppersstack_TestScripts;

import java.io.IOException;
import java.time.Duration; // * Add this import for Duration
import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.WebElement; // * Add this import for WebElement
import org.openqa.selenium.support.ui.ExpectedConditions; // * Add this import
import org.openqa.selenium.support.ui.WebDriverWait; // * Add this import
import org.testng.annotations.Test;

import com.Shopperstack_GenericUtility.Base_Test;
import com.Shopperstack_Pom.EditAddress_Page;
import com.Shopperstack_Pom.MyProfile_Page;
import com.Shopperstack_Pom.Myaddresses_Page;
// Assuming all necessary imports like WebDriver_Utility are handled via Base_Test

public class TC_003_verify_user_is_able_to_edit_address_or_not_Test extends Base_Test
{
    /**
     * Test case to verify if a user is able to successfully edit an existing address.
     * Assumes an address already exists from TC_001.
     */
    @Test
    public void editAddress() throws EncryptedDocumentException, IOException, InterruptedException  
    {
        // 1. Navigate to My Addresses Page
        // Click on Account Settings and My Profile
        homePage.getAccountSettingBtn().click();
        homePage.getMyprofileBtn().click();
        
        MyProfile_Page myProfilePage = new MyProfile_Page(driver);
        // Click on My Addresses button
        myProfilePage.getMyAddressesBtn().click();
        webDriverUtility.implicitWait(driver); // Use utility wait
        
        Myaddresses_Page myaddressesPage = new Myaddresses_Page(driver);
        
        // * ADD THIS LINE: Initialize WebDriverWait object
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        
        // 2. Click the Edit Button on the Address
        System.out.println("Attempting to click the Edit button on an existing address.");
        
        // * ADD THESE TWO LINES: Get the element and wait for it to be clickable
        WebElement editBtn = myaddressesPage.getEditBtn();
        wait.until(ExpectedConditions.elementToBeClickable(editBtn)); 
        
        myaddressesPage.getEditBtn().click();  // * Now the click should be successful
        webDriverUtility.implicitWait(driver); 
        
        
        // 3. Perform Edits on the Form
        EditAddress_Page editAddressPage = new EditAddress_Page(driver);
        
        System.out.println("Updating address fields with new data from Excel (Row 2).");
        
        // ... rest of the code for form interaction (clear/sendKeys) remains the same ...
        
        // Clear and update the Name field (Assuming new data is in Sheet1, Row 2, Column 0)
        editAddressPage.getNameTextFiled().clear();
        editAddressPage.getNameTextFiled().sendKeys(fileUtility.readDataFromExcelFile("Sheet1", 2, 0)); 
        
        // Clear and update the House/Office Info field (Sheet1, Row 2, Column 1)
        editAddressPage.getHouseTextFiled().clear();
        editAddressPage.getHouseTextFiled().sendKeys(fileUtility.readDataFromExcelFile("Sheet1", 2, 1)); 
        
        // Clear and update the Pincode field (Sheet1, Row 2, Column 4)
        editAddressPage.getPincodeTextFiled().clear();
        editAddressPage.getPincodeTextFiled().sendKeys(fileUtility.readDataFromExcelFile("Sheet1", 2, 4));
        
        // 4. Click the Update Button to save changes
        System.out.println("Clicking the Update button to save changes.");
        
        // * OPTIONAL: You can wait for the update button too, but we'll stick to waiting for the edit button for now
        
        editAddressPage.getUpdateAddressBtn().click();
        webDriverUtility.implicitWait(driver);
        
        // 5. Verification and Screenshot
        System.out.println("Address edit complete. Taking screenshot for verification.");
        
        webDriverUtility.getWebPageScreenShot(driver);
    }
}