package com.johnmsaylor;

import java.util.*;
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

    public void play() {
        while (true) {
            turn();
            Console.showScore(this);
            var scanner = new Scanner(System.in);
            Console.out("Another turn? Or, q to quit");
            String input = scanner.next();
            if (input.contains("q")) {
                Console.out("Thanks for playing!");
                break;
            }
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
            player.reroll(dice, Console.reRollPrompt());
            checkYahtzee(dice, player);
            Console.showDice(dice);
            int score = Score.calculateScore(dice);
            Console.out("Your score: " + score);
            score(player,score);

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

    private void score(Player player, int score) {
        int temp = gameScore.get(player);
        int newScore = temp + score;
        gameScore.put(player, newScore);
    }
}
