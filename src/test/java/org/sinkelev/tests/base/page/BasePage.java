package org.sinkelev.tests.base.page;

import org.openqa.selenium.By;
import org.sinkelev.drivers.DriverService;
import org.sinkelev.utils.Utils;
import org.sinkelev.utils.wait.IWait;


import io.appium.java_client.android.AndroidDriver;

public class BasePage {
    protected IWait wait;
    protected AndroidDriver driver;

    public BasePage() {
        driver = (AndroidDriver) DriverService.instance().get();
        wait = Utils.getWait();
    }

    protected By text(String text) {
        return By.xpath("//*[@text=\"" + text + "\"]");
    }

    protected By description(String text) {
        return By.xpath("//*[@content-desc\n=\"" + text + "\"]");
    }

    public void closeSession() {
        driver.quit();
    }

    public void installAndOpenApp(String folderApp) {
        removeApp();
        installApp(folderApp);
        openApp();
    }

    private void removeApp() {
        driver.removeApp("vivino.web.app");
    }

    protected synchronized void installApp(String folderApp) {
        driver.installApp(folderApp);
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public void openApp() {
        driver.activateApp("vivino.web.app");
    }
}

