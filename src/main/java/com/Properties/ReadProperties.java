package com.Properties;

import com.Base.TestBase;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ReadProperties extends TestBase {
    public static void main(String[] args) throws IOException {

        FileInputStream fis=new FileInputStream(System.getProperty("user.dir")+"//src//main//resources//config.properties");
        Properties prop=new Properties();
        prop.load(fis);

        System.out.println(prop.getProperty("email"));
        System.out.println(prop.getProperty("password"));


    }
}
