package com.TestNGDemo;

import com.Base.TestBase;
import org.testng.annotations.Test;

public class BasicTestNG extends TestBase {

    @Test(priority = 1)
    public static void testCase_001(){
        firefoxLaunch();
        openTestSite("https://google.com");
        closeBrowser();
    }
    @Test(description = "This is Test case 002") //default priority=0
    public static void testCase_002(){
        chromeLaunch();
        openTestSite("https://apple.com");
        closeBrowser();
    }
}
