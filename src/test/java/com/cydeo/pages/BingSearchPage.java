package com.cydeo.pages;

import com.cydeo.utilities.BrowserUtils;
import com.cydeo.utilities.Driver;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class BingSearchPage {
    public BingSearchPage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }
    @FindBy(xpath = "//textarea[@name='q']")
    public WebElement searchBox;

    public void searchFunction(String searchWord){
        searchBox.sendKeys(searchWord);
        BrowserUtils.sleep(2);
        searchBox.sendKeys(Keys.ENTER);
    }
}
