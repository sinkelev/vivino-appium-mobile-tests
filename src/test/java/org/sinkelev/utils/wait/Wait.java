package org.sinkelev.utils.wait;

import org.openqa.selenium.By;
import org.openqa.selenium.NotFoundException;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.sinkelev.drivers.DriverService;

import java.time.Duration;

public class Wait implements IWait {

    private Duration duration;

    @Override
    public Wait setWait(Duration duration) {
        this.duration = duration;
        return this;
    }

    @Override
    public WebElement visibility(By by) {
        WebDriverWait wait = new WebDriverWait(DriverService.instance().get(), duration == null ? Duration.ofSeconds(30) : duration);
        try {
            wait.until(ExpectedConditions.presenceOfElementLocated(by));
            return DriverService.instance().get().findElement(by);
        } catch (TimeoutException e) {
            throw new NotFoundException("Element " + by + " not found");
        }
    }
}
