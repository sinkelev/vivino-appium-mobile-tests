package org.sinkelev.utils.wait;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.time.Duration;

public interface IWait {

    IWait setWait(Duration duration);

    WebElement visibility(By by);
}
