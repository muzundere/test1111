package com.homedepot.utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class ConfigurationReader {
    private static Properties property = new Properties();

    public static String getProperty(String key) {
        try {
            InputStream in = new FileInputStream("config.properties");
            property.load(in);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return property.getProperty(key);
    }
}
