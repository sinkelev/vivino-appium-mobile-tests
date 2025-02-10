package org.sinkelev.drivers.capability;

import io.appium.java_client.android.options.UiAutomator2Options;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.Duration;

@Data
@AllArgsConstructor
public class Capability {

    private String url;
    private String platformName;
    private String automationName;
    private String deviceName;
    private String udid;
    private String platformVersion;
    private String appActivity;

    public UiAutomator2Options getProperty() {
        UiAutomator2Options option = new UiAutomator2Options();
        option.setCapability("enforceXPath1", true);
        option.setCapability("allowInvisibleElements", true);
        option.setCapability("ignoreUnimportantViews", false);
        option.setCapability("autoAcceptAlerts", true);
        option.setCapability("unicodeKeyboard", true);
        option.setCapability("resetKeyboard", true);
        option.setCapability("maxInstances", 1);
        return option.setPlatformName(platformName)
                .setAutomationName(automationName)
                .setAdbExecTimeout(Duration.ofSeconds(600))
                .setAndroidInstallTimeout(Duration.ofSeconds(600))
                .setDeviceName(deviceName)
                .setUdid(udid)
                .setPlatformVersion(platformVersion)
                .setEnforceAppInstall(true)
                .autoGrantPermissions()
                .setAppActivity(appActivity)
                .setNewCommandTimeout(Duration.ofSeconds(120));
    }
}
