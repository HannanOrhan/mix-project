package com.cydeo.pages;

import com.cydeo.utilities.ConfigurationReader;
import com.cydeo.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class TryCloudLoginPage {
    public TryCloudLoginPage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }
    @FindBy(id = "user")
    public WebElement userName;
    @FindBy(id = "password")
    public WebElement password;
    @FindBy(xpath = "//input[@id='submit-form']")
    public WebElement loginBtn;

    public void login_trycloud(){
        userName.sendKeys(ConfigurationReader.getProperty("tryCloud_username"));
        password.sendKeys(ConfigurationReader.getProperty("tryCloud_password"));
        loginBtn.click();
    }
}
