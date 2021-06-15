package com.TestNGDemo;

import com.Base.TestBase;
import org.testng.Reporter;
import org.testng.annotations.Test;

public class BasicTestNG extends TestBase {

    @Test(priority = 1)
    public static void testCase_001(){
        firefoxLaunch();
        Reporter.log("Firefox Browser launch Successfully.");
        openTestSite("https://google.com");
        Reporter.log("Open Test URL");
        closeBrowser();
        Reporter.log("Test DONE.Browser Close.");
    }
    @Test(description = "This is Test case 002") //default priority=0
    public static void testCase_002(){
        chromeLaunch();
        Reporter.log("Chrome Browser launch Successfully.");
        openTestSite("https://apple.com");
        Reporter.log("Open Test URL");
        closeBrowser();
        Reporter.log("Test DONE.Browser Close.");
    }
}
