/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package blackjackgame;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

/**
 *
 * @author  emily 
 */
public class BlackJackGameFile {

    private Deck newDeck;
    private String playerName;
    private float balance;
    private float bet;
    private boolean youDone;
    private boolean dealerDone;
    private Players dealer;
    private Players you;
    boolean gameOver;
    String[] commands;
    int index;

    private Scanner sc = new Scanner(System.in);

    public BlackJackGameFile(String playerName, float balance) {

        init(playerName, balance);
    }

    private void init(String playerName, float balance) {
        gameOver = false;
        this.newDeck = new Deck();
        this.playerName = playerName;
        this.balance = balance;
        you = new Players(playerName);
        dealer = new Players("Dealer");
        you.dropCards();
        dealer.dropCards();
        youDone = false;
        dealerDone = false;
        this.bet = 0;
        index = 0;

    }

    public boolean startFileGame(String filename) {
        String data = readDataFromFile(filename);
        if (data.equals("error")) {
            return false;
        }
        commands = data.split(" ");
        
        while (this.getBalance() > 0 && !gameOver) {

            System.out.println(this.playerName + ">");
            System.out.println("Choose Option");
            System.out.println("1- Make Deal");
            System.out.println("2- End Game");
            System.out.print("Choice: ");
            switch (sc.next()) {
                case "1":
                    dealTheFileGame();
                    break;
                default:
                    gameOver = true;
                    break;

            }
        }

        System.out.println("\nThank you " + this.playerName + " for playing with us");
        System.out.println("\n*******************************************\n");
        System.out.println("          !!!! Game Ended !!!");
        System.out.println("\n*******************************************\n\n");

        System.out.println("Do you want to play again?");
        System.out.println("1- Yes");
        System.out.println("2- No");
        System.out.print("Choice: ");
        switch (sc.next()) {
            case "1":
                return true;
            default:
                return false;
        }
    }

    private String readDataFromFile(String filename) {
        String data = "error";
        try {
            BufferedReader br = new BufferedReader(new FileReader(filename));
            data = br.readLine();
        } catch (FileNotFoundException e) {
            System.out.println(e);
        } catch (IOException ex) {
            System.out.println(ex);
        }
        return data;
    }

    private void dealTheFileGame() {

        boolean blackjack = false;
        you.addCard(newDeck.getCard(commands[0]));
        you.addCard(newDeck.getCard(commands[1]));
        dealer.addCard(newDeck.getCard(commands[2]));
        dealer.addCard(newDeck.getCard(commands[3]));
        index = 4;
        dealer.print(false);
        you.print(true);

        printPlayerData();

        blackjack = this.checkIfBlackJack();

        while (!this.youDone || !this.dealerDone) {

            if (!this.youDone) {

                this.yourTurn();

            } else if (!this.dealerDone) {

                this.dealersTurn();
            }

            System.out.println();
        }

        if (!blackjack) {

            this.decideWinner();
        }

    }

    private boolean checkIfBlackJack() {

        boolean blackJack = false;

        if (you.getScore() == 21) {

            this.youDone = true;
            this.dealerDone = true;

            if (you.getScore() > dealer.getScore() || dealer.getScore() > 21) {

                System.out.println("*************");
                System.out.println("* YOU WON!! *");
                System.out.println("*************\n");

                dealer.print(true);

                System.out.println("Dealer Score: " + dealer.getScore());
                System.out.println("winning ammount is $" + ((3 * this.bet) / 2));

                this.balance = this.getBalance() + (3 * this.bet) / 2 + this.bet;
                System.out.println("Your current Balance is $" + getBalance());

                blackJack = true;
            } else {

                System.out.println("**************************************");
                System.out.println("*   It could be a blackjack for U    *");
                System.out.println("**************************************\n");
                dealer.print(true);

                System.out.println("Delaer's Score: " + dealer.getScore());
                blackJack = false;
            }
        } else if (dealer.getScore() == 21) {

            dealer.print(true);
            System.out.println("Delaer's Score: " + dealer.getScore());

            System.out.println("*****************");
            System.out.println("*   YOU LOST!!  *");
            System.out.println("*****************\n");
            System.out.println("You lose $" + this.bet);
            this.balance = getBalance() - bet;
            System.out.println("Your current Balance is $" + getBalance());
            this.dealerDone = true;
            blackJack = false;
        }

        return blackJack;
    }

