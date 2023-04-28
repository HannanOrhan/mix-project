package com.comp.pages;

import com.comp.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class NetlifyPage {
    public NetlifyPage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }

    @FindBy(xpath = "//li[contains(@class,'PaginationInd')]")
    public List<WebElement> paginationOpts;

    public void clickPaginationOption(String action){
        if (action.equalsIgnoreCase("forward")){
            paginationOpts.get(paginationOpts.size()-2).click();
        } else if (action.equalsIgnoreCase("back")) {
            paginationOpts.get(1).click();
        }
    }

}
