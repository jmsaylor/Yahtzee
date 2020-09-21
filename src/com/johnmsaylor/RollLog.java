package com.johnmsaylor;

import java.util.ArrayList;

public class RollLog {
    public int[] log;

    public RollLog(Dice dice) {
        this.log = new int[5];
        for (int i = 0; i < 5; i++) {
            log[i] = dice.dice[i].value;
        }
    }
}
