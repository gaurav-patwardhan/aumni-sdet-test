package com.aumni;

import com.aumni.pages.HomePage;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.TimeUnit;

import static org.junit.jupiter.api.Assertions.assertEquals;

class HomePageTest {

    private WebDriver driver;
    private HomePage homePage;
    private Logger logger = LoggerFactory.getLogger(this.getClass().getName());

    @BeforeEach
    public void setUp() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
        driver.manage().deleteAllCookies();
        driver.get("https://www.aumni.fund");
        homePage = new HomePage(driver);
    }

    @AfterEach
    public void tearDown() {
        driver.quit();
    }


    /**
     * Click on HowAumniWorks tab and navigate to Basics page. Click on Book a free Demo.
     */
    @Test
    void bookFreeDemoButtonOnHomePage() {

        // act
        logger.debug("Clicking on the 'Get a demo' button & Wait for the page load: aumni.fund/demo");
        homePage.clickOnGetDemo();

        // assert
        logger.debug("Running assertions");
        assertEquals("Get a Demo — Aumni", driver.getTitle());
        assertEquals("https://www.aumni.fund/demo", driver.getCurrentUrl());
    }
}
