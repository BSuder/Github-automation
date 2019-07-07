package com.github.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.seleniumhq.jetty9.server.handler.ContextHandler;
import org.testng.Assert;

import java.util.concurrent.TimeoutException;

public class MainPage {

    General general;
    WebDriver driver;

    public MainPage(WebDriver driver){
        this.general = new General(driver);
        PageFactory.initElements(driver, this);
    }

    By signInButton = By.className("HeaderMenu-link no-underline mr-3");
    By signUpButton = By.className("HeaderMenu-link d-inline-block no-underline border border-gray-dark rounded-1 px-2 py-1");

    public void clickSignInButton() {
        try {
            driver.findElement(signInButton).click();
        } catch (NoSuchElementException noElem) {
            Assert.fail("Could not find sign in button");
        }
    }

    public void clickSignUpButton(){
        try{
            driver.findElement(signUpButton).click();
        }catch (NoSuchElementException noElem){
            Assert.fail("Could not find sign in button");
        }
    }

    public boolean isLoad(){
        try{
            WebDriverWait wait = new WebDriverWait(driver, 30);
            wait.until(ExpectedConditions.visibilityOfElementLocated(signInButton));
        }catch (Exception e){
            return false;
        }
        return true;
    }

}
