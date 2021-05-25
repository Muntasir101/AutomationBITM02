package com.DropDown;

import com.Base.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class AllAboutDropDown extends TestBase {
    public static void main(String[] args) {
        firefoxLaunch();
        openTestSite("https://the-internet.herokuapp.com/dropdown");
        pageLoadWait(10);
        selectIndex();
        selectValue();
        selectVisibleText();
    }
    public static void selectIndex(){
        WebElement dropDown=driver.findElement(By.id("dropdown"));
        Select sl=new Select(dropDown);
        sl.selectByIndex(1); //Option 1
    }
    public static void selectValue(){
        WebElement dropDown=driver.findElement(By.id("dropdown"));
        Select sl=new Select(dropDown);
        sl.selectByValue("2"); //Option 2
    }

    public static void selectVisibleText(){
        WebElement dropDown=driver.findElement(By.id("dropdown"));
        Select sl=new Select(dropDown);
        sl.selectByVisibleText("Option 1"); //Option 1
    }

}
