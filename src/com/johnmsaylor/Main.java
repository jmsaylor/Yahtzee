package com.johnmsaylor;

public class Main {

    public static void main(String[] args) {
//        Game game = new Game();
//        game.turn();
        var dice = new Dice();
        try {
            dice.roll();
            Score.checkScore(dice);
            dice.roll();
            Score.checkScore(dice);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }


    }
}
