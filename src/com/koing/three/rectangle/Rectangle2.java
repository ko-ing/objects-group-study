package com.koing.three.rectangle;

public class Rectangle2 {
    private int left;
    private int top;
    private int right;
    private int bottom;

    public Rectangle2(int left, int top, int right, int bottom) {
        this.left = left;
        this.top = top;
        this.right = right;
        this.bottom = bottom;
    }

    public void enlarge(int multiple) {
        right *= multiple;
        bottom *= multiple;
    }
}
