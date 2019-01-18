package com.homedepot.pages;

import org.openqa.selenium.support.PageFactory;
import com.homedepot.utils.Driver;

public class PIP {

    public PIP(){
        PageFactory.initElements(Driver.getDriver(),this);
    }
}
