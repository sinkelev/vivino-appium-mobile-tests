package org.sinkelev.utils.screen;

import org.openqa.selenium.Dimension;
import org.sinkelev.drivers.DriverService;

public class ScreenDevice {

    private ScreenDevice() {
    }

    public static ICenter getCenter() {
        Dimension dimension = DriverService.instance().get().manage().window().getSize();
        return new Center(dimension.getWidth(), dimension.getHeight());
    }
}
