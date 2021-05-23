package com.Scroll;

import com.Base.TestBase;
import org.openqa.selenium.JavascriptExecutor;

public class AllAboutScroll extends TestBase {
    public static void main(String[] args) {
        firefoxLaunch();
        openTestSite("https://bbc.com");
        pageLoadWait(5);
        scrollToSpecific();
        scrollToBottom();
        closeBrowser();
    }
    public static void scrollToSpecific(){
        ((JavascriptExecutor) driver).
                executeScript("window.scrollTo(0,400)","");
    }

}
