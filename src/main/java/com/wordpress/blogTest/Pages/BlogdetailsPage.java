package com.wordpress.blogTest.Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

/**
 * Created by chandrad on 8/18/17.
 */
public class BlogdetailsPage extends BasePage {

    public BlogdetailsPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver,this);
        waitForWebElement(blogFrame);
    }

    @FindBy(id = "primary")
    private WebElement blogFrame;

    @FindBy(className = "post-edit-link")
    private WebElement editLink;

    @FindBy(className = "entry-title")
    private WebElement blogTitle ;

    @FindBy(className = "entry-content")
    private WebElement blogContent;

    @FindBy(xpath = "//div[@class='entry-content']//b")
    private WebElement blogContentinBold;

    @FindBy(id = "comment")
    private WebElement commentTextField;

    @FindBy(id = "author")
    private WebElement authorNameTextField;

    @FindBy(id = "email")
    private WebElement authorEmailTextField;

    @FindBy(id = "url")
    private WebElement authorURLTextField;

    @FindBy(id = "submit")
    private WebElement postCommentButton;

    @FindBy(xpath = "//div[@class='reply']/a")
    private WebElement replyLink;

    @FindBy(id = "cancel-comment-reply-link")
    private WebElement canelReplyLink;

    @FindBy(xpath = "//a[text()='Log out']")
    private WebElement logoutLink ;


    public BlogdetailsPage isSubContentBold(String subContent){
        Assert.assertEquals(blogContentinBold.getText(),subContent);
        return this;
    }

    public SignInPage logout(){
        logoutLink.click();
        return new SignInPage(driver);
    }

    public BlogdetailsPage addCommentUnsigned(String comment, String name, String email)
    {
        commentTextField.clear();
        commentTextField.sendKeys(comment);

        authorNameTextField.clear();
        authorNameTextField.sendKeys(name);

        authorEmailTextField.clear();
        authorEmailTextField.sendKeys(email);
        postCommentButton.click();

        return this;
    }

    public BlogdetailsPage addReplyToComment(String comment, String name, String email)
    {
        replyLink.click();
        waitForWebElement(canelReplyLink);
        commentTextField.clear();
        commentTextField.sendKeys(comment);

        authorNameTextField.clear();
        authorNameTextField.sendKeys(name);

        authorEmailTextField.clear();
        authorEmailTextField.sendKeys(email);
        postCommentButton.click();

        return this;
    }



}
