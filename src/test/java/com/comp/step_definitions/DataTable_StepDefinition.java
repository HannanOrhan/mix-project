package com.cydeo.step_definitions;

import com.cydeo.pages.PracticeCydeoDropdownPage;
import com.cydeo.utilities.BrowserUtils;
import com.cydeo.utilities.Driver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class DataTable_StepDefinition {
    @Then("user should see below list")
    public void user_should_see_below_list(List<String> fruitsAndVegetables) {
        System.out.println("fruitsAndVegetables = " + fruitsAndVegetables);
        System.out.println("fruitsAndVegetables.get(1) = " + fruitsAndVegetables.get(1));
    }
    @Then("user should see below pet list")
    public void user_should_see_below_pet_list(List<String> pets) {
        System.out.println("pets = " + pets);
        int i=0;
        for (String pet : pets) {
            System.out.println("pet"+(i++)+ " = " + pet);
        }
    }

    @Then("officer is able to see any data he wants")
    public void officer_is_able_to_see_any_data_he_wants(Map<String,String> driverInfo ) {
        System.out.println("driverInfo = " + driverInfo);
        for (Map.Entry<String, String> each : driverInfo.entrySet()) {
            System.out.println("each.getKey() = " + each.getKey() +" : " + "each.getValue() = " + each.getValue());
        }
    }

    @Given("User is on the dropdowns page of practice tool")
    public void user_is_on_the_dropdowns_page_of_practice_tool() {
        Driver.getDriver().get("https://practice.cydeo.com/dropdown");
    }

    PracticeCydeoDropdownPage practiceCydeoDropdownPage = new PracticeCydeoDropdownPage();
    @Then("User should see below info in month dropdown")
    public void user_should_see_below_info_in_month_dropdown(List<String> listOfMonth) {
        //first way
        List<String> list_of_actual_months = practiceCydeoDropdownPage.getDropdownOptions();
        System.out.println("list_of_actual_months = " + list_of_actual_months);

        Assert.assertEquals(listOfMonth,list_of_actual_months);
        //second way
        List<String> list_actual = BrowserUtils.getSelectDropdownOptions(practiceCydeoDropdownPage.monthDropdown);

        Assert.assertEquals(listOfMonth,list_actual);
    }
}
