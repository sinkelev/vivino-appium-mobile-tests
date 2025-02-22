package org.sinkelev.tests.pages;

import static java.time.temporal.ChronoUnit.SECONDS;

import org.openqa.selenium.WebElement;
import org.sinkelev.tests.base.page.BasePage;

import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.WithTimeout;
import io.qameta.allure.Step;

public class HomePage extends BasePage {
    @WithTimeout(time = 30, chronoUnit = SECONDS)
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
}
