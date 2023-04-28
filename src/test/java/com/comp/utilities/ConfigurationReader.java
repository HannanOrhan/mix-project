package com.cydeo.utilities;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ConfigurationReader {
    //Steps to read from properties type of files
    //1-create object of properties
    //make private, so it's not accessible from outside the of the class. Limit access
    //static is to make sure its created and loaded before everything
    private static Properties properties = new Properties();

    static {
        //I want to create before everything

        try {
            //2-we need to open file in the Java memory using FileInputStream
            FileInputStream file = new FileInputStream("configuration.properties");
            //3-Load the properties in the Properties object
            properties.load(file);
            //close the file in the memory to save memory
            file.close();
        }catch (IOException e){
            e.printStackTrace();
            System.out.println("File not found with given path!!!");
        }
    }
    public static String getProperty(String keyword) {
        return properties.getProperty(keyword);
    }
}
