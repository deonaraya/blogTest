package com.wordpress.blogTest.Tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

/**
 * Created by chandrad on 8/18/17.
 */
public class BaseTest {

    WebDriver driver;

    @BeforeTest
    public void setUp()
    {
        driver = new ChromeDriver();
        driver.get("http://ec2-54-90-154-147.compute-1.amazonaws.com/");
        driver.manage().window().maximize();
    }

    @AfterTest
    public void tearDown()
    {
        driver.close();
        driver.quit();

    }
}
