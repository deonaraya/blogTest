package com.wordpress.blogTest.Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * Created by chandrad on 8/18/17.
 */
public class BasePage {

    WebDriver driver;
    WebDriverWait wait;

    public BasePage(WebDriver driver) {
        this.driver = driver;
    }

    public void waitForWebElement(WebElement element){
        wait = new WebDriverWait(driver,10) ;
        wait.until(ExpectedConditions.visibilityOf(element)) ;
    }
}
