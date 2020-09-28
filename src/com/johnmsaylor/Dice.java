package com.johnmsaylor;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class Dice {
    public Di[] dice = new Di[5];

    public Dice() {
        for (int i = 0; i < 5; i++) {
            dice[i] = new Di();
        }
    }

    public void roll() throws InterruptedException {
        for (Di di : dice) {
            TimeUnit.MILLISECONDS.sleep((long) (Math.random() * 100));
            di.roll();

        }
    }

    public void roll(int repeat) throws InterruptedException {
        for (int i = 0; i < repeat; i++) {
            this.roll();
            Console.showDice(this);
        }
    }

    public void roll(List<Integer> which) throws InterruptedException {
        if (which.get(0) == 0) return;
        for (int di : which) {
            TimeUnit.MILLISECONDS.sleep((long) (Math.random() * 100));
            this.dice[di - 1].roll();
        }
    }

}
