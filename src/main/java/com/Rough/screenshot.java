package com.Rough;

import com.Base.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class screenshot extends TestBase {
    public static void main(String[] args) throws InterruptedException {
        firefoxLaunch();
        openTestSite("https://demo.opencart.com/");
        pageLoadWait(10);
        PageScreenshot(driver,"New Test Image");
        WebElement searchBox=driver.findElement(By.name("search"));
        elementHighlightScreenshot(driver,searchBox,"New Element Highlight");
        closeBrowser();
    }
}
