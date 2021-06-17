package com.CrossBrowserTest;

import com.Base.TestBase;
import com.DataDriven.Xls_Reader;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class CB_TestCase001 extends TestBase {

    @BeforeClass
    @Parameters("Browser")
    public void setUp(String browserName){
        if(browserName.equalsIgnoreCase("Chrome")){
            chromeLaunch();
        }
        else if(browserName.equalsIgnoreCase("Firefox")){
            firefoxLaunch();
        }
    }

    @Test
    public void loginTest() throws InterruptedException {

        openTestSite("https://demo.opencart.com/index.php?route=account/login");

        //Excel Implementation
        Xls_Reader reader = new Xls_Reader("./src/main/resources/LoginData.xlsx");
        String sheetName = "Sheet1";

        int rowCount = reader.getRowCount(sheetName);

        for (int rowNum = 2; rowNum <= rowCount; rowNum++) {
            String email = reader.getCellData(sheetName, "Email", rowNum);
            String pswrd = reader.getCellData(sheetName, "Password", rowNum);
            String input = reader.getCellData(sheetName, "input", rowNum);

            WebElement Email = driver.findElement(By.id("input-email"));
            WebElement Password = driver.findElement(By.id("input-password"));
            WebElement loginBtn = driver.findElement(By.cssSelector("#content > div > div:nth-child(2) > div > form > input"));

            //Web Action
            Email.clear();
            Email.sendKeys(email);
            Reporter.log(email + " Type in Email Field.");
            Thread.sleep(2000);

            Password.clear();
            Password.sendKeys(pswrd);
            Reporter.log(pswrd + " Type in Password Field.");
            Thread.sleep(2000);

            loginBtn.click();
            Reporter.log("Click on Login Button.");

            //Write Test Result in Excel
            String exp_Title = "My Account";
            String act_Title = driver.getTitle();

            if (input.equals("Valid")) {
                if (exp_Title.equals(act_Title)) {
                    Assert.assertTrue(true);
                    //Excel Write
                    reader.setCellData(sheetName,"Result",rowNum,"PASSED");
                    Reporter.log("Test PASSED for Valid Input.");
                    Reporter.log("...........................");

                } else {
                    Assert.assertTrue(false);
                    //Excel Write
                    reader.setCellData(sheetName,"Result",rowNum,"FAILED");
                    Reporter.log("Test FAILED!!! for Valid Input.");
                    Reporter.log("...........................");
                }
            } else if (input.equals("Invalid")) {
                if (!exp_Title.equals(act_Title)) {
                    Assert.assertTrue(true);
                    //Excel Write
                    reader.setCellData(sheetName,"Result",rowNum,"PASSED");
                    Reporter.log("Test PASSED for Invalid Input.");
                    Reporter.log("...........................");
                } else {
                    Assert.assertTrue(false);
                    //Excel Write
                    reader.setCellData(sheetName,"Result",rowNum,"FAILED");
                    Reporter.log("Test FAILED!!! for Invalid Input.");
                    Reporter.log("...........................");
                }
            }
        }
    }
    @AfterClass
    public void tearDown () {
        driver.quit();
    }

}
