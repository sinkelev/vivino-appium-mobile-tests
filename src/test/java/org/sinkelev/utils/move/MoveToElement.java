package org.sinkelev.utils.move;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import org.sinkelev.drivers.DriverService;
import org.sinkelev.utils.screen.ICenter;
import org.sinkelev.utils.screen.ScreenDevice;
import org.sinkelev.utils.swipe.ISwipe;
import org.sinkelev.utils.swipe.Swipe;

import java.time.Duration;

public class MoveToElement implements IMoveToElement {

    private final ISwipe swipe;
    private WebDriverWait wait;
    private final AppiumDriver driver;
    private int countSwipe;

    public MoveToElement() {
        this.swipe = new Swipe();
        driver = DriverService.instance().get();
        wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        countSwipe = 9;
    }

    @Override
    public void setWait(Duration duration) {
        wait = new WebDriverWait(driver, duration);
    }

    @Override
    public void setCountSwipe(int countSwipe) {
        this.countSwipe = countSwipe;
    }

    @Override
    public WebElement down(By by) {
        ICenter center = ScreenDevice.getCenter();
        for (int i = 0; i < countSwipe; i++) {
            try {
                wait.until(ExpectedConditions.presenceOfElementLocated(by));
                int y = driver.findElement(by).getLocation().getY();
                if (y * 0.8 > center.y()) swipe.down();
                return driver.findElement(by);
            } catch (NotFoundException | TimeoutException n) {
                swipe.down();
            }
        }
        throw new NotFoundException("Element \"" + by + "\" not found");
    }

    @Override
    public WebElement up(By by) {
        ICenter center = ScreenDevice.getCenter();
        for (int i = 0; i < countSwipe; i++) {
            try {
                wait.until(ExpectedConditions.presenceOfElementLocated(by));
                int y = driver.findElement(by).getLocation().getY();
                if (y < center.y()) swipe.up();
                return driver.findElement(by);
            } catch (NotFoundException e) {
                swipe.up();
            }
        }
        throw new NotFoundException("Element \"" + by + "\" not found");
    }
}