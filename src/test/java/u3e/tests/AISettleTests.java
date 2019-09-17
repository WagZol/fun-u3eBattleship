/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package u3e.tests;

import java.util.ArrayList;
import java.util.Arrays;
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
    public void noMoreSpaceForShipToSettle() {
        Board standardBoard = new Board(1, 1);
        assertTrue("AI cannot settle ships out of Board",
                standardBoard.isShipNotMacthingToBoard(new Ship(
                        new ArrayList<>(Arrays.asList(new int[]{1, 1}, new int[]{1, 2})))));
        assertFalse("Ship is fit in the Board",
                standardBoard.isShipNotMacthingToBoard(new Ship(
                        new ArrayList<>(Arrays.asList(new int[]{1, 1})))));
    }

    @Test
    public void shipCollosionWithOtherShip() {
        Board standardBoard = new Board(new String[][]{{"A1", "A1"}, {" ", " "}});
        System.out.println(standardBoard);
        assertTrue("AI cannot settle ships if other ship in its way",
                standardBoard.isShipCollosingWithOtherShips(new Ship(
                        new ArrayList<>(Arrays
                                .asList(new int[]{1, 0}, new int[]{1, 1})))));

        standardBoard = new Board(new String[][]{{"A1", "A1", " "},
        {" ", " ", " "}, {" ", " ", " "}});
        assertFalse("Ship is fit if there is enough space for itself and "
                + "the one coordinate wide aura",
                standardBoard.isShipCollosingWithOtherShips(new Ship(
                        new ArrayList<>(Arrays
                                .asList(new int[]{2, 0}, new int[]{2, 1})))));
    }

    @Test
    public void rotateShip() {
        Ship testShip = new Ship(new ArrayList<>(Arrays
                .asList(new int[]{0, 0}, new int[]{0, 1}, new int[]{0, 2})));
        testShip.turnDown().stream().forEach((int[] coordinate) -> {
            System.out.println(coordinate[0] + ", " + coordinate[1]);
        });
        assertTrue(Arrays.equals(testShip.turnDown().get(0), new int[]{0, 0}));
        assertTrue(Arrays.equals(testShip.turnDown().get(1), new int[]{1, 0}));
        assertTrue(Arrays.equals(testShip.turnDown().get(2), new int[]{2, 0}));
        
        assertTrue(Arrays.equals(testShip.turnUp().get(0), new int[]{0, 0}));
        assertTrue(Arrays.equals(testShip.turnUp().get(1), new int[]{-1, 0}));
        assertTrue(Arrays.equals(testShip.turnUp().get(2), new int[]{-2, 0}));
        
        assertTrue(Arrays.equals(testShip.turnRight().get(0), new int[]{0, 0}));
        assertTrue(Arrays.equals(testShip.turnRight().get(1), new int[]{0,-1}));
        assertTrue(Arrays.equals(testShip.turnRight().get(2), new int[]{0,-2}));
        
        assertTrue(Arrays.equals(testShip.turnLeft().get(0), new int[]{0, 0}));
        assertTrue(Arrays.equals(testShip.turnLeft().get(1), new int[]{0, 1}));
        assertTrue(Arrays.equals(testShip.turnLeft().get(2), new int[]{0, 2}));
    }

}
