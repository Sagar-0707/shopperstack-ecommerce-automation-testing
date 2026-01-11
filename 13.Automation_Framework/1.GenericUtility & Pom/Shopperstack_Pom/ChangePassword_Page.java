package com.Shopperstack_Pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ChangePassword_Page {

    WebDriver driver;

    public ChangePassword_Page(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    // Assuming the user navigates from MyProfile to the Change Password section
    
    // Locator for the Current Password text field
    @FindBy(xpath = "//input[@id='Current Password' or @name='currentPassword']")
    private WebElement currentPasswordTextField;
    
    // Locator for the New Password text field
    @FindBy(xpath = "//input[@id='New Password' or @name='newPassword']")
    private WebElement newPasswordTextField;

    // Locator for the Confirm New Password text field
    @FindBy(xpath = "//input[@id='Confirm New Password' or @name='confirmNewPassword']")
    private WebElement confirmNewPasswordTextField;

    // Locator for the Save/Update button
    @FindBy(xpath = "//button[text()='Save' or text()='Update']")
    private WebElement saveButton;
    
    // Locator for a success message after password change
    @FindBy(xpath = "//div[contains(text(),'Password updated successfully')]")
    private WebElement successMessage;

    // Getter methods
    public WebElement getCurrentPasswordTextField() {
        return currentPasswordTextField;
    }

    public WebElement getNewPasswordTextField() {
        return newPasswordTextField;
    }

    public WebElement getConfirmNewPasswordTextField() {
        return confirmNewPasswordTextField;
    }

    public WebElement getSaveButton() {
        return saveButton;
    }
    
    public WebElement getSuccessMessage() {
        return successMessage;
    }
}