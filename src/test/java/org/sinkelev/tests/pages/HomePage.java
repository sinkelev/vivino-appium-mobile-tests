package org.sinkelev.tests.pages;

import static java.time.temporal.ChronoUnit.SECONDS;

import org.openqa.selenium.WebElement;
import org.sinkelev.tests.base.page.BasePage;

import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.WithTimeout;

public class HomePage extends BasePage {
    @WithTimeout(time = 10, chronoUnit = SECONDS)
    @AndroidFindBy(xpath = "//*[@content-desc='Search']")
    public WebElement searchBtn;
}
