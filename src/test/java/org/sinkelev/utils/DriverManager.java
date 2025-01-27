package org.sinkelev.utils;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.Properties;

public class DriverManager {

    private static AndroidDriver driver;
    private static Properties properties;

    static {
        try {
            properties = new Properties();
            properties.load(new FileInputStream("src/test/resources/config.properties"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static AndroidDriver getDriver() {
        if (driver == null) {
            try {
                UiAutomator2Options options = new UiAutomator2Options();
                options.setDeviceName(properties.getProperty("deviceName"));
                options.setPlatformName(properties.getProperty("platformName"));
                options.setAutomationName(properties.getProperty("automationName"));
                options.setUdid(properties.getProperty("udid"));
                options.setPlatformVersion(properties.getProperty("platformVersion"));
                options.setAppActivity(properties.getProperty("appActivity"));
                //for slow pc
                options.setAdbExecTimeout(Duration.ofMillis(120000));
                options.setNewCommandTimeout(Duration.ofMillis(120000));
                options.setUiautomator2ServerLaunchTimeout(Duration.ofMillis(120000));

                driver = new AndroidDriver(new URL(properties.getProperty("appiumUrl")), options);
            } catch (MalformedURLException e) {
                e.printStackTrace();
            }
        }
        return driver;
    }

    public static void quitDriver() {
        if (driver != null) {
            driver.quit();
            driver = null;
        }
    }

    public static void installApp() {
        String appPath = properties.getProperty("appPath");
        File appFile = new File(System.getProperty("user.dir"), appPath);
        driver.installApp(appFile.getAbsolutePath());
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public static void uninstallApp() {
        driver.removeApp(properties.getProperty("appPackage"));
    }

    public static void openApp() {
        if (driver.isAppInstalled(properties.getProperty("appPackage"))) {
            driver.activateApp(properties.getProperty("appPackage"));

        }
        try {
            Thread.sleep(15000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public void closeApp() {
        driver.terminateApp(properties.getProperty("appPackage"));
    }

    public static void installAndOpenApp() {
        uninstallApp();
        installApp();
        openApp();
    }
}