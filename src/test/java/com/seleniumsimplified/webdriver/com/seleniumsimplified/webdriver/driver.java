package com.seleniumsimplified.webdriver.com.seleniumsimplified.webdriver;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

/**
 * Created by juspack on 31/08/16.
 */
public class driver {


    //private WebDriver driver;
    private static String marionetteLocation = "C:\\Users\\jakobda\\Downloads\\geckodriver.exe";
    public static WebDriver driver;

    public driver(WebDriver aDriver) {
        driver = aDriver;
    }

    public void get(){
        System.setProperty("webdriver.gecko.driver", marionetteLocation);

        //The folowing is for gecko 0.9.0
        DesiredCapabilities capabilities = DesiredCapabilities.firefox();
        capabilities.setCapability("marionette", true);
        driver = new FirefoxDriver(capabilities);
        driver.get("http://compendiumdev.co.uk");
    }


    public void quit(){
        driver.quit();
    }
}
