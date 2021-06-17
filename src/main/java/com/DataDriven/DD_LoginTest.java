package com.DataDriven;

import com.Base.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

/*
We use Excel file for import Login Data(Email and Password)
Only Excel data Read Implementation
Author: Muntasir
 */
public class DD_LoginTest extends TestBase {

    @BeforeClass
    public void setUp(){
        System.setProperty("webdriver.gecko.driver",System.getProperty("user.dir")+"//src//main//resources//geckodriver.exe");
        driver=new FirefoxDriver();
        Reporter.log("Firefox Launch Successfully.");
        driver.manage().window().maximize();
    }

    @Test
    public void loginTest() throws InterruptedException{
        openTestSite("https://demo.opencart.com/index.php?route=account/login");
        Reporter.log("Open Login page.");

        //Excel Implementation
        Xls_Reader reader=new Xls_Reader("./src/main/resources/LoginData.xlsx");
        String sheetName="Sheet1";

        int rowCount=reader.getRowCount(sheetName);

        for(int rowNum=2; rowNum<=rowCount;rowNum++){
            String email=reader.getCellData(sheetName,"Email",rowNum);
            String pswrd=reader.getCellData(sheetName,"Password",rowNum);

            WebElement Email=driver.findElement(By.id("input-email"));
            WebElement Password=driver.findElement(By.id("input-password"));
            WebElement loginBtn=driver.findElement(By.cssSelector("#content > div > div:nth-child(2) > div > form > input"));

            //Web Action
            Email.clear();
            Email.sendKeys(email);
            Reporter.log(email+ " Type in Email Field.");
            Thread.sleep(2000);

            Password.clear();
            Password.sendKeys(pswrd);
            Reporter.log(pswrd+ " Type in Password Field.");
            Thread.sleep(2000);

            loginBtn.click();
            Reporter.log("Click on Login Button.");
        }
    }

    @AfterClass
    public void tearDown(){
        driver.quit();
    }
}
