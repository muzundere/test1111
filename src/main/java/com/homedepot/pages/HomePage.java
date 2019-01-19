package com.homedepot.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.homedepot.utils.Driver;


public class HomePage {
    private WebDriver driver = Driver.getDriver();
    public HomePage(){
        PageFactory.initElements(driver,this);
    }

    @FindBy(id = "headerSearch")
    public WebElement searchBox;

    public String getTitle(){
        return driver.getTitle();
    }
}
