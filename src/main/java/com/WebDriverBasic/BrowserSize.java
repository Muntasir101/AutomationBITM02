package com.WebDriverBasic;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class BrowserSize {
    public static void main(String[] args) {
        //Implement WebDriver
        WebDriver driver; // WebDriver=Selenium Interface; driver=reference variable

        // Set browser Driver path
        System.setProperty("webdriver.gecko.driver","F:\\Training\\PeopleNTech\\BITM Batch 2\\Files\\geckodriver.exe");

        // launch Real Browser
        driver=new FirefoxDriver();

        //Open Test URL/Site
        driver.get("https://www.google.com");

        //Get Browser size
        Dimension browserSize= driver.manage().window().getSize(); //(1382, 744)
        System.out.println("Maximum Browser Size: "+browserSize);

        //Set Browser Size
        driver.manage().window().setSize(new Dimension(800,400));

        //Verify Set Size
        Dimension customBrowserSize= driver.manage().window().getSize();
        System.out.println("Custom Browser Size: "+customBrowserSize);

       // driver.quit();
    }
}
