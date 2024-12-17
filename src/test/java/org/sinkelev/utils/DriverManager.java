package org.sinkelev.utils;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.io.FileInputStream;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Properties;

public class DriverManager {

    private static AppiumDriver<MobileElement> driver;
    private static Properties properties;

    static {
        try {
            properties = new Properties();
            properties.load(new FileInputStream("src/test/resources/config.properties"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static AppiumDriver<MobileElement> getDriver() throws MalformedURLException {
        if (driver == null) {
            DesiredCapabilities capabilities = new DesiredCapabilities();
            capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, properties.getProperty("deviceName"));
            capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, properties.getProperty("platformName"));
            capabilities.setCapability(MobileCapabilityType.APP, properties.getProperty("appPath"));
            capabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME, properties.getProperty("automationName"));

            driver = new AndroidDriver<>(new URL(properties.getProperty("appiumUrl")), capabilities);
        }
        return driver;
    }

    public static void quitDriver() {
        if (driver != null) {
            driver.quit();
            driver = null;
        }
    }

    public static void installApp() throws MalformedURLException {
        if (driver == null) {
            getDriver();
        }
        driver.installApp(properties.getProperty("appPath"));
    }

    public static void uninstallApp() {
        if (driver != null) {
            driver.removeApp(properties.getProperty("appPackage"));
        }
    }
}
