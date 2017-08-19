package com.wordpress.blogTest.Pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import java.util.List;

/**
 * Created by chandrad on 8/18/17.
 */
public class DashboardPage extends BasePage {


    public DashboardPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver,this);
        waitForWebElement(htmlTitle);
    }

    @FindBy(xpath = "//li[@id='wp-admin-bar-site-name']/a")
    private WebElement htmlTitle ;

    @FindBy(id = "title")
    private WebElement blogTitleTextField;

    @FindBy(id = "content")
    private WebElement blogContentTextField;

    @FindBy(id = "save-post")
    private WebElement saveDraftButton;

    @FindBy(xpath = "//div[@class='draft-title']/a")
    private WebElement draftBlogLink;

    @FindBy(xpath = "//div[@class='draft-title']/a")
    private List<WebElement> draftBlogList;

    Actions action = new Actions(driver);
    JavascriptExecutor myExecutor = ((JavascriptExecutor) driver);

    public DashboardPage isIndexPageTitle(String htmTitle){
        Assert.assertEquals(htmlTitle.getText(),htmTitle);
        return this;
    }

    public EditBlogsPage createBlog(String title, String content){
        blogTitleTextField.sendKeys(title);
        blogContentTextField.sendKeys(content);
        saveDraftButton.click();

        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
            draftBlogList.get(0).click();
        return new EditBlogsPage(driver);
    }

    public EditBlogsPage craeateBlogBoldContent(String title, String boldContent) {
        blogTitleTextField.sendKeys(title);
        myExecutor.executeScript("arguments[0].value= \"" + boldContent + "\";", blogContentTextField);
        saveDraftButton.click();

        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        draftBlogList.get(0).click();
        return new EditBlogsPage(driver);
    }










}
