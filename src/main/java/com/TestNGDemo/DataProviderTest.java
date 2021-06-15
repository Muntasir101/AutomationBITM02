package com.TestNGDemo;

import com.Base.TestBase;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;

public class DataProviderTest {
WebDriver driver;

    @DataProvider(name="LoginData")
    public Object [][] getData()  {
        String loginData[][]={
                {"mail@mail.com","admin123","Invalid"},
                {"mail22@test.com","123456","Invalid"},
                {"testuser@gmail.com","user123","Invalid"},
                {"user101@gmail.com","123456","Valid"}
        };
        return loginData;
    }
    @BeforeClass
    public void setUp(){
        System.setProperty("webdriver.gecko.driver",System.getProperty("user.dir")+"//src//main//resources//geckodriver.exe");
        driver=new FirefoxDriver();
        Reporter.log("Firefox Launch Successfully.");
        driver.manage().window().maximize();
    }

    @Test(dataProvider = "LoginData")
    public void loginTest(String Email, String Password,String input) throws InterruptedException ,IOException{
        driver.get("https://demo.opencart.com/index.php?route=account/login");
        Reporter.log("Open Login page.");
        //WebElement
        WebElement email=driver.findElement(By.id("input-email"));
        WebElement password=driver.findElement(By.id("input-password"));
        WebElement loginBtn=driver.findElement(By.cssSelector("#content > div > div:nth-child(2) > div > form > input"));

        //Web Action
        email.clear();
        email.sendKeys(Email);
        Reporter.log(Email+ " Type in Email Field.");
        Thread.sleep(2000);

        password.clear();
        password.sendKeys(Password);
        Reporter.log(Password+ " Type in Email Field.");
        Thread.sleep(2000);

        loginBtn.click();
        Reporter.log("Click on Login Button.");

        String exp_Title="My Account";
        String act_Title=driver.getTitle();

        if(input.equals("Valid")){
            if(exp_Title.equals(act_Title)){
                Assert.assertTrue(true);
                Reporter.log("Test PASSED for Valid Input.");
                Reporter.log("...........................");

            }
            else {
                Assert.assertTrue(false);
                Reporter.log("Test FAILED!!! for Valid Input.");
                Reporter.log("...........................");
            }
        }
        else if(input.equals("Invalid")){
            if(!exp_Title.equals(act_Title)){
                Assert.assertTrue(true);
                Reporter.log("Test PASSED for Invalid Input.");
                Reporter.log("...........................");
            }
            else {
                Assert.assertTrue(false);
                Reporter.log("Test FAILED!!! for Invalid Input.");
                Reporter.log("...........................");
            }
        }
    }

    @AfterClass
    public void tearDown(){
        driver.quit();
    }
}
