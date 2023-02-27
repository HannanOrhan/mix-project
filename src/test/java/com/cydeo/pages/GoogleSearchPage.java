package com.cydeo.pages;

import com.cydeo.utilities.Driver;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class GoogleSearchPage {
    //create const and initialize driver
    public GoogleSearchPage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }
    @FindBy(xpath = "//input[@name='q']")
    public WebElement searchBox;

    public void searchFunction(String searchWord){
        searchBox.sendKeys(searchWord + Keys.ENTER);
    }
}
