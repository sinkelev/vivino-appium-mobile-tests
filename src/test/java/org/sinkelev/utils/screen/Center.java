package org.sinkelev.utils.screen;

public class Center implements ICenter {

    private int x;
    private int y;

    public Center(int x, int y) {
        this.x = x / 2;
        this.y = y / 2;
    }

    @Override
    public int x() {
        return x;
    }

    @Override
    public int y() {
        return y;
    }

    @Override
    public String toString() {
        return "Center screen{" +
                "x=" + x +
                ", y=" + y +
                '}';
    }
}
