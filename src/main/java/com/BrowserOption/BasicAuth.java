package com.BrowserOption;

import com.Base.TestBase;

public class BasicAuth extends TestBase {
    public static void main(String[] args) {
        firefoxLaunch();
        basicAuthentication();
    }

    public static void basicAuthentication(){
        //formula --> protocols://username:password@url
        driver.get("https://admin:admin@the-internet.herokuapp.com/basic_auth");
    }
}
