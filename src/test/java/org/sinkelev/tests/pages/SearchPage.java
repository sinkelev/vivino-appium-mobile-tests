package org.sinkelev.tests.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.sinkelev.tests.base.page.BasePage;

import java.time.Duration;

import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.qameta.allure.Step;

public class SearchPage extends BasePage {
    public SearchPage() {
        PageFactory.initElements(new AppiumFieldDecorator(driver, Duration.ofSeconds(20)), this);
    }

    @AndroidFindBy(xpath = "//android.widget.EditText[@text='Search for wine']")
    public WebElement searchInput;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='All Wines']")
    public WebElement allWinesBtn;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='My Wines']")
    public WebElement myWinesBtn;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='People']")
    public WebElement peopleBtn;

    @Step("Enter wine")
    public SearchPage enterWine(String vine) {
        searchInput.click();
        searchInput.sendKeys(vine);
        return this;
    }

    @Step("Click on text")
    public SearchPage clickText(String text) {
        wait.visibility(By.xpath("//*[contains(@text,\"" + text + "\")]")).click();
        return this;
    }

    @Step("Open Wine Details Page")
    public WineDetailsPage getWineDetailsPage() {
        return new WineDetailsPage();
    }
}
