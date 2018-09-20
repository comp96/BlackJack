/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TestCases;

import blackjackgame.BlackJackGame;
import blackjackgame.BlackJackGameFile;
import java.util.Scanner;

/**
 *
 * @author emily
 */
public class testSupportFileAndconsoleOption {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String playerName = "emily", filename = "data1.txt";
        float balance = 200;
        BlackJackGame game;
        BlackJackGameFile game1;
        System.out.println("\nEnter new Game input type");
        System.out.println("1- File Input");
        System.out.println("2- Console Input");
        System.out.print("Choice: ");
        switch (in.next()) {
            case "1":
                game1 = new BlackJackGameFile(playerName, balance);
                game1.startFileGame(filename);
                balance = game1.getBalance();
                break;
            case "2":
                game = new BlackJackGame(playerName, balance);
                game.startConsoleGame();
                balance = game.getBalance();

                break;
        }
    }

}
