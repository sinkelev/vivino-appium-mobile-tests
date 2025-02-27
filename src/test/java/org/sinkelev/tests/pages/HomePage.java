package org.sinkelev.tests.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.sinkelev.tests.base.page.BasePage;

import java.time.Duration;

import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.qameta.allure.Step;

public class HomePage extends BasePage {

    public HomePage() {
        PageFactory.initElements(new AppiumFieldDecorator(driver, Duration.ofSeconds(20)), this);
    }

    @AndroidFindBy(xpath = "//*[@content-desc='Search']")
    public WebElement searchInput;

    @Step("Click search input")
    public HomePage clickSearchInput() {
        searchInput.click();
        return this;
    }

    @Step("Open Search page")
    public SearchPage getSearchPage() {
        return new SearchPage();
    }

    @Step("Check text on the page")
    public WebElement checkText(String text) {
        return wait.visibility(text(text));
    }
}
