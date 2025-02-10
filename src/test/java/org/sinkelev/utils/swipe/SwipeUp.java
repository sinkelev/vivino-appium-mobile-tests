package org.sinkelev.utils.swipe;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.interactions.PointerInput;
import org.openqa.selenium.interactions.Sequence;
import org.sinkelev.utils.screen.ICenter;
import org.sinkelev.utils.screen.ScreenDevice;

import java.time.Duration;
import java.util.Collections;

public class SwipeUp implements ISwipeStart {

    private AppiumDriver driver;
    private ICenter center;

    public SwipeUp(AppiumDriver driver) {
        this.driver = driver;
        center = ScreenDevice.getCenter();
    }

    @Override
    public void start() {
        int x = center.x();
        int y = center.y();
        PointerInput finger = new PointerInput(PointerInput.Kind.TOUCH, "finger");
        Sequence scroll = new Sequence(finger, 0);
        scroll.addAction(finger.createPointerMove(Duration.ZERO, PointerInput.Origin.viewport(), x, y));
        scroll.addAction(finger.createPointerDown(PointerInput.MouseButton.LEFT.asArg()));
        scroll.addAction(finger.createPointerMove(Duration.ofMillis(600), PointerInput.Origin.viewport(), x, (int) (y - (y * 0.8))));
        scroll.addAction(finger.createPointerUp(PointerInput.MouseButton.LEFT.asArg()));
        driver.perform(Collections.singletonList(scroll));
    }
}
