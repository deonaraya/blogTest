package com.wordpress.blogTest.Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

/**
 * Created by chandrad on 8/18/17.
 */
public class LandingPage extends BasePage {

    public LandingPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver,this);
        waitForWebElement(siteTitle);

    }

    @FindBy(className = "site-title")
    private WebElement siteTitle;

    @FindBy(className = "menu-scroll-down")
    private WebElement viewBlogArrowIcon ;

    @FindBy(xpath = "//h3[@class='entry-title']/a")
    private List<WebElement> blogTitleList;

    @FindBy(xpath = "//div[@class='entry-content']/p")
    private List<WebElement> blogContentList;

    @FindBy(xpath = "//a[text()='Log in']")
    private WebElement loginlink;

    public SignInPage navToSignInPage()
    {
        Actions action = new Actions(driver);
        action.moveToElement(loginlink).build().perform();
        loginlink.click();
        return new SignInPage(driver);
    }


}
