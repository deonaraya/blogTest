package com.wordpress.blogTest.Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 * Created by chandrad on 8/18/17.
 */
public class EditBlogsPage extends BasePage {

    public EditBlogsPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(id = "publish")
    private WebElement publishBlogButton ;
}
