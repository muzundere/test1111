package com.homedepot.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.homedepot.utils.Driver;

public class PIP {

    public PIP(){
        PageFactory.initElements(Driver.getDriver(),this);
    }

    @FindBy(css = ".product-title__brand>a>span")
    public WebElement brand;

    @FindBy(css = ".product-title__title")
    public WebElement productDetails;

}
