package com.cydeo.pages;

import com.cydeo.utilities.ConfigurationReader;
import com.cydeo.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CydeoLoginPage {
    public CydeoLoginPage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }
    @FindBy(name = "username")
    public WebElement username;
    @FindBy(name = "password")
    public WebElement password;
    @FindBy(xpath = "//button[.='Login']")
    public WebElement loginBtn;

    @FindBy(xpath = "//button[text()='Order']")
    public WebElement orderBtn;
    @FindBy(xpath = "//button[text()='View all orders']")
    public WebElement viewAllOrdersBtn;
    @FindBy(xpath = "//button[text()='View all products']")
    public WebElement viewAllProductsBtn;

    public void login(){
        this.username.sendKeys(ConfigurationReader.getProperty("cydeoUsername"));
        this.password.sendKeys(ConfigurationReader.getProperty("cydeoPassword"));
        this.loginBtn.click();
    }

}
