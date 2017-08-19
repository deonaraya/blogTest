package com.wordpress.blogTest.Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * Created by chandrad on 8/18/17.
 */
public class EditBlogsPage extends BasePage {

    public EditBlogsPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver,this);
        waitForWebElement(editPostTitle);
    }

    @FindBy(xpath = "//h1[text()='Edit Post']")
    private WebElement editPostTitle;

    @FindBy(xpath = "//input[@id='publish'][@value='Publish']")
    private WebElement publishBlogButton ;

    @FindBy(xpath = "//input[@id='publish'][@value='Update']")
    private WebElement updateBlogButon;

    @FindBy(xpath = "//div[@id='message']/p")
    private WebElement successMessage;

    @FindBy(xpath = "//a[text()='View post']")
    private WebElement viewPostLink ;

    public EditBlogsPage publishBlog(){
        publishBlogButton.click();
        waitForWebElement(updateBlogButon);
        return new EditBlogsPage(driver);
    }

    public BlogdetailsPage viewMyBlog(){
        viewPostLink.click();
        return new BlogdetailsPage(driver);
    }




}
