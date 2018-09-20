/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package blackjackgame;

import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author  emily 
 */
public class PlayersIT {

    Players instance;

    public PlayersIT() {
        instance = new Players("emily");
    }

    /**
     * Test of dropCards method, of class Players.
     */
    @Test
    public void testDropCards() {
        System.out.println("dropCards");
        instance.dropCards();
        assertEquals(0, instance.getNumCardsInHand());
    }

    /**
     * Test of getPlayerName method, of class Players.
     */
    @Test
    public void testGetPlayerName() {
        System.out.println("getPlayerName");
        String expResult = "emily";
        String result = instance.getPlayerName();
        assertEquals(expResult, result);
    }

    /**
     * Test of addCard method, of class Players.
     */
    @Test
    public void testAddCard() {
        System.out.println("addCard");
        Cards card = new Cards(Suits.Spades, 0);
        boolean expResult = true;
        boolean result = instance.addCard(card);
        assertEquals(expResult, result);

    }

    /**
     * Test of getScore method, of class Players.
     */
    @Test
    public void testGetScore() {
        System.out.println("getScore");
        Players instance = new Players("emily");

        int expResult = 0;
        int result = instance.getScore();
        assertEquals(expResult, result);
    }

}
