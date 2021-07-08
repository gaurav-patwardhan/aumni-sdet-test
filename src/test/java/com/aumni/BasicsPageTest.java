package com.aumni;

import com.aumni.pages.BasicsPage;
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

 class BasicsPageTest {
    private WebDriver driver;
    private BasicsPage basicsPage;
    private Logger logger = LoggerFactory.getLogger(this.getClass().getName());

    @BeforeEach
    public void setUp() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
        driver.manage().deleteAllCookies();
        driver.get("https://www.aumni.fund");
        basicsPage = new BasicsPage(driver);
    }

    @AfterEach
    public void tearDown() {
        driver.quit();
    }

    /**
     * Click on HowAumniWorks tab and navigate to Basics page. Click on Book a free Demo.
     */
    @Test
    void bookFreeDemo() {

        // arrange
        logger.debug("Opening menu HowAumniWorks");
        basicsPage.clickHowAumniWorks();
        logger.debug("Clicking on 'The Basics' & Wait for the page load: aumni.fund/solutions/the-basics");
        basicsPage.clickOnTheBasicsLink();

        // act
        logger.debug("Clicking on the 'Book a free Demo button' & wait for the page load: aumni.fund/demo");
        basicsPage.clickOnBookFreeDemoButtonAndWaitForItToLoad();

        // assert
        logger.debug("Running assertions");
        assertEquals("Get a Demo — Aumni", driver.getTitle());
        assertEquals("https://www.aumni.fund/demo", driver.getCurrentUrl());
    }


}
