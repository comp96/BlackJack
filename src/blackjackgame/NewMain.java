/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package blackjackgame;

import java.awt.AWTException;
import java.awt.Robot;
import java.util.Scanner;

/**
 *
 * @author  emily 
 */
public class NewMain {

    private static void clearScreen() {
        try {
            Robot pressbot = new Robot();
            pressbot.keyPress(17); // Holds CTRL key.
            pressbot.keyPress(76); // Holds L key.
            pressbot.keyRelease(17); // Releases CTRL key.
            pressbot.keyRelease(76); // Releases L key.

        } catch (AWTException ex) {

        }
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        boolean playing = true;
        String filename = "data2.txt";
        BlackJackGame game;
        BlackJackGameFile game1;
        
        
        Scanner in = new Scanner(System.in);
        System.out.print("Enter your Name: ");
        String playerName = in.next().toUpperCase();
        System.out.print("\nEnter Your initial balance: $");
        float balance = in.nextFloat();

        while (playing) {
            System.out.println("\nEnter new Game input type");
            System.out.println("1- File Input");
            System.out.println("2- Console Input");
            System.out.print("Choice: ");
            switch (in.next()) {
                case "1":
                    clearScreen();
                    game1 = new BlackJackGameFile(playerName, balance);
                    playing = game1.startFileGame(filename);
                    balance = game1.getBalance();
                    clearScreen();
                    break;
                case "2":
                    clearScreen();
                    game = new BlackJackGame(playerName, balance);
                    playing = game.startConsoleGame();
                    balance = game.getBalance();
                    clearScreen();

                    break;
            }
        }
    }

}
