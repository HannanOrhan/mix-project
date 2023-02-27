package com.cydeo.step_definitions;

import com.cydeo.pages.EtsySearchPage;
import com.cydeo.utilities.BrowserUtils;
import com.cydeo.utilities.ConfigurationReader;
import com.cydeo.utilities.Driver;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.checkerframework.checker.units.qual.K;
import org.junit.Assert;
import org.openqa.selenium.Keys;

public class EtsySearch_StepDefinition {
    EtsySearchPage etsySearchPage = new EtsySearchPage();
    @Given("User is on the etsy homepage")
    public void userIsOnTheEtsyHomepage() {
        Driver.getDriver().get(ConfigurationReader.getProperty("etsyURL"));
    }
    @Then("User should see title is as expected")
    public void user_should_see_title_is_as_expected() {
        Assert.assertTrue(Driver.getDriver().getTitle().contains(ConfigurationReader.getProperty("etsyHomePageTitle")));
    }


    @When("User types Wooden Spoon in the search box")
    public void userTypesWoodenSpoonInTheSearchBox() {
        etsySearchPage.searchBox.sendKeys("Wooden Spoon");
    }

    @And("User clicks search button")
    public void userClicksSearchButton() {
        etsySearchPage.searchBox.sendKeys(Keys.ENTER);
    }

    @Then("sees Wooden Spoon is in the title")
    public void seesWoodenSpoonIsInTheTitle() {
        Assert.assertTrue(Driver.getDriver().getTitle().contains("Wooden spoon"));
    }

    @When("User types {string} in the search box")
    public void userTypesInTheSearchBox(String searchWord) {
        etsySearchPage.searchBox.sendKeys(searchWord);
    }

    @Then("User sees {string} is in the title")
    public void userSeesIsInTheTitle(String expectedTitle) {
        BrowserUtils.titleVerificationIgnoreCase(expectedTitle);
    }
}
