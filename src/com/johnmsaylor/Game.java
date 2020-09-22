package com.johnmsaylor;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

public class Game {
    public List<Player> players = new ArrayList<>();
    public Dice dice = new Dice();
    public Player winner;
    public HashMap<Player, Integer> gameScore = new HashMap<>();

    public Game() {
        int numberOfPlayers = Console.howManyPlayers();
        for (String playerName : Console.getPlayerNames(numberOfPlayers)) {
            var newPlayer = new Player(playerName);
            players.add(newPlayer);
            gameScore.put(newPlayer, 0);
        }
    }

    public void turn() {
        for(Player player : players) {
            Console.readyPlayer(player);
            player.roll(dice);
            checkYahtzee(dice, player);
            Console.showDice(dice);
            player.reroll(dice, Console.reRollPrompt());
            checkYahtzee(dice, player);
            Console.showDice(dice);
            score(dice,player);
        }
    }

    public boolean checkYahtzee(Dice dice, Player player) {
        boolean result = true;
        int key = dice.dice[0].value;
        for (Di di : dice.dice) {
            if (di.value != key) {
                result = false;
            }
        }
        if (result) {
            setWinner(player);
            Console.yahtzee(player);
        }
        return result;
    }

    public void setWinner(Player winner) {
        this.winner = winner;
    }

    public void roll(Dice dice, Player player) {

    }

    private int score(Dice dice, Player player) {
        int total = 0;
        //how to use stream here
        List<Integer> values = Arrays.stream(dice.dice).map(di -> di.value).collect(Collectors.toList());
        System.out.println(values.getClass());
        return total;
    }
}
