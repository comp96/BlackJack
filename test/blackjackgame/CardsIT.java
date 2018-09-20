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
 * @author emily 
 */
public class CardsIT {
    
    public CardsIT() {
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
     * Test of getCardNumber method, of class Cards.
     */
    @Test
    public void testGetCardNumber() {
        System.out.println("getCardNumber");
        Cards instance = new Cards(Suits.Spades, 0);
        int expResult = 0;
        int result = instance.getCardNumber();
        assertEquals(expResult, result);
    }

    /**
     * Test of toString method, of class Cards.
     */
    @Test
    public void testToString() {
        System.out.println("toString");
        Cards instance=new Cards(Suits.Spades, 1);
        String expResult = "ace of " + Suits.Spades.toString();
        String result = instance.toString();
        assertEquals(expResult, result);
        
    }

    /**
     * Test of getCardType method, of class Cards.
     */
    @Test
    public void testGetCardType() {
        System.out.println("getCardType");
        Cards instance = new Cards(Suits.Spades, 1);
        int expResult = 1;
        int result = instance.getCardType();
        assertEquals(expResult, result);
    }
    
}
