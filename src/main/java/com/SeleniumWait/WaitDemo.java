package com.SeleniumWait;

import com.Base.TestBase;
import com.Navigate.AllAboutNavigate;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public class WaitDemo extends TestBase {
    public static void main(String[] args) {
        firefoxLaunch();
        openTestSite("https://google.com");
        implicitWait(10);
        AllAboutNavigate.navigateTo();
        explicitWait(20);
        pageLoadWait(50);
        closeBrowser();
    }
}
