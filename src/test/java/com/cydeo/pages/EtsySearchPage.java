package com.cydeo.pages;

import com.cydeo.utilities.ConfigurationReader;
import com.cydeo.utilities.Driver;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class EtsySearchPage {
    public EtsySearchPage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }
    @FindBy(xpath = "//input[@name='search_query']")
    public WebElement searchBox;

    public void searchFunctionality(String searchValue){
        searchBox.sendKeys(searchValue);
        searchBox.sendKeys(Keys.ENTER);
    }

}
