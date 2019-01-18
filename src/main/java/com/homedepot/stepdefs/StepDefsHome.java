package com.homedepot.stepdefs;

import com.homedepot.pages.HomePage;
import com.homedepot.pages.PLP;
import com.homedepot.utils.ConfigurationReader;
import com.homedepot.utils.Driver;
import cucumber.api.java.en.Given;

import static org.junit.Assert.*;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.testng.asserts.SoftAssert;

import java.util.concurrent.TimeUnit;

public class StepDefsHome {

    private WebDriver driver = Driver.getDriver();
    String url = ConfigurationReader.getProperty("url");
    HomePage homePage = new HomePage();
    SoftAssert soft = new SoftAssert();

    @Given("user goes to the home page of the application")
    public void user_goes_to_the_home_page_of_the_application() {
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        driver.get(url);
        String expectedTitle = "The Home Depot";
        soft.assertEquals(homePage.getTitle(), expectedTitle);
        soft.assertEquals(driver.getCurrentUrl(), url);
        soft.assertAll();
    }

    @Given("search {string}")
    public void search(String searchCriteria) {
        homePage.searchBox.sendKeys(searchCriteria + Keys.ENTER);
        soft.assertTrue(driver.getTitle().contains(searchCriteria));
        searchCriteria = searchCriteria.replaceAll(" ", "%2520");
        soft.assertTrue(driver.getCurrentUrl().contains(searchCriteria));
    }
}
