package com.iFrames;

import com.Base.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class NormalIFrame extends TestBase {

    public static void main(String[] args) {
        firefoxLaunch();
        openTestSite("https://the-internet.herokuapp.com/iframe");
        pageLoadWait(10);
        typeOniFrame();
        closeBrowser();
    }

    public static void typeOniFrame(){
        driver.switchTo().frame("mce_0_ifr");
        WebElement iFrameEditor=driver.findElement(By.id("tinymce"));
        iFrameEditor.clear();
        iFrameEditor.sendKeys("Test Automation.");
    }
}
