package com.Screenshots;

import com.Base.TestBase;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import java.io.File;
import java.io.IOException;

public class PageScreenshot extends TestBase {
    public static void main(String[] args) {
        firefoxLaunch();
        openTestSite("https://google.com/");
        pageLoadWait(10);
        screenshot();
        closeBrowser();
    }

    public static void screenshot(){
        //Take Screenshot
        File srcFile=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);

        //Save Image
        try {
            FileUtils.copyFile(srcFile,new File(System.getProperty("user.dir")+"//src//main//ScreenShots//Google.jpg"),true);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
