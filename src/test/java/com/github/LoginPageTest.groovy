package com.github

import com.github.pages.LoginPage
import com.github.pages.MainPage
import org.openqa.selenium.WebDriver
import org.openqa.selenium.chrome.ChromeDriver
import org.openqa.selenium.chrome.ChromeOptions

import spock.lang.Shared
import spock.lang.Specification

class LoginPageTest extends Specification{

    @Shared WebDriver driver
    @Shared MainPage mainPage
    @Shared LoginPage loginPage

    @Shared String pageUrl = "https://www.github.com"

    def setupSpec(){

        loginPage = new LoginPage(driver)


        ChromeOptions chrome_options = new ChromeOptions()
        chrome_options.addArguments("window-size=1366,768", "--no-sandbox", "headless")
        driver = new ChromeDriver(chrome_options)
    }

    def cleanupSpec(){
        driver.close()
    }

    def "Open main page"(){
        when: ""
            driver.get(pageUrl)
            mainPage = new MainPage(driver)
        then: ""
            assert mainPage.isLoad()
    }

}
