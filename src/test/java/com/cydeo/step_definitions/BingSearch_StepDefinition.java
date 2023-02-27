package com.cydeo.step_definitions;

import com.cydeo.pages.BingSearchPage;
import com.cydeo.utilities.BrowserUtils;
import com.cydeo.utilities.ConfigurationReader;
import com.cydeo.utilities.Driver;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.Keys;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class BingSearch_StepDefinition {
    BingSearchPage bingSearchPage = new BingSearchPage();

    WebDriverWait wait = new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(2));
    @When("user is on the Bing search page")
    public void user_is_on_the_bing_search_page() {
        Driver.getDriver().get(ConfigurationReader.getProperty("bingURL"));
    }
    @Then("user should see title is Bing")
    public void user_should_see_title_is_bing() {
        BrowserUtils.verifyTitleContains("Bing");
    }

    @When("user searches for orange")
    public void user_searches_for_orange() {
       bingSearchPage.searchFunction("orange");
    }
    @Then("user should see orange in the title")
    public void user_should_see_orange_in_the_title() {
        wait.until(ExpectedConditions.titleContains("orange"));
        Assert.assertTrue(Driver.getDriver().getTitle().contains("orange"));
    }

    @When("user searches for {string}")
    public void userSearchesFor(String searchText) {
        bingSearchPage.searchFunction(searchText);
    }

    @Then("user should see {string} in the title")
    public void userShouldSeeInTheTitle(String expectedTitle) {
        wait.until(ExpectedConditions.titleContains(expectedTitle));
        Assert.assertTrue(Driver.getDriver().getTitle().contains(expectedTitle));
    }
}
