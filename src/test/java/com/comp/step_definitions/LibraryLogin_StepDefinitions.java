package com.cydeo.step_definitions;

import com.cydeo.utilities.Driver;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class LibraryLogin_StepDefinitions {
    @Given("user is on the login page of the application")
    public void user_is_on_the_login_page_of_the_application() {
        Driver.getDriver().get("https://library1.cydeo.com/login.html");
    }
    @When("user enters librarian user name")
    public void user_enters_librarian_user_name() {
        // Write code here that turns the phrase above into concrete actions
        WebElement username = Driver.getDriver().findElement(By.id("inputEmail"));
        username.sendKeys("librarian8@library");
    }
    @When("user enters librarian password")
    public void user_enters_librarian_password() {
        // Write code here that turns the phrase above into concrete actions
        WebElement password = Driver.getDriver().findElement(By.id("inputPassword"));
        password.sendKeys("FE7aFu6s");
    }
    @Then("user should see the dashboard")
    public void user_should_see_the_dashboard() {
      WebElement loginBtn = Driver.getDriver().findElement(By.xpath("//button[.='Sign in']"));
      loginBtn.click();
//      WebElement dashBoard = Driver.getDriver().findElement(By.xpath(""));
//        Assert.assertTrue(dashBoard.isDisplayed());
    }

    @When("user enters student user name")
    public void userEntersStudentUserName() {
        System.out.println("student username");
    }

    @And("user enters student password")
    public void userEntersStudentPassword() {

        System.out.println("student pass");
    }

    @When("user enters admin user name")
    public void user_enters_admin_user_name() {
        System.out.println("stadmin username");
    }
    @When("user enters admin password")
    public void user_enters_admin_password() {
        System.out.println("admin pass");
    }
}
