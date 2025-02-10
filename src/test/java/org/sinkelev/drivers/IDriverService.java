package org.sinkelev.drivers;

import io.appium.java_client.AppiumDriver;

public interface IDriverService {

    void setDriver();

    AppiumDriver get();
}
