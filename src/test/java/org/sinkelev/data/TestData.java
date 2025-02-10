package org.sinkelev.data;

import org.sinkelev.data.user.User;

public class TestData {

    private static final ThreadLocal<User> STORAGE = new ThreadLocal<>();

    public static void setUser(User data) {
        STORAGE.set(data);
    }

    public static User getUser() {
        return STORAGE.get();
    }
}
