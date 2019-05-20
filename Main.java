package com.company;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        String playerName, casinoName, typeOfBet;
        int playerCredit, casinoCredit, choice, bet;
        Scanner s = new Scanner(System.in);
        System.out.print("Casino name: ");
        casinoName = s.nextLine();
        System.out.print("Casino credit: ");
        casinoCredit = s.nextInt();
        Game roulette = new Game(casinoName, casinoCredit);
        System.out.print("Player name: ");
        playerName = s.next();
        System.out.print("Player credit: ");
        playerCredit = s.nextInt();
        Player player = new Player(playerName, playerCredit);
        do {
            System.out.println("-- Welcome to " + casinoName + " --" + "\nRoulette game\n");
            System.out.println("1. Bet on numbers \n2. Bet on Odd or Even numbers \n3. Bet on color Red or Black \n0. Exit ");
            System.out.println("Choice: ");
            choice = s.nextInt();
            switch (choice){
                case 0:
                    return;
                case 1:
                    System.out.println("Number of bets: ");
                    int numberOfBets = s.nextInt();
                    for (int i=0; i < numberOfBets; i++) {
                        System.out.print("Number: ");
                        int number = s.nextInt();
                        System.out.print("Bet: ");
                        bet = s.nextInt();
                        player.addTo(number, bet);
                    }
                    if (roulette.checkNum(player)) {
                        System.out.println("You win");
                    }else {
                        System.out.println("You lose");
                    }
                    System.out.println(roulette);
                    System.out.println(player);
                    break;
                case 2:
                    System.out.print("Insert Odd or Even");
                    typeOfBet = s.next();
                    System.out.print("Insert bet: ");
                    bet= s.nextInt();
                    try {
                        if (roulette.checkOddOrEven(player, typeOfBet, bet)) {
                            System.out.println("You win " + bet * 10 + "€");
                        } else {
                            System.out.println("You lose " + bet + "€");
                        }
                    } catch (Exception e) {
                        System.out.println(e);
                    }
                    System.out.println(roulette);
                    System.out.println(player);
                    break;
                case 3:
                    System.out.print("Color admitted: \n-Red \n-Black");
                    typeOfBet = s.next();
                    System.out.print("Insert bet: ");
                    bet= s.nextInt();
                    try {
                        if (roulette.checkOddOrEven(player, typeOfBet, bet)) {
                            System.out.println("You win " + bet * 10 + "€");
                        } else {
                            System.out.println("You lose " + bet + "€");
                        }
                    } catch (Exception e) {
                        System.out.println(e);
                    }
                    System.out.println(roulette);
                    System.out.println(player);
                    break;
                default:
                    System.out.println("Wrong choice\n");
            }

        }while (true);
    }
}
