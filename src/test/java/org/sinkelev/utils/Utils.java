package org.sinkelev.utils;

import org.openqa.selenium.By;
import org.openqa.selenium.NotFoundException;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.sinkelev.tests.pages.LoginPage;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

import java.time.Duration;

public class Utils {
    private static AndroidDriver driver;
    private static Duration duration;

    public Utils(AndroidDriver driver) {
        this.driver = driver;
    }

    public Utils setWait(Duration duration) {
        this.duration = duration;
        return this;
    }

    public static WebElement visibility(By by) {
        WebDriverWait wait = new WebDriverWait(driver, duration == null ? Duration.ofSeconds(20) : duration);
        try {
            wait.until(ExpectedConditions.presenceOfElementLocated(by));
            return driver.findElement(by);
        } catch (TimeoutException e) {
            throw new NotFoundException("Element " + by + " not found");
        }
    }
}
