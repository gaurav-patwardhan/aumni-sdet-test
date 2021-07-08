package com.aumni.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomePage {

    @FindBy(xpath = "//*[@id=\"w-dropdown-toggle-0\"]/div[1]")
    private WebElement howAumniWorksTab;

    @FindBy(xpath = "/html/body/div[4]/div[2]/div[2]/a[3]")
    private WebElement getDemoBtn;

    @FindBy(xpath = "//*[@id=\"form\"]")
    private WebElement form;

    WebDriverWait webDriverWait;

    public HomePage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        webDriverWait = new WebDriverWait(driver, 10);
    }

    public void clickHowAumniWorks() {
        howAumniWorksTab.click();
    }

    public void clickOnGetDemo(){
        getDemoBtn.click();
        webDriverWait.until(ExpectedConditions.visibilityOf(form));
    }
}
