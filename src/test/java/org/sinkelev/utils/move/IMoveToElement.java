package org.sinkelev.utils.move;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.time.Duration;

public interface IMoveToElement {

    WebElement down(By by);

    WebElement up(By by);

    void setWait(Duration duration);

    void setCountSwipe(int countSwipe);
}