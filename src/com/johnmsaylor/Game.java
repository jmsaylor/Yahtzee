package com.johnmsaylor;

import java.util.ArrayList;
import java.util.List;

public class Game {
    public List<Player> players = new ArrayList<Player>();
    public Dice dice = new Dice();

    public Game() {
        int numberOfPlayers = Console.howManyPlayers();
        for (String playerName : Console.getPlayerNames(numberOfPlayers)) {
            players.add(new Player(playerName));
        }
    }

    public void turn() {
        for(Player player : players) {
            Console.readyPlayer(player);
            player.roll(dice);
            Console.showDice(dice);
            player.reroll(dice, Console.reRollPrompt());
            Console.showDice(dice);
        }
    }
}
