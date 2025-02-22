package org.sinkelev.utils;


import org.sinkelev.utils.wait.IWait;
import org.sinkelev.utils.wait.Wait;

public class Utils {

    public static IWait getWait() {
        return new Wait();
    }

}
