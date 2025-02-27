package org.sinkelev.utils.screenshot;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.io.FileHandler;
import org.sinkelev.drivers.DriverService;

import java.io.File;
import java.io.IOException;

public class Screenshot implements IScreenshot {

    @Override
    public void make(String name) {
        File scrFile = ((TakesScreenshot) DriverService.instance().get()).getScreenshotAs(OutputType.FILE);
        try {
            FileHandler.copy(scrFile, new File("./" + name + ".png"));
        } catch (IOException ex) {
            throw new RuntimeException(ex);
        }
    }
}