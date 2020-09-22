package com.johnmsaylor;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

public class Score {

    public static int calculateScore(Dice dice) {
        HashMap<Integer, Integer> tally = getTally(dice);
        if (isYahtzee(tally)) {
            Console.out("YAHTZEE! YAY!!!");
            return 50;
        } else if (isLargeStraight(tally)) {
            return 40;
        } else if (isSmallStraight(tally)) {
            return 30;
        } else if (isFullHouse(tally)) {
            return 25;
        } else if (isFourOfAKind(tally)) {
            return getSumOfDice(dice);
        } else if (isThreeOfAKind(tally)) {
            return getSumOfDice(dice);
        }
        return 0;
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


    private static boolean isYahtzee(HashMap<Integer, Integer> tally) {
        boolean result = false;
        for (int number : tally.keySet()) {
            if (tally.get(number) == 5) {
                result = true;
            }
        }
        return result;
    }

    private static boolean isSmallStraight(HashMap<Integer, Integer> tally) {
        boolean result = false;
        int count = 0;
        for (int number : tally.keySet()) {
            if (tally.get(number) != 0) {
                count++;
            } else {
                count = 0;
            }
            if (count > 3) {
                result = true;
            }
        }
        return result;
    }

    private static boolean isLargeStraight(HashMap<Integer, Integer> tally) {
        boolean result = false;
        int count = 0;
        for (int number : tally.keySet()) {
            if (tally.get(number) != 0) {
                count++;
            } else {
                count = 0;
            }
            if (count > 4) {
                result = true;
            }
        }
        return result;
    }

    private static boolean isFourOfAKind(HashMap<Integer, Integer> tally) {
        boolean result = false;
        for (int number : tally.keySet()) {
            if (tally.get(number) == 4) {
                result = true;
            }
        }
        return result;
    }

    private static boolean isThreeOfAKind(HashMap<Integer, Integer> tally) {
        boolean result = false;
        for (int number : tally.keySet()) {
            if (tally.get(number) == 3) {
                result = true;
            }
        }
        return result;
    }
    private static boolean isFullHouse(HashMap<Integer, Integer> tally) {
        boolean[] result = {false, false};
        for (int number : tally.keySet()) {
            if (tally.get(number) == 3) {
                result[0] = true;
            }
            if (tally.get(number) == 2) {
                result[1] = true;
            }
        }
        return result[0] && result[1];
    }

    private static int getSumOfDice(Dice dice) {
        return Arrays.stream(dice.dice).map(di -> di.value).reduce(0, Integer::sum);
    }
}
