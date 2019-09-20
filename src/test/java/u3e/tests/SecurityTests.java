/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package u3e.tests;

import java.util.ArrayList;
import static org.junit.jupiter.api.Assertions.assertThrows;
import org.junit.jupiter.api.Test;
import u3e.battleship.AI;
import u3e.battleship.Board;
import u3e.battleship.Human;
import u3e.battleship.Ship;

/**
 *
 * @author Zoltán
 */
public class SecurityTests {
    
    @Test
    public void nullConstructorTest() {
        assertThrows(IllegalArgumentException.class,
                ()->new AI(null),
                "Null board parameter not allowed in AI constructor");
        assertThrows(IllegalArgumentException.class,
                ()->new Human(null),
                "Null board parameter is not allowed in Human constructor");
        assertThrows(IllegalArgumentException.class,
                ()->new Board(0, 0),
                "0 size parameters not allowed in Board parameter");
        assertThrows(IllegalArgumentException.class,
                ()->new Ship(new ArrayList<>(), "x"),
                "Ships must have 1 coordinate");
        assertThrows(IllegalArgumentException.class,
                ()->new Ship(new ArrayList<>(), null),
                "Ships must have 1 coordinate");
        assertThrows(IllegalArgumentException.class,
                ()->new Ship(new ArrayList<>(), " "),
                "Ships must have 1 coordinate");
        assertThrows(IllegalArgumentException.class,
                ()->new Board(null),
                "Custom board in Board constructor cannot be null");
        assertThrows(IllegalArgumentException.class,
                ()->new Board(new String[0][0]),
                "Custom board in Board constructor cannot be empty");
    }
    
    @Test
    public void shipCoorectCoordinateFormatTest() {
        assertThrows(IllegalArgumentException.class,
                ()->{ArrayList<int[]> wrongCoordinates=new ArrayList<>();
                     wrongCoordinates.add(new int[3]);
                     new Ship(wrongCoordinates, "x"); 
                },
                "Ships must have only x and y coordinates");
    }
    
}
