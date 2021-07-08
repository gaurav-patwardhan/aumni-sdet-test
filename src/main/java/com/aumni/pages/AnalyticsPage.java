package com.aumni.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class AnalyticsPage extends HomePage {

    @FindBy(xpath = "//*[@id=\"w-dropdown-list-0\"]/div/a[5]")
    private WebElement analyticsLink;

    @FindBy(xpath = "/html/body/main/section[1]/div[2]/div/h1")
    private WebElement headingElement;

    public AnalyticsPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public void clickAnalyticsLinkAndWaitForItToLoad() {
        analyticsLink.click();
        webDriverWait.until(ExpectedConditions.visibilityOf(headingElement));
    }
}
