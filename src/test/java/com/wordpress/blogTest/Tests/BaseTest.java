package com.wordpress.blogTest.Tests;

import com.wordpress.blogTest.Helper.CommonMethods;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

/**
 * Created by chandrad on 8/18/17.
 */
public class BaseTest {

    WebDriver driver;

    @BeforeMethod(groups = {"TrivialTests","PublishTests","CommentTests" })
    public void setUp() throws Exception {
        try
        {
            CommonMethods.getStatus("http://ec2-54-90-154-147.compute-1.amazonaws.com/");
        }
        catch (Exception e) {
           throw e;
        }

        System.setProperty("webdriver.chrome.driver","src/main/resources/chromedriver");
        driver = new ChromeDriver();
        driver.get("http://ec2-54-90-154-147.compute-1.amazonaws.com/");
        driver.manage().window().maximize();
    }

    @AfterMethod(groups = {"TrivialTests","PublishTests","CommentTests" })
    public void tearDown()
    {
        driver.close();
      //  driver.quit();

    }
}
