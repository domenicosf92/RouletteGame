package com.company;

public class Game {
    private int [][] roulette = new int[6][7];
    private int [] red = new int[]  {1,3,5,7,9,12,14,16,18,19,21,23,25,27,30,32,34,36};
    private int [] black = new int[]{2,4,6,8,10,11,13,15,17,20,22,24,26,28,29,31,33,35};
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

    public boolean checkOddOrEven(Player player, String typeOfBet, int bet) throws Exception {
        player.removeCredit(bet);
        this.credit += bet;
        if (!typeOfBet.equalsIgnoreCase("Odd") && (!typeOfBet.equalsIgnoreCase("Even"))) throw new Exception("Wrong insert");
        if (typeOfBet.equalsIgnoreCase("Odd") && (this.random() % 2 == 0)) {
            this.credit -= bet * 10;
            player.addCredit(bet * 10);
            return true;
        } else
            if (typeOfBet.equalsIgnoreCase("Even")  && (this.random() % 2 != 0)){
                this.credit -= bet * 10;
                player.addCredit(bet * 10);
                return true;
            }
        return false;
    }

    public boolean checkByColor(Player player, String color, int bet) throws Exception {
        player.removeCredit(bet);
        this.credit += bet;
        int extractedNumber= this.random();
        if (!color.equalsIgnoreCase("Red") && (!color.equalsIgnoreCase("Black"))) throw new Exception("Wrong insert");
        for (int i=0; i< this.red.length; i++){
            if (color.equalsIgnoreCase("Red") && (this.red[i] == extractedNumber)){
                this.credit -= bet * 9;
                player.addCredit(bet * 9);
                return true;
            }
            if (color.equalsIgnoreCase("Black") && (this.black[i] == extractedNumber)){
                this.credit -= bet * 9;
                player.addCredit(bet * 9);
                return true;
            }
        }
        return false;
    }

    @Override
    public String toString() {
        String s= "Game roulette: \n-R: RED\n-B: BLACK\n-G: GREEN\n\n";
        for (int i=0; i < this.roulette.length; i++) {
            for (int j = 0; j < 7; j++) {
                if (this.roulette[i][j]<10 && (this.roulette[i][j]== 1 || this.roulette[i][j]== 3 || this.roulette[i][j]== 5 || this.roulette[i][j]== 7 || this.roulette[i][j] == 9)){
                    s += "|\t " + this.roulette[i][j] + ": R\t|";
                } else if (this.roulette[i][j]<10 && (this.roulette[i][j]== 2 || this.roulette[i][j]== 4 || this.roulette[i][j]== 6 || this.roulette[i][j]== 8)){
                    s += "|\t " + this.roulette[i][j] + ": B\t|";
                } else if (this.roulette[i][j]== -1) {
                    s += "";
                } else if (this.roulette[i][j] == 12 || this.roulette[i][j] == 14 || this.roulette[i][j] == 16 || this.roulette[i][j] == 18 || this.roulette[i][j] == 19 || this.roulette[i][j] == 21 || this.roulette[i][j] == 23 ||
                        this.roulette[i][j] == 25 || this.roulette[i][j] == 27 || this.roulette[i][j] == 30 || this.roulette[i][j] == 32 || this.roulette[i][j] == 34 || this.roulette[i][j] == 36){
                    s+= "|\t" + this.roulette[i][j] + ": R\t|";
                } else if (this.roulette[i][j] == 10 || this.roulette[i][j] == 11 || this.roulette[i][j] == 13 || this.roulette[i][j] == 15 || this.roulette[i][j] == 17 || this.roulette[i][j] == 20 || this.roulette[i][j] == 22 || this.roulette[i][j] == 24 ||
                        this.roulette[i][j] == 26 || this.roulette[i][j] == 28 || this.roulette[i][j] == 29 || this.roulette[i][j] == 31 || this.roulette[i][j] == 33 || this.roulette[i][j] == 35 || this.roulette[i][j] == 37) {
                    s += "|\t" + this.roulette[i][j] + ": B\t|";
                } else {
                    s += "|\t " + this.roulette[i][j] + ": G\t|";
                }
            }
            s+= "\n";
        }
        s+="\n--Casino-- \nName: " + this.name + "\nCredit: " + this.credit;
        return s;
    }
}
