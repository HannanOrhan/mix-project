package com.cydeo.step_definitions;

import com.cydeo.pages.GoogleSearchPage;
import com.cydeo.utilities.BrowserUtils;
import com.cydeo.utilities.ConfigurationReader;
import com.cydeo.utilities.Driver;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class GoogleSearch_StepDefinition {

    GoogleSearchPage googleSearchPage = new GoogleSearchPage();
    @When("user is on the Google search page")
    public void user_is_on_the_google_search_page() {
        Driver.getDriver().get(ConfigurationReader.getProperty("googleURL"));
    }
    @Then("user should see title is Google")
    public void user_should_see_title_is_google() {
        Assert.assertTrue("Google title verification is failed!",Driver.getDriver().getTitle().contains("Google"));
    }
    @When("user searches for apple")
    public void user_searches_for_apple() {
        googleSearchPage.searchFunction("apple");
    }
    @Then("user should see apple in the title")
    public void user_should_see_apple_in_the_title() {
        BrowserUtils.verifyTitleContains("apple");
    }

    @When("user searches for {string} key")
    public void user_searches_for_key(String string) {
        string = ConfigurationReader.getProperty("keyword");
        googleSearchPage.searchFunction(string);
    }
    @Then("user should see {string} key in the title")
    public void user_should_see_key_in_the_title(String string) {
        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(2));
        string = ConfigurationReader.getProperty("keyword");
        wait.until(ExpectedConditions.titleContains(string));
        Assert.assertTrue(Driver.getDriver().getTitle().contains(string));
    }
}
