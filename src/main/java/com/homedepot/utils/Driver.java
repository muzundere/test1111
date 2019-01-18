package com.homedepot.utils;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class Driver {
    private static WebDriver driver;

    public static WebDriver getDriver() {
        String browser = System.getProperty("browser")!=null? System.getProperty("browser"): ConfigurationReader.getProperty("browser");
        if (driver == null) {
            switch (browser.toLowerCase()) {
                case "chrome":
                    WebDriverManager.chromedriver().setup();
                    driver = new ChromeDriver();
                    break;
                case "firefox":
                    WebDriverManager.firefoxdriver().setup();
                    driver = new FirefoxDriver();
                    break;
                case "egde":
                    WebDriverManager.edgedriver().setup();
                    driver = new EdgeDriver();
                    break;
                case "internet explorer":
                    WebDriverManager.iedriver().setup();
                    driver = new InternetExplorerDriver();
                    break;
                default:
                    System.out.println("Invalid browser type");
            }
        }
        return driver;
    }

    public static void closeDriver(){
        if(driver!=null){
            driver.close();
        }
    }

}
