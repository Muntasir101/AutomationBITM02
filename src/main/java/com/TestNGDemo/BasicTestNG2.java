package com.TestNGDemo;

import com.Base.TestBase;
import org.testng.annotations.Test;

public class BasicTestNG2 extends TestBase {

    @Test(priority = 1)
    public static void testCase_003(){
        firefoxLaunch();
        openTestSite("https://google.com");
        closeBrowser();
    }
    @Test(description = "This is Test case 004") //default priority=0
    public static void testCase_004(){
        chromeLaunch();
        openTestSite("https://apple.com");
        closeBrowser();
    }
}
