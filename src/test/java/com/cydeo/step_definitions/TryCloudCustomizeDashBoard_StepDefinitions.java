package com.cydeo.step_definitions;

import com.cydeo.pages.TryCloudLoginPage;
import com.cydeo.utilities.BrowserUtils;
import com.cydeo.utilities.Driver;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;

import java.util.List;

public class TryCloudCustomizeDashBoard_StepDefinitions {
    TryCloudLoginPage tryCloudLoginPage=new TryCloudLoginPage();
    @Given("user on the login page and enter valid credentials")
    public void user_on_the_login_page_and_enter_valid_credentials() {
        Driver.getDriver().get("https://qa.trycloud.net/");
        tryCloudLoginPage.login_trycloud();
    }
    @When("user on the home page")
    public void user_on_the_home_page() {
        Assert.assertTrue(Driver.getDriver().getTitle().contains("Dashboard"));
    }

    @When("user should be click on the “customize” button")
    public void user_should_be_click_on_the_customize_button() {
        BrowserUtils.sleep(3);
        Driver.getDriver().findElement(By.xpath("//a[.='Customize']")).click();
    }
    @Then("verify you see the nine clickable widgets")
    public void verify_you_see_the_nine_clickable_widgets() {
        List<WebElement> list = Driver.getDriver().findElements(By.xpath("//div[@class='modal__content']/ol/li/label"));
        for (WebElement webElement : list) {
            Assert.assertTrue(webElement.isDisplayed());
        }
        BrowserUtils.sleep(3);
        Driver.closeDriver();
    }

    @Then("verify user can click the nine clickable widgets")
    public void verifyUserCanClickTheNineClickableWidgets() {
        //JavascriptExecutor js = (JavascriptExecutor) Driver.getDriver();
        List<WebElement> list = Driver.getDriver().findElements(By.xpath("//div[@class='modal__content']/ol/li/label"));

        for (WebElement webElement : list) {
                webElement.click();
            BrowserUtils.sleep(2);
        }
    }
}
