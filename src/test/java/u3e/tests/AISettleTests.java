/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package u3e.tests;

import static org.junit.Assert.*;
import org.junit.jupiter.api.Assertions;
import static org.junit.jupiter.api.Assertions.assertThrows;
import org.junit.jupiter.api.Test;
import u3e.battleship.AI;
import u3e.battleship.Board;
import u3e.battleship.Human;
import u3e.battleship.Player;
import u3e.battleship.Ship;

/**
 *
 * @author wagnerz
 */
public class AISettleTests {
    @Test
    public void NoMoreSpaceForShipToSettle(){
        Board standardBoard=new Board(1,1);
        assertTrue("AI cannot settle ships out of Board", 
                standardBoard.isShipNotMacthingToBoard(new Ship(
                new Integer[]{1,1}, new Integer[]{1,2})));
        assertFalse("Ship is fit in the Board", 
                standardBoard.isShipNotMacthingToBoard(new Ship(
                new Integer[]{1}, new Integer[]{1})));
    }
}
