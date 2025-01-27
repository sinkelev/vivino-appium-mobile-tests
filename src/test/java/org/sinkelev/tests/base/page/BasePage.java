package org.sinkelev.tests.base.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.sinkelev.utils.DriverManager;
import org.sinkelev.utils.Utils;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class BasePage {
    private final Utils utils;
    protected AndroidDriver driver;
    public BasePage() {
        this.driver = DriverManager.getDriver();
        this.utils = new Utils(driver);
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    public WebElement checkContentDesc(String text) {
        return Utils.visibility(description(text));
    }

    public WebElement checkText(String text) {
        return Utils.visibility(text(text));
    }

    protected By text(String text) {
        return By.xpath("//*[@text=\"" + text + "\"]");
    }

    protected By description(String text) {
        return By.xpath("//*[@content-desc\n=\"" + text + "\"]");
    }
}

