package com.MultipleWindow;

import com.Base.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.Set;

public class SwitchMultipleWindow extends TestBase {
    public static void main(String[] args) {
        firefoxLaunch();
        openTestSite("https://the-internet.herokuapp.com/windows");
        switchWindow();
        closeBrowser();
    }

    public static void switchWindow(){
        //Assign parent GUID
        String parentGUID=driver.getWindowHandle();

        //Open Child Window
        WebElement childWindowBtn= driver.findElement(By.cssSelector("#content > div > a"));
        implicitWait(5);
        childWindowBtn.click();

        //Get all GUID
        Set<String> allGUID=driver.getWindowHandles();
        implicitWait(5);

        //Switch to Child
        for(String ChildGUID:allGUID){
            if(!ChildGUID.equals(parentGUID)){
                driver.switchTo().window(ChildGUID);
                driver.navigate().to("https://google.com");
                 String newTitle=driver.getTitle();
                 System.out.println("Child Window Title: "+newTitle);
                 break;
            }
        }
        //Switch to Parent
        for(String ChildGUID:allGUID){
            if(!ChildGUID.equals(parentGUID)){
                driver.switchTo().window(parentGUID);
                driver.navigate().to("https://bbc.com");
                String newTitle=driver.getTitle();
                System.out.println("Parent Window New Title: "+newTitle);
                break;
            }
        }
        //Switch to Child
        for(String ChildGUID:allGUID){
            if(!ChildGUID.equals(parentGUID)){
                driver.switchTo().window(ChildGUID);
                driver.navigate().to("https://apple.com");
                pageLoadWait(10);
                String newTitle=driver.getTitle();
                System.out.println("Child Window New Title: "+newTitle);
                break;
            }
        }
    }
}
