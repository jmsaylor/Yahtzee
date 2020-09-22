package com.johnmsaylor;

import java.util.ArrayList;
import java.util.List;

public class Player {
    public String name;

    public Player(String name) {
        this.name = name;
    }

    public void roll(Dice dice) {
        try {
            dice.roll();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }

    public void reroll(Dice dice, List<Integer> which) {
        try {
            dice.roll(which);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
