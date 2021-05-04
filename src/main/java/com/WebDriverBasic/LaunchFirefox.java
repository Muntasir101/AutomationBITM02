package com.WebDriverBasic;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

// launch Browser
public class LaunchFirefox {
    public static void main(String[] args) {

        //Implement WebDriver
        WebDriver driver; // WebDriver=Selenium Interface; driver=reference variable

        // Set browser Driver path
        System.setProperty("webdriver.gecko.driver","F:\\Training\\PeopleNTech\\BITM Batch 2\\Files\\geckodriver.exe");

        // launch Real Browser
        driver=new FirefoxDriver();
    }
}
