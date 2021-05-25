package com.MultipleWindow;

import com.Base.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.Set;

public class GetGUID extends TestBase {
    public static void main(String[] args) {
        firefoxLaunch();
        openTestSite("https://the-internet.herokuapp.com/windows");
        guidGenerate();
        allGUIDGenerate();
        closeBrowser();
    }

    public static void guidGenerate(){
        String parentGUID=driver.getWindowHandle();
        System.out.println("parent GUID: "+parentGUID);
    }
    public static void allGUIDGenerate(){
        WebElement childWindowBtn= driver.findElement(By.cssSelector("#content > div > a"));
        implicitWait(5);
        childWindowBtn.click();
        //Get all GUID
        Set<String> allGUID=driver.getWindowHandles();
        implicitWait(5);
        System.out.println(allGUID);
    }
}
