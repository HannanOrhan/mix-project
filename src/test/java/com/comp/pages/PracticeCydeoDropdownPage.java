package com.cydeo.pages;

import com.cydeo.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import java.util.ArrayList;
import java.util.List;

public class PracticeCydeoDropdownPage {
    public PracticeCydeoDropdownPage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }
    @FindBy(xpath = "//select[@id='month']")
    public WebElement monthDropdown;

    public List<String> getDropdownOptions(){
        Select months = new Select(monthDropdown);
        List<WebElement> webElements_months = months.getOptions();
        List<String> list_of_actual_months = new ArrayList<>();

        for (WebElement eachElement : webElements_months) {
            list_of_actual_months.add(eachElement.getText());
        }

        return list_of_actual_months;
    }
}
