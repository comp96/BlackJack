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
 * @author AhsanIslam
 */
public class BlackJackGameIT {
    
    BlackJackGame instance;
    public BlackJackGameIT() {
        instance = new BlackJackGame("emily", 200);
        instance.startConsoleGame();
    }

    
    /**
     * Test of getBalance method, of class BlackJackGame.
     */
    @Test
    public void testGetBalance() {
        System.out.println("getBalance");
        
        float expResult = 200.0F;
        float result = instance.getBalance();
        assertEquals(expResult, result, 0.0);
    }
    
}
