package com.Properties;

import com.Base.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

public class LoginWithProperties extends TestBase {
    public static void main(String[] args) throws IOException{
        firefoxLaunch();
        openTestSite("https://demo.opencart.com/index.php?route=account/login");
        pageLoadWait(5);
        testCase_001();
        testCase_002();
        closeBrowser();
    }

    public static void testCase_001() throws IOException {
        FileInputStream fis=new FileInputStream(System.getProperty("user.dir")+"//src//main//resources//config.properties");
        Properties prop=new Properties();
        prop.load(fis);

        //WebElement
        WebElement email = driver.findElement(By.id("input-email"));
        WebElement password = driver.findElement(By.id("input-password"));
        WebElement loginBtn = driver.findElement(By.cssSelector("#content > div > div:nth-child(2) > div > form > input"));

        //Web Action
        email.clear();
        email.sendKeys(prop.getProperty("email_Invalid"));
        password.clear();
        password.sendKeys(prop.getProperty("password_Invalid"));
        loginBtn.click();

        //Verification Invalid Login
        String expectedErrorMessage = "Warning: No match for E-Mail Address and/or Password.";
        String actualErrorMessage = driver.findElement(By.cssSelector("#account-login > div.alert.alert-danger.alert-dismissible")).getText();

        if (expectedErrorMessage.equals(actualErrorMessage)) {
            System.out.println("Login with Invalid Email Test pass.");
        } else {
            System.out.println("Login with Invalid Email Test Fail!!. This is Bug");
        }

        //Write to properties
        FileOutputStream fos=new FileOutputStream(System.getProperty("user.dir")+"//src//main//resources//Write-config.properties");
        Properties prop2=new Properties();
        prop2.setProperty("Result","testCase_001 Test Passed");
        prop2.store(fos,null);
        fos.close();
    }

    public static void testCase_002() throws IOException {
        FileInputStream fis=new FileInputStream(System.getProperty("user.dir")+"//src//main//resources//config.properties");
        Properties prop=new Properties();
        prop.load(fis);

        //WebElement
        WebElement email = driver.findElement(By.id("input-email"));
        WebElement password = driver.findElement(By.id("input-password"));
        WebElement loginBtn = driver.findElement(By.cssSelector("#content > div > div:nth-child(2) > div > form > input"));

        //Web Action
        email.clear();
        email.sendKeys(prop.getProperty("email_valid"));
        password.clear();
        password.sendKeys(prop.getProperty("password_valid"));
        loginBtn.click();

        System.out.println("Login with valid Email and Password Test pass.");

        //Write to properties
        FileOutputStream fos=new FileOutputStream(System.getProperty("user.dir")+"//src//main//resources//Write-config.properties");
        Properties prop2=new Properties();
        prop2.setProperty("Result","testCase_002 Test Passed");
        prop2.store(fos,null);
        fos.close();
    }
}
