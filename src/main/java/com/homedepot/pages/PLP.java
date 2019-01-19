package com.homedepot.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.homedepot.utils.Driver;

import java.util.List;

public class PLP {

    public PLP(){
        PageFactory.initElements(Driver.getDriver(),this);
    }

    @FindBy(xpath = "//div[@id='content']/div/div/div/div/div[contains(@class,'js-pod  js-pod')]")
    public List<WebElement> products;

    @FindBy(xpath = "//div[@id='content']/div/div/div/div/div[contains(@class,'js-pod  js-pod')]//span[@class='pod-plp__brand-name']")
    public List<WebElement> brands;

    @FindBy(xpath = "//div[@id='content']/div/div/div/div/div[contains(@class,'js-pod  js-pod')]//span[@class='pod-plp__brand-name']/..")
    public List<WebElement> brandsWithDetails;

}
