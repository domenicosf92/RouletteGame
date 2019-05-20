package com.company;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        Game roulette = new Game("Bingo Bellini",10000);
        Player player = new Player("Franco", 1000);

        try {
            if (roulette.checkOddOrEven(player, "Red", 300)) {
                System.out.println("You win " + 300 * 10 + "€");
            } else {
                System.out.println("You lose " + 300 + "€");
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        /*
        try {
            if (roulette.checkOddOrEven(player, "Odd", 200)) {
                System.out.println("You win " + 200 * 10 + "€");
            } else {
                System.out.println("You lose " + 200 + "€");
            }
        } catch (Exception e) {
            System.out.println(e);
        }


        System.out.println("Number of bets: ");
        int numberOfBets = s.nextInt();
        for (int i=0; i < numberOfBets; i++) {
            System.out.print("Number: ");
            int number = s.nextInt();
            System.out.print("Bet: ");
            int bet = s.nextInt();
            player.addTo(number, bet);
        }
        if (roulette.checkNum(player)) {
            System.out.println("You win");
        }else {
            System.out.println("You lose");
        }*/
        System.out.println(roulette);
        System.out.println(player);
    }
}
