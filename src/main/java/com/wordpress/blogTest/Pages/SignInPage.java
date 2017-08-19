package com.wordpress.blogTest.Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * Created by chandrad on 8/18/17.
 */
public class SignInPage extends BasePage {

    public SignInPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver,this);
        waitForWebElement(loginForm);
    }

    @FindBy(id = "loginform")
    private WebElement loginForm;

    @FindBy(id = "user_login")
    private WebElement userNameTextField;

    @FindBy(id = "user_pass")
    private WebElement passwordTextField;

    @FindBy(id = "wp-submit")
    private WebElement submitButton;

    public DashboardPage signIn(String username, String password){

        userNameTextField.sendKeys(username);
        passwordTextField.sendKeys(password);
        submitButton.click();
        return new DashboardPage(driver);

    }

    public LandingPage navToLandingPage()
    {
        driver.get("http://ec2-54-90-154-147.compute-1.amazonaws.com/");
        return new LandingPage(driver);

    }

}
