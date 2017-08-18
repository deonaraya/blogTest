package com.wordpress.blogTest.Tests;

import com.wordpress.blogTest.Pages.LandingPage;
import org.testng.annotations.Test;

/**
 * Created by chandrad on 8/18/17.
 */
public class BlogTests extends BaseTest {

    @Test
    public void testA()
    {
        LandingPage page = new LandingPage(driver);
        page.navToSignInPage().signIn("test_user", "testuser@123");
    }

    @Test
    public void pubslishBlog()
    {
        LandingPage page = new LandingPage(driver);
        page.navToSignInPage().signIn("test_user","testuser@123").
                createBlog("This is a blog by a test_user").navToPublishBlogPage().publishBLog();
    }



}
