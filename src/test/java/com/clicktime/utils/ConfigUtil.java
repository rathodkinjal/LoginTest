package com.clicktime.utils;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class ConfigUtil {

    public static Properties prop = new Properties();

    public static void init() {
        try {
            InputStream input = ConfigUtil.class.getClassLoader().getResourceAsStream("env.properties");
            prop.load(input);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static String getBaseUrl() throws IOException {
        return prop.getProperty("url");
    }

    public static String getChromeDriverPath() throws IOException {
        return prop.getProperty("chrome-driver-path");
    }

    public static String getErrorMessage() throws IOException {
        return prop.getProperty("error-message");
    }

    public static String getSuccessMessage() throws IOException {
        return prop.getProperty("success-message");
    }
}
