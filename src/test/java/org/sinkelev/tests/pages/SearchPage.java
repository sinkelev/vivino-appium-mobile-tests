package org.sinkelev.tests.pages;

import static java.time.temporal.ChronoUnit.SECONDS;

import org.openqa.selenium.WebElement;
import org.sinkelev.tests.base.page.BasePage;

import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.WithTimeout;

public class SearchPage extends BasePage {
    @WithTimeout(time = 90, chronoUnit = SECONDS)
    @AndroidFindBy(xpath = "//android.widget.EditText[@text='Search for wine']")
    public WebElement searchInput;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='All Wines']")
    public WebElement allWinesBtn;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='My Wines']")
    public WebElement myWinesBtn;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='People']")
    public WebElement peopleBtn;
}
