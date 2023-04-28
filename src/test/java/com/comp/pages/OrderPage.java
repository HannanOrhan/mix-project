package com.cydeo.pages;

import com.cydeo.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import java.util.ArrayList;
import java.util.List;

public class OrderPage extends CydeoLoginPage{
    public OrderPage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }
    @FindBy(xpath = "//select[@name='product']")
    public WebElement productDropdown;

    @FindBy(xpath = "(//div[@class='control']/label/input)[1]")
    public WebElement visaRadioBtn;

    @FindBy(xpath = "(//div[@class='control']/label/input)[2]")
    public WebElement masterCardRadioBtn;

    @FindBy(xpath = "(//div[@class='control']/label/input)[3]")
    public WebElement americanExpressRadioBtn;

    @FindBy(xpath = "//input[@type='number']")
    public WebElement productQuantity;

    @FindBy(xpath = "//input[@name='name']")
    public WebElement name;
    @FindBy(xpath = "//input[@name='street']")
    public WebElement street;
    @FindBy(xpath = "//input[@name='city']")
    public WebElement city;
    @FindBy(xpath = "//input[@name='state']")
    public WebElement state;
    @FindBy(xpath = "//input[@name='zip']")
    public WebElement zip;
    @FindBy(xpath = "//input[@name='cardNo']")
    public WebElement cardNo;
    @FindBy(xpath = "//input[@name='cardExp']")
    public WebElement cardExp;
    @FindBy(xpath = "//button[.='Calculate']")
    public WebElement calculateBtn;
    @FindBy(xpath = "//button[.='Process Order']")
    public WebElement processBtn;
    @FindBy(xpath = "//button[.='View all orders']")
    public WebElement viewAllOrderBtn;

    @FindBy(name = "card")
    public List<WebElement> cardTypes;

    public List<String> getProductOptions(){
        Select productDD = new Select(productDropdown);
        List<WebElement> products = productDD.getOptions();
        List<String> actualProducts = new ArrayList<>();
        for (WebElement product : products) {
            actualProducts.add(product.getText());
        }
        return actualProducts;
    }
}
