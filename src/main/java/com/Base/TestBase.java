package com.Base;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public class TestBase {
    public static WebDriver driver;

    public static void chromeLaunch(){
        System.setProperty("webdriver.chrome.driver",System.getProperty("user.dir")+"//src//main//resources//chromedriver.exe");
        driver=new ChromeDriver();
        driver.manage().window().maximize();
    }

    public static void firefoxLaunch(){
        System.setProperty("webdriver.gecko.driver",System.getProperty("user.dir")+"//src//main//resources//geckodriver.exe");
        driver=new FirefoxDriver();
        driver.manage().window().maximize();
    }

    public static void openTestSite(String URL){
        driver.get(URL);
    }

    public static void implicitWait(int Second){
        driver.manage().timeouts().implicitlyWait(Second, TimeUnit.SECONDS);
    }

    public static void explicitWait(int Second){
        WebDriverWait wait=new WebDriverWait(driver,Second);
    }

    public static void pageLoadWait(int Second){

        driver.manage().timeouts().pageLoadTimeout(Second,TimeUnit.SECONDS);
    }

    public static void ThreadSleep(int Second) throws InterruptedException {
        Thread.sleep(Second);
    }

    public static void scrollToBottom(){
        ((JavascriptExecutor) driver).
                executeScript("window.scrollTo(0,document.body.scrollHeight)");
    }


    public static void closeBrowser(){
        driver.quit();
    }
}
