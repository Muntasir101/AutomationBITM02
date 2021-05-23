package com.Navigate;

import com.Base.TestBase;

public class AllAboutNavigate extends TestBase {
    public static void main(String[] args) {
        firefoxLaunch();
        openTestSite("https://bbc.com");
        navigateTo();
        navigateBack();
        navigateForward();
        closeBrowser();
    }

    public static void navigateTo(){
        driver.navigate().to("https://google.com");
    }

    public static void navigateBack(){
        driver.navigate().back();
    }

    public static void navigateForward(){
        driver.navigate().forward();
    }
}
