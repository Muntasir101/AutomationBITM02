package com.Alert;

import com.Base.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class AllAboutAlert extends TestBase {
    public static void main(String[] args) throws InterruptedException {
        firefoxLaunch();
        openTestSite("https://the-internet.herokuapp.com/javascript_alerts");
        normalJSAlert();
        confirmJSAlert();
        promptJSAlert();
        closeBrowser();
    }

    public static void normalJSAlert() throws InterruptedException {
        WebElement normalAlertBtn= driver.findElement(By.xpath("//*[@id=\"content\"]/div/ul/li[1]/button"));;
        normalAlertBtn.click();
        pageLoadWait(10);
        ThreadSleep(4);
        //Alert Title
        String AlertTitle=driver.switchTo().alert().getText();
        System.out.println("Alert Title: "+AlertTitle);
        //click Ok
        driver.switchTo().alert().accept();
    }

    public static void confirmJSAlert() throws InterruptedException {
        WebElement normalAlertBtn= driver.findElement(By.xpath("//*[@id=\"content\"]/div/ul/li[2]/button"));;
        normalAlertBtn.click();
        explicitWait(5);
        //Alert Title
        String AlertTitle=driver.switchTo().alert().getText();
        System.out.println("Alert Title: "+AlertTitle);
        //click Ok
        //driver.switchTo().alert().accept();

        //click cancel
        driver.switchTo().alert().dismiss();
    }

    public static void promptJSAlert() {
        WebElement normalAlertBtn= driver.findElement(By.xpath("//*[@id=\"content\"]/div/ul/li[3]/button"));;
        normalAlertBtn.click();
        explicitWait(5);
        //Alert Title
        String AlertTitle=driver.switchTo().alert().getText();
        System.out.println("Alert Title: "+AlertTitle);

        //Type on Alert and verify
        String Default="You entered: ";
        String input="Automation";
        String ExpectedText=Default.concat(input);
        driver.switchTo().alert().sendKeys(input);

        driver.switchTo().alert().accept();

        String ActualText=driver.findElement(By.id("result")).getText();

        if(ExpectedText.equals(ActualText)){
            System.out.println("Test pass");
        }
        else{
            System.out.println("Test Failed. Input value is not match. Actual is: "+ActualText);
        }
    }
}
