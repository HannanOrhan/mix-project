package com.comp.step_definitions;

import com.comp.pages.NetlifyPage;
import com.comp.utilities.BrowserUtils;
import com.comp.utilities.Driver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class NetlifyApp {
    //https://qa-recruitment-task.netlify.app/
    NetlifyPage netlifyPage = new NetlifyPage();
    @Given("user on the netlifyApp")
    public void user_on_the_netlify_app() {
        Driver.getDriver().get("https://qa-recruitment-task.netlify.app/");
    }
    @When("user click on the next can go to the last page")
    public void user_click_on_the_next_can_go_to_the_last_page() {
        BrowserUtils.sleep(2);
        netlifyPage.clickPaginationOption("forward");
        WebElement header = Driver.getDriver().findElement(By.xpath("//a[text()='Photography']"));
        Assert.assertEquals("Photography",header.getText());
    }
    @Then("user return back to the first page")
    public void user_return_back_to_the_first_page() {
        BrowserUtils.sleep(2);
        netlifyPage.clickPaginationOption("back");
        WebElement header = Driver.getDriver().findElement(By.xpath("//h1[text()='Samurai King Resting']"));
        Assert.assertEquals("Samurai King Resting",header.getText());
    }

}
