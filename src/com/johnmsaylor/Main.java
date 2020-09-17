package com.johnmsaylor;

public class Main {

    public static void main(String[] args) {
	    Dice dice = new Dice();

        try {
            dice.rollAll(4);
            dice.rollFirst();
            Console.showDice(dice);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
//        Console.showDice(dice);
//        dice.rollFirst();
//        Console.showDice(dice);
//        dice.rollOne(3);
//        Console.showDice(dice);



    }
}
