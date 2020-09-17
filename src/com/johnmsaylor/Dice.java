package com.johnmsaylor;


import java.util.concurrent.TimeUnit;

public class Dice {
    public Di[] dice = new Di[5];

    public Dice() {
        for (int i = 0; i < 5; i++) {
            dice[i] = new Di();
        }
    }

    public void rollAll() throws InterruptedException {
        for (Di di : dice) {
            TimeUnit.MILLISECONDS.sleep((long) (Math.random() * 100));
            di.roll();
        }
    }

    public void rollAll(int repeat) throws InterruptedException {
        for (int i = 0; i < repeat; i++) {
            this.rollAll();
            Console.showDice(this);
        }
    }

    public void rollFirst() {
        dice[0].roll();
    }

    public void rollOne(int di) {
        di--;
        dice[di].roll();
    }

    public void rollMany() throws InterruptedException {
        int[] which = Console.reRollPrompt();
        for (int di : which) {
            TimeUnit.MILLISECONDS.sleep((long) (Math.random() * 100));
            this.dice[di - 1].roll();
        }
    }

}
