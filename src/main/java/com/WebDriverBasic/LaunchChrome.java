package com.WebDriverBasic;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

// launch Browser
public class LaunchChrome {
    public static void main(String[] args) {

        //Implement WebDriver
        WebDriver driver; // WebDriver=Selenium Interface; driver=reference variable

        // Set browser Driver path
        System.setProperty("webdriver.chrome.driver","F:\\Training\\PeopleNTech\\BITM Batch 2\\Files\\chromedriver.exe");

        // launch Real Browser
        driver=new ChromeDriver();
    }
}
