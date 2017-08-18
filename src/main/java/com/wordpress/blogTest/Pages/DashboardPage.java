package com.wordpress.blogTest.Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * Created by chandrad on 8/18/17.
 */
public class DashboardPage extends BasePage {


    public DashboardPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver,this);
        waitForWebElement(myBlogTitle);
    }

    @FindBy(xpath = "//li[@id='wp-admin-bar-site-name']/a")
    private WebElement myBlogTitle ;

    @FindBy(id = "title-prompt-text")
    private WebElement blogTitleTextField;

    @FindBy(id = "content-prompt-text")
    private WebElement blogContentTextField;

    @FindBy(id = "save-post")
    private WebElement saveDraftButton;

    @FindBy(xpath = "//div[@class='draft-title']/a")
    private WebElement listOfDrafts;








}
