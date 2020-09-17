package com.johnmsaylor;

public class Main {

    public static void main(String[] args) {
	    Dice dice = new Dice();
        try {
            dice.rollAll();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        Console.showDice(dice);

        try {
            dice.rollMany();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        Console.showDice(dice);

//        Console.showDice(dice);
//        dice.rollFirst();
//        Console.showDice(dice);
//        dice.rollOne(3);
//        Console.showDice(dice);



    }
}
