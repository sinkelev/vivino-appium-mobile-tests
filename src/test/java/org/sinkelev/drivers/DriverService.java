package org.sinkelev.drivers;

import org.sinkelev.data.TestData;
import org.sinkelev.drivers.capability.Capability;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;

import java.net.MalformedURLException;
import java.net.URL;

public class DriverService implements IDriverService {

    private static IDriverService driverService;
    private static final ThreadLocal<AppiumDriver> STORAGE = new ThreadLocal<>();

    private DriverService() {
    }

    public static IDriverService instance() {
        if (driverService == null) {
            driverService = new DriverService();
        }
        return driverService;
    }

    @Override
    public void setDriver() {
        Capability capability = TestData.getUser().getCapability();
        try {
            AppiumDriver driver = new AndroidDriver(new URL(capability.getUrl()), capability.getProperty());
            driver.setSetting("ocrLanguage", "rus+eng");
            driver.setSetting("getMatchedImageResult", true);
            STORAGE.set(driver);
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public AppiumDriver get() {
        return STORAGE.get();
    }
}