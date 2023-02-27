package com.cydeo.utilities;

import com.cydeo.pages.PracticeCydeoDropdownPage;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class BrowserUtils {
    /*
TC #2: Create utility method
1. Create a new class called BrowserUtils
2. Create a method to make Task1 logic re-usable
3. When method is called, it should switch window and verify title.
Method info:
• Name: switchWindowAndVerify
• Return type: void
• Arg1: WebDriver
• Arg2: String expectedInUrl
• Arg3: String expectedTitle
  */
    public static void switchWindowAndVerify(String expectedInUrl, String expectedTitle){

        Set<String> allWindowHandles = Driver.getDriver().getWindowHandles();

        for (String each : allWindowHandles){
            Driver.getDriver().switchTo().window(each);
            System.out.println("currentTitle : " + Driver.getDriver().getTitle());
            if (Driver.getDriver().getTitle().contains(expectedTitle)){
                break;
            }
        }
        BrowserUtils.verifyTitleContains(expectedTitle);
    }

    public static void verifyTitle(String expectedTitle){
        //TC #3: Create utility method
        // 1. Create a new method for title verification
        // 2. Create a method to make title verification logic re-usable
        //3. When method is called, it should simply verify expected title with actual title
        //Method info:
        //• Name: verifyTitle()
        // • Return type: void
        // • Arg1: WebDriver
        // • Arg2: String expectedTitle
        Assert.assertEquals(Driver.getDriver().getTitle(),expectedTitle);
    }

    public static void verifyTitleContains(String expectedTitle){
        //TC #3: Create utility method
        // 1. Create a new method for title verification
        // 2. Create a method to make title verification logic re-usable
        //3. When method is called, it should simply verify expected title with actual title
        //Method info:
        //• Name: verifyTitle()
        // • Return type: void
        // • Arg1: WebDriver
        // • Arg2: String expectedTitle
        Assert.assertTrue(Driver.getDriver().getTitle().contains(expectedTitle));
        waitForTitleContains(expectedTitle);
    }


    public static void sleep(int second){
        second *= 1000;
        try {
            Thread.sleep(second);
        }catch (InterruptedException e){

        }
    }
    /*
    this method accepts webElement target and wait for that web element to not be displayed on the page
     */
    public static void waitForInvisibilityOfGivenElement(WebElement target){
        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(5));
        wait.until(ExpectedConditions.invisibilityOf(target));
    }
    /*
this method accepts String target and wait for that title to contained */
    public static void waitForTitleContains(String title){
        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(5));
        wait.until(ExpectedConditions.titleIs(title));
    }

    public static List<String> getSelectDropdownOptions(WebElement dropdown){
            Select dropdown_obj = new Select(dropdown);
            List<WebElement> webElements = dropdown_obj.getOptions();
            List<String> list_of_actual_result = new ArrayList<>();

            for (WebElement eachElement : webElements) {
                list_of_actual_result.add(eachElement.getText());
            }
            return list_of_actual_result;
    }

    public static void titleVerificationIgnoreCase(String expectedTitle){
        Assert.assertTrue(Driver.getDriver().getTitle().toUpperCase().contains(expectedTitle.toUpperCase()));
    }
    public static void urlVerification(String expectedURL){
        Assert.assertTrue(Driver.getDriver().getCurrentUrl().contains(expectedURL));
    }
    public static void loginFunction(WebElement username, WebElement password,WebElement loginBtn){
        username.sendKeys(ConfigurationReader.getProperty("username"));
        password.sendKeys(ConfigurationReader.getProperty("password"));
        loginBtn.click();
    }

    public static void clickRadioBtn(List<WebElement> radioButtons, String attributeValue){
        for (WebElement radioButton : radioButtons) {
            if (radioButton.getAttribute("value").equals(attributeValue)){
                radioButton.click();
            }
        }
    }
}
