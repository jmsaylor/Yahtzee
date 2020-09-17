package com.johnmsaylor;

import java.util.Scanner;

public class Console {

    public static void showDice(Dice current) {
        System.out.println("---PLAYER DICE--------------");
        System.out.print("    ");
        for (Di di: current.dice) {
            System.out.print(di.value + " ");
        }
        System.out.println();
        System.out.println("----------------------");
    }

    public static int[] reRollPrompt() {
        Scanner scanner = new Scanner(System.in);
        int howManyDi;
        int[] which;
        System.out.print("How many dice would you like to reroll? ");
        howManyDi = scanner.nextInt();
        which = new int[howManyDi];
        System.out.println();
        for (int i = 0; i < howManyDi; i++) {
            System.out.print("Which one? " + "(" + (i + 1) + "/" + howManyDi + ")");
            which[i] = scanner.nextInt();
            System.out.println();
        }
        return which;
    }
}
