package com.johnmsaylor;

import java.util.ArrayList;
import java.util.List;

public class Player {
    public String name;
    public List<RollLog> rollLog;

    public Player(String name) {
        this.name = name;
        this.rollLog = new ArrayList<>();
    }

    public void roll(Dice dice) {
        try {
            dice.roll();
            rollLog.add(new RollLog(dice));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }

    public void reroll(Dice dice, List<Integer> which) {
        try {
            dice.roll(which);
            rollLog.add(new RollLog(dice));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
