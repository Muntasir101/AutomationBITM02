package com.Screenshots;

import com.Base.TestBase;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;

import java.io.File;
import java.io.IOException;

public class HighlightElementScreenshot extends TestBase {
    public static void main(String[] args) throws InterruptedException {
        firefoxLaunch();
        openTestSite("https://demo.opencart.com/");
        pageLoadWait(10);
        elementHighlightScreenshot();
        closeBrowser();
    }

    public static void elementHighlightScreenshot() throws InterruptedException {
        WebElement button=driver.findElement(By.cssSelector("#cart > button"));

        JavascriptExecutor jse=(JavascriptExecutor) driver;
        //Highlight Element with red border 3px
        jse.executeScript("arguments[0].style.border='5px solid red'",button);
        Thread.sleep(3000);

        //Take Screenshot
        File srcFile=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);

        //save image
        try {
            FileUtils.copyFile(srcFile,new File(System.getProperty("user.dir")+"//src//main//ScreenShots//HighlightElement.jpg"),true);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
