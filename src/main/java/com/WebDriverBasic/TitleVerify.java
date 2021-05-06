package com.WebDriverBasic;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class TitleVerify {
    public static void main(String[] args) {
        //Implement WebDriver
        WebDriver driver; // WebDriver=Selenium Interface; driver=reference variable

        // Set browser Driver path
        System.setProperty("webdriver.gecko.driver","F:\\Training\\PeopleNTech\\BITM Batch 2\\Files\\geckodriver.exe");

        // launch Real Browser
        driver=new FirefoxDriver();

        //Open Test URL/Site
        driver.get("https://www.google.com");

        String expectedTitle="Google";
        String actualTitle=driver.getTitle();

        // Verify
        if(actualTitle.equals(expectedTitle)){
            System.out.println("Title Matched.");
        }
        else{
            System.out.println("Title not match. Actual Title is: "+actualTitle+".Expected Title is: "+expectedTitle);
        }

        driver.quit();

    }
}
