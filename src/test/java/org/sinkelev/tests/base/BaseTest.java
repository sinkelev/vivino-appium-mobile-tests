package org.sinkelev.tests.base;

import org.sinkelev.data.TestData;
import org.sinkelev.data.user.User;
import org.sinkelev.drivers.capability.Capability;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

public class BaseTest {

    //protected static final String APK = BaseTest.class.getClassLoader().getResource("apk/vivino.apk").getPath();
    protected static final String APK = "D:/dev/vivino-appium-mobile-tests/build/resources/test/apk/vivino.apk";


    @BeforeClass
    @Parameters({"url", "platformName", "automationName", "deviceName", "udid", "platformVersion", "appActivity"})
    public void start(String url, String platformName, String automationName, String deviceName, String udid, String platformVersion, String appActivity) {
        User user = new User();
        user.setCapability(new Capability(url, platformName, automationName, deviceName, udid, platformVersion, appActivity));
        TestData.setUser(user);
    }
}
