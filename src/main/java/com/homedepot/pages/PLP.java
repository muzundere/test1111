package com.homedepot.pages;

import org.openqa.selenium.support.PageFactory;
import com.homedepot.utils.Driver;

public class PLP {

    public PLP(){
        PageFactory.initElements(Driver.getDriver(),this);
    }

}
