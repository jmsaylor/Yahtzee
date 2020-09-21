package com.johnmsaylor;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Console {

    public static int howManyPlayers() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("How many players?");
        return scanner.nextInt();
    }

    public static String[] getPlayerNames(int numberOfPlayers) {
        String[] players = new String[numberOfPlayers];
        Scanner scanner = new Scanner(System.in);

        for (int player = 0; player < numberOfPlayers; player++) {
            System.out.println("Enter player #" + (player + 1) + " name");
            players[player] = scanner.next();
        }
        return players;
    }

    public static void readyPlayer(Player player) {
        Scanner scanner = new Scanner(System.in);
        System.out.println(player.name + " Are you ready? Hit Enter to roll.");
        scanner.nextLine();
    }

    public static void gameMenu() {

    }

    public static void showDice(Dice current) {
        System.out.println("---DICE--------------");
        System.out.print("    ");
        for (Di di: current.dice) {
            System.out.print(di.value + "  ");
        }
        System.out.println();
        System.out.println("----------------------");
    }

    public static List<Integer> reRollPrompt() {
        Scanner scanner = new Scanner(System.in);
        var which = new ArrayList<Integer>();
        System.out.print("Which dice do you want to reroll? 0 for none");
        String string = scanner.next();
        for (int i = 0; i < string.length(); i++) {
            if (string.charAt(i) == ' ') continue;
            which.add(Integer.parseInt(String.valueOf(string.charAt(i))));
        }
        return which;
    }
}
