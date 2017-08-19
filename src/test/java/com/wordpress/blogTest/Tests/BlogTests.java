package com.wordpress.blogTest.Tests;

import com.wordpress.blogTest.Pages.LandingPage;
import org.testng.annotations.Test;

import java.util.HashMap;

/**
 * Created by chandrad on 8/18/17.
 */
public class BlogTests extends BaseTest {

    String blogTitle = null;
    String blogContent = null;
    HashMap<String, String> commentMap;
    HashMap<String, String> replyMap;


    @Test(groups = "TrivialTests")
    public void verifyTitle(){
        LandingPage page = new LandingPage(driver);
        page.verfySiteTitle("USER'S BLOG!");
    }

    @Test(groups = "PublishTests")
    public void unsignedUserViewBlog(){

        blogTitle = "UnSigned user verify the blog by title";
        blogContent = "This test case validates if an unsigned user can view the existing blogs" ;

        LandingPage page = new LandingPage(driver);
        page.navToSignInPage().signIn("test_user","testuser@123").
                createBlog(blogTitle,blogContent).publishBlog().viewMyBlog().logout().
                navToLandingPage().verifyBlogTitle(blogTitle);
    }


    @Test(groups = "PublishTests")
    public void verifyBlogStrongContent(){

        blogTitle = "signed in user creates a blog with bold content and validates the same";
        blogContent = "This test case validates if user can post a blog with bold content and then see the content <b>appears in bold</b>" ;

        LandingPage page = new LandingPage(driver);
        page.navToSignInPage().signIn("test_user","testuser@123").
                craeateBlogBoldContent(blogTitle,blogContent).publishBlog().viewMyBlog().isSubContentBold("appears in bold");
    }

    @Test(groups = "CommentTests")
    public void addCommentToBlog()
    {

        blogTitle = "unsinged user comments on a existing blog";
        blogContent = "This test case validates if an unsigned user can comment on an existing blog" ;

        commentMap = new HashMap<String, String>();
        commentMap.put("comment", "comment on an existing blog");
        commentMap.put("author", "James Sawyer");
        commentMap.put("email","sawyer@mailinator.com");

        LandingPage page = new LandingPage(driver);
        page.navToSignInPage().signIn("test_user","testuser@123").
                createBlog(blogTitle,blogContent).publishBlog().
                viewMyBlog().logout().navToLandingPage().navToBLogDetailsPage().
                addCommentUnsigned(commentMap.get("comment"), commentMap.get("author"), commentMap.get("email"));
    }

    @Test(groups = "CommentTests")
    public void verifyReplyToComment()
    {
        blogTitle = "unsigned user replies over a existing comment done on a existing blog";
        blogContent = "This test case validates if an unsigned user can reply over a exsiting comment done on an existing blog" ;
        commentMap = new HashMap<String, String>();
        commentMap.put("comment", "comment to be replied by another user");
        commentMap.put("author", "Hugo Reynolds");
        commentMap.put("email","reynolds@mailinator.com");

        replyMap = new HashMap<String, String>();
        replyMap.put("comment", "replied by Noah Perkins");
        replyMap.put("author", "Noah Perkins");
        replyMap.put("email","perkins@mailinator.com");

        LandingPage page = new LandingPage(driver);
        page.navToSignInPage().signIn("test_user","testuser@123").
                createBlog(blogTitle,blogContent).publishBlog().
                viewMyBlog().logout().navToLandingPage().navToBLogDetailsPage().
                addCommentUnsigned(commentMap.get("comment"), commentMap.get("author"), commentMap.get("email"))
                .addReplyToComment(replyMap.get("comment"), replyMap.get("author"), replyMap.get("email"));
    }



}
