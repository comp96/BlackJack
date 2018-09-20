/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TestCases;

import blackjackgame.BlackJackGameFile;

/**
 *
 * @author emily
 */
public class testDealerMustHit {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        BlackJackGameFile game1;
        game1 = new BlackJackGameFile("emily", 200 );
        game1.startFileGame("data1.txt");
    }
    
}
