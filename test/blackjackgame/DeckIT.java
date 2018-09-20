/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package blackjackgame;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author  emily 
 */
public class DeckIT {
    
    public DeckIT() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of getCard method, of class Deck.
     */
    @Test
    public void test52CardsInDeck(){
        Deck instance = new Deck();
        assertEquals(52, instance.getTotalCards());
        
    }
    /**
     * Test of getCard method, of class Deck.
     */
    @Test
    public void testGetCard() {
        System.out.println("getCard");
        String code = "SA";
        Deck instance = new Deck();
        Cards expResult = new Cards(Suits.Spades, 1);
        Cards result = instance.getCard(code);
        assertEquals(expResult.getCardNumber(), result.getCardNumber());
    }
 /**
     * Test of getCard method, of class Deck.
     */
    @Test
    public void testShuffleCard()
    {
        Deck instance = new Deck();
        Cards[] beforeShuffle=instance.getDeckCards();
        instance.shuffle();
         Cards[] afterShuffle=instance.getDeckCards();
         assertArrayEquals(beforeShuffle, afterShuffle);
        assertEquals(beforeShuffle.length, afterShuffle.length);
    }
    /**
     * Test of nextCard method, of class Deck.
     */
    @Test
    public void testNextCard() {
        System.out.println("nextCard");
        Deck instance = new Deck();
        Cards expResult = new Cards(Suits.Spades, 12);
        int size=instance.getTotalCards()-1;
        Cards c=instance.nextCard();
        assertEquals(size, instance.getTotalCards());
    }
    
}
