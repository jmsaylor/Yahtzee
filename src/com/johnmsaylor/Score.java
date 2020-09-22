package com.johnmsaylor;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

public class Score {

    public static void checkScore(Dice dice) {
        System.out.println(getTally(dice));
    }

    private static HashMap<Integer, Integer> getTally(Dice dice) {
        HashMap<Integer, Integer> tally = new HashMap<>();
        List<Integer> values = Arrays.stream(dice.dice).map(di -> di.value).collect(Collectors.toList());
        for (int i = 1; i <= 6; i++) {
            tally.put(i, 0);
        }
        for (int value : values) {
            int temp = tally.get(value);
            temp++;
            tally.put(value, temp);
        }
        return tally;
    }


    private boolean isThreeOfAKind(List<Integer> values) {
        return false;
    }
}
