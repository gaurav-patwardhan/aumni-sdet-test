package com.aumni;

import com.aumni.pages.AnalyticsPage;
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

public class AnalyticsPageTest {

    private WebDriver driver;
    private AnalyticsPage analyticsPage;

    private Logger logger = LoggerFactory.getLogger(this.getClass().getName());

    @BeforeEach
    public void setUp() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
        driver.manage().deleteAllCookies();
        driver.get("https://www.aumni.fund");
        analyticsPage = new AnalyticsPage(driver);
    }

    @AfterEach
    public void tearDown() {
        driver.quit();
    }

    /**
     * Click on HowAumniWorks tab and navigate to Analytics page
     */
    @Test
    void howAumniWorksTabTest() {

        // arrange
        logger.debug("Opening menu 'HowAumniWorks'");
        analyticsPage.clickHowAumniWorks();

        // act
        logger.debug("Clicking on 'Analytics'");
        analyticsPage.clickAnalyticsLinkAndWaitForItToLoad();
        logger.debug("Waiting for the page load: aumni.fund/solutions/analytics");

        // assert
        logger.debug("Running assertions");
        assertEquals("Aumni for Analytics", driver.getTitle());
        assertEquals("https://www.aumni.fund/solutions/analytics", driver.getCurrentUrl());
    }
}
