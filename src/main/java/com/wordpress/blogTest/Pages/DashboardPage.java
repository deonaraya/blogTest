package com.wordpress.blogTest.Pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
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

    @FindBy(id = "title")
    private WebElement blogTitleTextField;

    @FindBy(id = "content")
    private WebElement blogContentTextField;

    @FindBy(id = "save-post")
    private WebElement saveDraftButton;

    @FindBy(xpath = "//div[@class='draft-title']/a")
    private WebElement draftBlogLink;

    Actions action = new Actions(driver);
    JavascriptExecutor myExecutor = ((JavascriptExecutor) driver);

    public DashboardPage createBlog(String title){

        action.moveToElement(blogTitleTextField).click().build().perform();
        blogTitleTextField.sendKeys(title);
        myExecutor.executeScript("arguments[0].value='Test user likes to blog. The content of the blog can be <b>anything</b>';", blogContentTextField);

        waitForWebElement(draftBlogLink);
        saveDraftButton.click();
        return new DashboardPage(driver);
    }

    public EditBlogsPage navToPublishBlogPage(){
        draftBlogLink.click();
        return new EditBlogsPage(driver);
    }








}
