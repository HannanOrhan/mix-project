package com.cydeo.step_definitions;

import com.cydeo.pages.CydeoLoginPage;
import com.cydeo.pages.OrderPage;
import com.cydeo.pages.ViewAllOrderPage;
import com.cydeo.utilities.BrowserUtils;
import com.cydeo.utilities.ConfigurationReader;
import com.cydeo.utilities.Driver;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

import java.util.List;
import java.util.Map;

public class CydeoLogin_StepDefinition {
    CydeoLoginPage cydeoLoginPage = new CydeoLoginPage();
    OrderPage orderPage = new OrderPage();

    ViewAllOrderPage viewAllOrderPage = new ViewAllOrderPage();
    @Given("user is on the Web Table login page")
    public void user_is_on_the_web_table_login_page() {
        Driver.getDriver().get(ConfigurationReader.getProperty("cydeoLoginURL"));
    }
    @When("user enters correct username")
    public void user_enters_correct_username() {
        cydeoLoginPage.username.sendKeys("Test");
    }
    @When("user enters correct password")
    public void user_enters_correct_password() {
        cydeoLoginPage.password.sendKeys("Tester");
    }
    @When("user clicks login button")
    public void user_clicks_login_button() {
        cydeoLoginPage.loginBtn.click();
    }
    @Then("user should see URL ends with orders word")
    public void user_should_see_url_ends_with_orders_word() {
        BrowserUtils.urlVerification("orders");
    }
    @When("user enters username as {string} and  password as {string}")
    public void userEntersUsernameAsAndPasswordAs(String username, String password) {
        username = ConfigurationReader.getProperty("cydeoUsername");
        cydeoLoginPage.username.sendKeys(username);
        password = ConfigurationReader.getProperty("cydeoPassword");
        cydeoLoginPage.password.sendKeys(password);
    }

    @When("user enters below correct credentials")
    public void userEntersBelowCorrectCredentials(Map<String,String> credentials) {
        cydeoLoginPage.username.sendKeys(credentials.get("username"));
        cydeoLoginPage.password.sendKeys(credentials.get("password"));
    }

    @Given("user is already logged in to the Web Table app")
    public void user_is_already_logged_in_to_the_web_table_app() {
        cydeoLoginPage.login();
    }
    @When("user is on the Order page")
    public void user_is_on_the_order_page() {
        cydeoLoginPage.orderBtn.click();
    }
   @Then("user sees below options under product dropdown")
    public void user_sees_below_options_under_product_dropdown(List<String> expectedList) {
        List<String> actualProducts = orderPage.getProductOptions();
        System.out.println("actualProducts = " + actualProducts);
        System.out.println("expectedList = " + expectedList);
        Assert.assertTrue(expectedList.equals(actualProducts));
    }

  /*  @Then("Then user sees below radio buttons enabled for")
    public void thenUserSeesBelowRadioButtonsEnabledFor(List<String> checkBoxes) {
        Assert.assertEquals(checkBoxes,orderPage.getRadioBtnOptions());
    }

   */

    @Then("user sees Visa radio buttons enabled for")
    public void userSeesVisaRadioButtonsEnabledFor() {
        Assert.assertTrue(orderPage.visaRadioBtn.isEnabled());
    }

    @Then("user sees Mastercard radio buttons enabled for")
    public void userSeesMastercardRadioButtonsEnabledFor() {
        Assert.assertTrue(orderPage.masterCardRadioBtn.isEnabled());
    }

    @Then("user sees American Express radio buttons enabled for")
    public void userSeesAmericanExpressRadioButtonsEnabledFor() {
        Assert.assertTrue(orderPage.americanExpressRadioBtn.isEnabled());
    }

    @And("user enters Quantity {string}")
    public void userEntersQuantity(String quantity) {
        orderPage.productQuantity.clear();
        BrowserUtils.sleep(2);
        orderPage.productQuantity.sendKeys(quantity);
    }

    @Then("user clicks calculate btn")
    public void userClicksCalculateBtn() {
        orderPage.calculateBtn.click();
        BrowserUtils.sleep(2);
    }

    @And("user enters Customer name {string}")
    public void userEntersCustomerName(String name) {
        orderPage.name.sendKeys(name);
    }

    @And("user enters Street {string}")
    public void userEntersStreet(String street) {
        orderPage.street.sendKeys(street);
    }

    @And("user enters City {string}")
    public void userEntersCity(String city) {
        orderPage.city.sendKeys(city);
    }

    @And("user enters State {string}")
    public void userEntersState(String state) {
        orderPage.state.sendKeys(state);
    }

    @And("user enters Zip {string}")
    public void userEntersZip(String zip) {
        orderPage.zip.sendKeys(zip);
    }

    @And("user select payment option {string}")
    public void userSelectPaymentOption(String expectedCardType) {
        BrowserUtils.clickRadioBtn(orderPage.cardTypes,expectedCardType);
    }

    @And("user enters Card No {string}")
    public void userEntersCardNo(String cardNo) {
        orderPage.cardNo.sendKeys(cardNo);
    }

    @And("user enters Expire date {string}")
    public void userEntersExpireDate(String cardExp) {
        orderPage.cardExp.sendKeys(cardExp);
    }

    @And("user clicks to “Process Order”")
    public void userClicksToProcessOrder() {
        orderPage.processBtn.click();
    }

    @Then("user should see {string}  in the first row of the table on View all orders page")
    public void userShouldSeeInTheFirstRowOfTheTableOnViewAllOrdersPage(String name) {
        orderPage.viewAllOrderBtn.click();
        Assert.assertEquals(name,viewAllOrderPage.lastOrderNameInTable.getText());
    }
}
