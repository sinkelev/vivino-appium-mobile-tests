package org.sinkelev.tests.pages;

import org.openqa.selenium.WebElement;
import org.sinkelev.tests.base.page.BasePage;

import io.appium.java_client.pagefactory.AndroidFindBy;

public class HomePage extends BasePage {
    @AndroidFindBy(xpath = "//*[@content-desc='Search']")
    public WebElement searchBtn;
}
