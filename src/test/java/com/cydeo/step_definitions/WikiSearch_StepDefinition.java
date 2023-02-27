package com.cydeo.step_definitions;

import com.cydeo.pages.WikiPage;
import com.cydeo.pages.WikiResultPage;
import com.cydeo.utilities.ConfigurationReader;
import com.cydeo.utilities.Driver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.Keys;

public class WikiSearch_StepDefinition {

    WikiPage wikiPage= new WikiPage();
    WikiResultPage wikiResultPage = new WikiResultPage();
    @Given("User is on Wikipedia home page")
    public void user_is_on_wikipedia_home_page() {
        Driver.getDriver().get(ConfigurationReader.getProperty("wikiURL"));
    }

    @When("User types {string} in the wiki search box")
    public void userTypesInTheWikiSearchBox(String searchValue) {
        wikiPage.searchBox.sendKeys(searchValue);
    }
    @When("User clicks wiki search button")
    public void user_clicks_wiki_search_button() {
        wikiPage.searchBox.sendKeys(Keys.ENTER);
    }

    @Then("User sees {string} is in the wiki title")
    public void userSeesIsInTheWikiTitle(String expectedTitle) {
        Assert.assertTrue(Driver.getDriver().getTitle().contains(expectedTitle));
    }

    @Then("User sees {string} is in the main header")
    public void userSeesIsInTheMainHeader(String expectedHeader) {
        Assert.assertEquals(wikiResultPage.main_headerText.getText(),expectedHeader);
    }

    @Then("User sees {string} is in the image header")
    public void userSeesIsInTheImageHeader(String expectedImgHeader) {
        Assert.assertEquals(wikiResultPage.imageHeader.getText(),expectedImgHeader);
    }
}
