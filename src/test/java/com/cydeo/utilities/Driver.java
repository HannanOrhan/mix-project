package com.cydeo.utilities;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.PageFactory;

import java.time.Duration;

public class Driver {
    //create a private constructor to remove access to this object
    private Driver(){
 /*
        We make the WebDriver private because we want to close access from outside the class
        We are making it static, because we will use it in a static  method
         */
    }
    //private static WebDriver driver; //instead of this we need driver pool for parallel testing
    private static InheritableThreadLocal<WebDriver> driverPool = new InheritableThreadLocal<>();
       /*
    create reusable utility method which will return the same driver instance once we call it
    If an instance doesn't exist
     */
    public static WebDriver getDriver(){//singleton logic
        if (driverPool.get()==null){
            /*
            we will read our browser type from configuration.properties file
            this way we can control which browser opened from outside our coded

            switch statement will determine the case and open the matching browser
             */
            String browserType = ConfigurationReader.getProperty("browser");
            switch (browserType){
                case "chrome":
                    driverPool.set(new ChromeDriver());
                    break;
                case "firefox":
                    driverPool.set(new FirefoxDriver());
                    break;
                case "edge":
                    driverPool.set(new EdgeDriver());
                    break;
                default:
                    System.err.println("This browser does not exist!!");
            }

            driverPool.get().manage().window().maximize();
            driverPool.get().manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        }
        return driverPool.get();
    }
     /*
   Create Driver.closeDriver(); it will use .quit() method to quit browsers ,and then set the driver value back
    */
    public static void closeDriver(){
        if (driverPool.get()!=null){
            //terminate the currently existing driver
            driverPool.get().quit();
            driverPool.remove(); //this will remove existing driver and sett driver as a null like assigning null
        }
    }
}
