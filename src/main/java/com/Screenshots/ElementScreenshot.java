package com.Screenshots;

import com.Base.TestBase;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebElement;

import java.io.File;
import java.io.IOException;

public class ElementScreenshot extends TestBase {
    public static void main(String[] args) {
        firefoxLaunch();
        openTestSite("https://demo.opencart.com/");
        pageLoadWait(10);
        screenshotElement();
        closeBrowser();
    }

    public static void screenshotElement(){
        WebElement button=driver.findElement(By.cssSelector("#cart > button"));

        // Capture Screenshot
        File srcFile=button.getScreenshotAs(OutputType.FILE);

        //save image
        try {
            FileUtils.copyFile(srcFile,new File(System.getProperty("user.dir")+"//src//main//ScreenShots//Button.jpg"),true);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
