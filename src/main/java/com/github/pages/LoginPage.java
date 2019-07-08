package com.github.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;

import org.testng.Assert;

public class LoginPage {

    WebDriver driver;

    public LoginPage(WebDriver driver){
        this.driver = driver;
    }

    By userNameField = By.id("login_field");
    By passwordField = By.id("password");
    By signIn = By.cssSelector("input.btn.btn-primary btn-block");
    By forgotPassword = By.linkText("Forgot password?");
    By createAccount = By.linkText("Create an account");


    public void enterUserName(WebDriver driver, String userName){
        try{
            driver.findElement(userNameField).sendKeys(userName);
        }catch (NoSuchElementException e){
            Assert.fail("Could not find user name element");
        }
    }

    public void enterUserPassword(WebDriver driver, String password){
        try{
            driver.findElement(passwordField).sendKeys(password);
        }catch (NoSuchElementException e){
            Assert.fail("Could not find password field");
        }
    }

    public void clickLogInButton(WebDriver driver){
        try {
            driver.findElement(signIn).click();
        }catch (NoSuchElementException e){
            Assert.fail("Could not find Sign in button");
        }
    }


}
