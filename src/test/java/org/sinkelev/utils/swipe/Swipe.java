package org.sinkelev.utils.swipe;

import org.sinkelev.drivers.DriverService;

import io.appium.java_client.AppiumDriver;

public class Swipe implements ISwipe {

    private ISwipeStart swipeDown;

    private ISwipeStart swipeUp;

    public Swipe() {
        AppiumDriver driver = DriverService.instance().get();
        this.swipeDown = new SwipeDown(driver);
        this.swipeUp = new SwipeUp(driver);
    }

    @Override
    public void down() {
        swipeDown.start();
    }

    @Override
    public void up() {
        swipeUp.start();
    }
}
