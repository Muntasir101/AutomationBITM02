package com.Properties;

import com.Base.TestBase;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

public class WriteProperties extends TestBase {
    public static void main(String[] args) throws IOException {

        FileOutputStream fis=new FileOutputStream(System.getProperty("user.dir")+"//src//main//resources//Write-config.properties");
        Properties prop=new Properties();

        prop.setProperty("Name","Muntasir Abdullah");
        prop.setProperty("City","Dhaka");
        prop.setProperty("Country","Bangladesh");
        prop.setProperty("Phone","01737951060");

        prop.store(fis,null);

    }
}