    private void printPlayerData() {
        System.out.print("Your Score: " + you.getScore() + ", \t");
        System.out.print("Bet: $" + bet + ", \t");
        System.out.println("Balance: $" + getBalance() + "\n");
    }

    // Player's Play Turn
    private void yourTurn() {
        if (commands.length >= index) {
            String comand = commands[index++];
            switch (comand) {
                case "H":
                    hit();
                    break;
                case "S":
                    stay();
                    break;
                case "D":
                    doubleDown();
                    break;
            }

        } else {
            System.out.println("Choose Action!!           ");
            System.out.println("1- Hit");
            System.out.println("2- Stay");
            System.out.print("Enter Choice: ");
            String choice = sc.next();
            System.out.println();
            switch (choice) {
                case "1":
                    hit();
                    break;
                case "2":
                    stay();
                    break;
            }
        }
    }

    private void hit() {

        System.out.println("You choose Hit");
        youDone = !you.addCard(newDeck.nextCard());
        you.print(true);
        printPlayerData();

        if (you.getScore() > 21) {

            System.out.println("******************");
            System.out.println("*  YOU BUSTED!!  *");
            System.out.println("*******************");
            dealer.print(true);
            System.out.println("Delaer's Score: " + dealer.getScore());
            youDone = true;
            dealerDone = true;
        }

    }

    private void stay() {
        System.out.println("You choose to Stay");
        youDone = true;
    }

    private void dealersTurn() {

        System.out.println("**************************************");
        System.out.println("*            DEALER's TURN           *");
        System.out.println("**************************************\n");
        if (dealer.getScore() < 17) {

            dealer.print(true);
            System.out.println("Delaer's Score: " + dealer.getScore());
            System.out.println("Dealer Hits");
            if (commands.length >= index) {
                String comand = commands[index++];
                dealerDone = !dealer.addCard(newDeck.getCard(comand));
            } else {
                dealerDone = !dealer.addCard(newDeck.nextCard());
            }

            if (dealer.getScore() > 21) {

                dealer.print(true);
                System.out.println("Delaer's Score: " + dealer.getScore());
                System.out.println("********************");
                System.out.println("*  DEALER BUSTED!! *");
                System.out.println("********************\n");
                dealerDone = true;
            }
        } else {

            dealer.print(true);
            System.out.println("Delaer's Score: " + dealer.getScore());
            System.out.println("Dealer Stays\n");
            dealerDone = true;
        }
    }

    private void doubleDown() {

        if (commands.length >= index) {
            String comand = commands[index++];
            youDone = you.addCard(newDeck.getCard(comand));
        }
        this.balance = this.balance - this.bet;
        this.bet = 2 * this.bet;
        youDone = true;
        you.print(true);

        printPlayerData();

        if (you.getScore() > 21) {

            System.out.println("******************");
            System.out.println("*  YOU BUSTED!!  *");
            System.out.println("*******************");
            dealer.print(true);
            System.out.println("Delaer's Score: " + dealer.getScore());
            youDone = true;
            dealerDone = true;
        }

        System.out.println(" Dealer's turn \n");
    }

    private void decideWinner() {

        int youSum = you.getScore();
        int dealerSum = dealer.getScore();

        if (youSum > dealerSum && youSum <= 21 || dealerSum > 21) {

            System.out.println("*************");
            System.out.println("* YOU WON!! *");
            System.out.println("*************\n");
            System.out.println("Dealer Score: " + dealer.getScore());
            System.out.println("winning ammount is $" + this.bet);

            this.balance = this.getBalance() + this.bet + this.bet;
            System.out.println("Your current Balance is $" + getBalance());

        } else if (youSum == dealerSum) {

            System.out.println("*********");
            System.out.println("*  TIE  *");
            System.out.println("*********\n");
            this.balance = this.getBalance() + this.bet;
            System.out.printf("Your Current Balance:$%.1f\n", this.getBalance());
        } else {

            System.out.println("*****************");
            System.out.println("*   YOU LOST!!  *");
            System.out.println("*****************\n");
            System.out.println("You lose $" + this.bet);
            System.out.println("Your current Balance is $" + getBalance());
        }
    }

    /**
     * @return the balance
     */
    public float getBalance() {
        return balance;
    }
}
