package com.johnmsaylor;

public class Di {
    public int value = 1;

    public void roll() {
//  TimeUnit.MILLISECONDS.sleep((long) (Math.random() * 100));
        this.value = (int)(Math.random() * 6) + 1;

    }
}
