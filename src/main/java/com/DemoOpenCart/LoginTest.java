package com.DemoOpenCart;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

/*
Step 1: Automate Web Action.
Type Email.
Type Password.
Click Login.

Step 2: Verify expected output.
Verify Valid Input.
Verify Invalid input.
       2.1 Invalid Email.
       2.2. Invalid password.
       2.3 Invalid email and password.
 */

public class LoginTest {
    public static WebDriver driver;

    public static void main(String[] args) {
        browserConfig();
        invalidEmail();
        invalidPassword();
        invalidEmailPassword();
        closeBrowser();
    }

 public static void browserConfig(){
     // Set browser Driver path
     System.setProperty("webdriver.gecko.driver","F:\\Training\\PeopleNTech\\BITM Batch 2\\Files\\geckodriver.exe");

     // launch Real Browser
     driver=new FirefoxDriver();

     //Open Test URL/Site
     driver.get("https://demo.opencart.com/index.php?route=account/login");

 }
 //2.1
 public static void invalidEmail(){
     //WebElement
     WebElement email=driver.findElement(By.id("input-email"));
     WebElement password=driver.findElement(By.id("input-password"));
     WebElement loginBtn=driver.findElement(By.cssSelector("#content > div > div:nth-child(2) > div > form > input"));

     //Web Action
     email.clear();
     email.sendKeys("test@test.com");
     password.clear();
     password.sendKeys("1234556");
     loginBtn.click();

     //Verification Invalid Login
     String expectedErrorMessage="Warning: No match for E-Mail Address and/or Password.";
     String actualErrorMessage=driver.findElement(By.cssSelector("#account-login > div.alert.alert-danger.alert-dismissible")).getText();

     if(expectedErrorMessage.equals(actualErrorMessage))
     {
         System.out.println("Login with Invalid Email Test pass.");
     }
     else{
         System.out.println("Login with Invalid Email Test Fail!!. This is Bug");
     }

 }

 //2.2
 public static void invalidPassword(){
     //WebElement
     WebElement email=driver.findElement(By.id("input-email"));
     WebElement password=driver.findElement(By.id("input-password"));
     WebElement loginBtn=driver.findElement(By.cssSelector("#content > div > div:nth-child(2) > div > form > input"));

     //Web Action
     email.clear();
     email.sendKeys("test@test.com");
     password.clear();
     password.sendKeys("1234556");
     loginBtn.click();

     //Verification Invalid Login
     String expectedErrorMessage="Warning: No match for E-Mail Address and/or Password.";
     String actualErrorMessage=driver.findElement(By.cssSelector("#account-login > div.alert.alert-danger.alert-dismissible")).getText();

     if(expectedErrorMessage.equals(actualErrorMessage))
     {
         System.out.println("Login with Invalid password Test pass.");
     }
     else{
         System.out.println("Login with Invalid password Test Fail!!. This is Bug");
     }

 }

 //2.3
    public static void invalidEmailPassword(){
        //WebElement
        WebElement email=driver.findElement(By.id("input-email"));
        WebElement password=driver.findElement(By.id("input-password"));
        WebElement loginBtn=driver.findElement(By.cssSelector("#content > div > div:nth-child(2) > div > form > input"));

        //Web Action
        email.clear();
        email.sendKeys("test@test.com");
        password.clear();
        password.sendKeys("123455633");
        loginBtn.click();

        //Verification Invalid Login
        String expectedErrorMessage="Warning: No match for E-Mail Address and/or Password.";
        String actualErrorMessage=driver.findElement(By.cssSelector("#account-login > div.alert.alert-danger.alert-dismissible")).getText();

        if(expectedErrorMessage.equals(actualErrorMessage))
        {
            System.out.println("Login with Invalid Email and password Test pass.");
        }
        else{
            System.out.println("Login with Invalid Email and password Test Fail!!. This is Bug");
        }

    }

    public static void closeBrowser(){
        driver.quit();
    }
}
