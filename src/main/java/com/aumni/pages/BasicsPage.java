package com.aumni.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class BasicsPage extends HomePage {

    @FindBy(xpath = "//*[@id=\"w-dropdown-list-0\"]/div/a[1]")
    private WebElement basicsLink;

    @FindBy(xpath = "/html/body/main/section[6]/div[2]/div/div/a")
    private WebElement bookFreeDemoBtn;

    @FindBy(xpath = "//*[@id=\"form\"]")
    private WebElement form;

    public BasicsPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public void clickOnTheBasicsLink() {
        basicsLink.click();
        webDriverWait.until(ExpectedConditions.visibilityOf(bookFreeDemoBtn));
    }

    public void clickOnBookFreeDemoButtonAndWaitForItToLoad() {
        bookFreeDemoBtn.click();
        webDriverWait.until(ExpectedConditions.visibilityOf(form));
    }
}
