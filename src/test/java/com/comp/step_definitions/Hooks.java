package com.cydeo.step_definitions;

import com.cydeo.utilities.Driver;
import io.cucumber.java.*;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

/*
in this class we will be able to create pre and post condition for all the scenarios and even steps
 */
public class Hooks {
    //import the before coming from io.cucumber
   // @Before(order=1)
    public void setUp(){
        System.out.println("---> @Before: running before each scenario");
    }

    /*
    Will be executed automatically after every scenario in the project
     */
    @After
    public void tearDown(Scenario scenario){

        //I want to take a screenshot if only my scenario is failing
        if (scenario.isFailed()) {
            byte[] screenShot = ((TakesScreenshot) Driver.getDriver()).getScreenshotAs(OutputType.BYTES);
            scenario.attach(screenShot, "image/png", scenario.getName());
        }
        //System.out.println("---> @After: running after each scenario");
        //Driver.closeDriver();
    }

   // @BeforeStep
    public void setupStep(){
        System.out.println("-----> @BeforeStep: running before each step");
    }

    //@AfterStep
    public void teardownStep(){
        System.out.println("-----> @AfterStep: running after each step");
    }
}
