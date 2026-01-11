package com.Shoppersstack_TestScripts;

import java.io.IOException;
import java.time.Duration;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.Shopperstack_GenericUtility.Base_Test;
import com.Shopperstack_GenericUtility.Java_Utility;
import com.Shopperstack_Pom.ChangePassword_Page;
import com.Shopperstack_Pom.MyProfile_Page;
import com.Shopperstack_Pom.Login_page; // Necessary for re-login

public class TC_007_Verify_Password_Change_And_Login_With_New_Password extends Base_Test {

    @Test
    public void changePasswordAndVerifyLogin() throws EncryptedDocumentException, IOException, InterruptedException {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        
        // Credentials must be read from property file or Excel (using File_Utility)
        String oldPassword = fileUtility.readDataFromPropertyFile("password"); 
        String email = fileUtility.readDataFromPropertyFile("email");
        
        // Generate a new, unique password for the test
        String newPassword = "NewPass" + Java_Utility.generateRandomNumber(); 
        
        System.out.println("Starting TC_007: Password Change and Login Verification.");

        // --- 1. NAVIGATE TO CHANGE PASSWORD PAGE ---
        
        // Assuming MyProfilePage has a getChangePasswordLink() method
        
        MyProfile_Page.getChangePasswordLink().click(); 
        webDriverUtility.implicitWait(driver);
        
        // --- 2. CHANGE PASSWORD ---
        ChangePassword_Page changePassPage = new ChangePassword_Page(driver);
        wait.until(ExpectedConditions.visibilityOf(changePassPage.getCurrentPasswordTextField()));
        
        changePassPage.getCurrentPasswordTextField().sendKeys(oldPassword);
        changePassPage.getNewPasswordTextField().sendKeys(newPassword);
        changePassPage.getConfirmNewPasswordTextField().sendKeys(newPassword);
        
        changePassPage.getSaveButton().click();
        
        // Verification 1: Check for success message
        wait.until(ExpectedConditions.visibilityOf(changePassPage.getSuccessMessage()));
        Assert.assertTrue(changePassPage.getSuccessMessage().isDisplayed(), "Password change failed: Success message not displayed.");
        System.out.println("Password successfully changed to: " + newPassword);


        // --- 3. LOGOUT AND RE-LOGIN WITH NEW PASSWORD ---
        
        // Assuming Home_page has a method to perform a clean logout
        homePage.logout(); // Implement a robust logout method in Home_page.java

        Login_page loginPage = new Login_page(driver); // Assuming Login_page exists
        
        // Attempt login with the new password
        loginPage.getEmailTextField().sendKeys(email);
        loginPage.getPasswordtextfield().sendKeys(newPassword);
        loginPage.getLoginBtn().click();
        
        // Verification 2: Check if the user is successfully logged in (e.g., Home Page is visible)
        wait.until(ExpectedConditions.visibilityOf(homePage.getSearchTextField())); 
        Assert.assertTrue(homePage.getSearchTextField().isDisplayed(), "Verification Failed: Login with new password failed.");
        System.out.println("Login with new password successful. Test Passed.");
        
        webDriverUtility.getWebPageScreenShot(driver);
        
       
    }
}