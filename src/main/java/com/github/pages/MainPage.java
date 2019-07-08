package com.github.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;


public class MainPage {

    WebDriver driver;

    public MainPage(WebDriver driver){
        this.driver = driver;
    }

    By signInButton = By.linkText("Sign in");
    By signUpButton = By.linkText("Sign up");

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
            return wait.until(ExpectedConditions.visibilityOfElementLocated(signInButton)).isDisplayed();
        }catch (Exception e){
            return false;
        }
    }

}
