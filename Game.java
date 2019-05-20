package com.company;

public class Game {
    private int [][] roulette = new int[6][7];
    private String name;
    private int counter=0;
    private int credit;
    private int spinValue;

    public Game(String name, int credit) {
        this.name = name;
        this.credit = credit;
        this.createRoulette();
    }
    private void createRoulette(){
        for (int i=0; i < this.roulette.length; i++) {
            for (int j=0; j < 7; j++) {
                this.roulette[i][j]= counter;
                this.counter ++;
                if (this.roulette[i][j]> 36) {
                    this.roulette[i][j] = -1;
                }
            }
        }
    }

    private int random(){
        this.spinValue = (int) (Math.random() * 36);
        System.out.println("Spin " + spinValue);
        return this.spinValue;
    }

    public boolean checkNum(Player player){
        for (int i=0; i< player.numbers.size(); i++) {
            this.random();
            if (player.getCredit() > player.bets.get(i)) {
                player.removeCredit(player.bets.get(i));
                this.credit += player.bets.get(i);
                if (this.spinValue == player.numbers.get(i)) {
                    player.addCredit(player.bets.get(i) * 36);
                    this.credit -= player.bets.get(i) * 36;
                    return true;
                }
            }
        }
        return false;
    }

    /*  Odd number color = Red
        Even number color = Black;
     */

    public boolean checkOddOrEven(Player player, String typeOfBet, int bet) throws Exception {
        player.removeCredit(bet);
        this.credit += bet;
        if (!typeOfBet.equalsIgnoreCase("Odd") && (!typeOfBet.equalsIgnoreCase("Even")) && (!typeOfBet.equalsIgnoreCase("Red") && !(typeOfBet.equalsIgnoreCase("Black")))) throw new Exception("Wrong insert");
        if ((typeOfBet.equalsIgnoreCase("Odd") || (typeOfBet.equalsIgnoreCase("Red"))) && (this.random() % 2 == 0)) {
            this.credit -= bet * 10;
            player.addCredit(bet * 10);
            return true;
        } else
            if ((typeOfBet.equalsIgnoreCase("Even") || (typeOfBet.equalsIgnoreCase("Black"))) && (this.random() % 2 != 0)){
                this.credit -= bet * 10;
                player.addCredit(bet * 10);
                return true;
            }
        return false;
    }

    @Override
    public String toString() {
        String s= "Game: \n\n";
        for (int i=0; i < this.roulette.length; i++) {
            for (int j = 0; j < 7; j++) {
                if (this.roulette[i][j]== -1) {
                    s += "";
                } else{
                    s += "|\t" + this.roulette[i][j] + "\t|";
                }
            }
            s+= "\n";
        }
        s+="\n--Casino-- \nName: " + this.name + "\nCredit: " + this.credit;
        return s;
    }
}
