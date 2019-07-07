package com.github.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class General {

    public General(WebDriver webdriver){
        PageFactory.initElements(webdriver, this);
    }

}
