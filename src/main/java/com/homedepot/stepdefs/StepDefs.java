package com.homedepot.stepdefs;

import com.homedepot.pages.HomePage;
import com.homedepot.pages.PIP;
import com.homedepot.pages.PLP;
import com.homedepot.utils.BrowserUtils;
import com.homedepot.utils.ConfigurationReader;
import com.homedepot.utils.Driver;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.testng.asserts.SoftAssert;

import java.util.concurrent.TimeUnit;

public class StepDefs {
    WebDriver driver = Driver.getDriver();
    HomePage homePage = new HomePage();
    PLP plp = new PLP();
    PIP pip = new PIP();
    String url = ConfigurationReader.getProperty("url");
    SoftAssert soft = new SoftAssert();
    String brandsWithDetails;

    @Before
    public void startUp() {
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
    }

    @Given("user goes to the home page of the application")
    public void user_goes_to_the_home_page_of_the_application() {
        driver.get(url);
        String expectedTitle = "The Home Depot";
        soft.assertEquals(homePage.getTitle(), expectedTitle,"Actual Title is not correct");
        soft.assertEquals(driver.getCurrentUrl(), url, "Actual URL is not correct");
    }

    @Given("search {string}")
    public void search(String searchCriteria) {
        homePage.searchBox.sendKeys(searchCriteria + Keys.ENTER);
        soft.assertTrue(driver.getTitle().contains(searchCriteria),"Actual Title for search is not correct");
        searchCriteria = searchCriteria.trim().replaceAll(" ", "%2520");
        soft.assertTrue(driver.getCurrentUrl().contains(searchCriteria),"Actual URL for search is not correct");
    }

    @Then("User validates products are listed")
    public void user_validates_products_are_listed() {
        soft.assertTrue(plp.brands.size() > 0,"We have no product to list");
        brandsWithDetails = plp.brandsWithDetails.get(0).getText();
        BrowserUtils.clickToElement(plp.brandsWithDetails.get(0), driver);
    }

    @Then("Validate the selected ptoducts details")
    public void validate_the_selected_ptoducts_details() {
        String expectedBrand = brandsWithDetails.split(" ")[0];
        String actualBrand = pip.brand.getText();
        soft.assertEquals(actualBrand, expectedBrand,"Actual brand name is not correct");
        soft.assertTrue(brandsWithDetails.contains(pip.productDetails.getText()),"Actual product details are not correct");
        soft.assertAll();
    }

    @AfterClass
    public void tearDown() {
        driver.close();
    }
}
