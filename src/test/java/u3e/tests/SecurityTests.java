/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package u3e.tests;

import static org.junit.jupiter.api.Assertions.assertThrows;
import org.junit.jupiter.api.Test;
import u3e.battleship.AI;
import u3e.battleship.Board;
import u3e.battleship.Human;

/**
 *
 * @author Zoltán
 */
public class SecurityTests {
    
    @Test
    public void nullConstructorTest() {
        assertThrows(IllegalArgumentException.class,
                ()->new AI(null),
                "Null parameter not allowed in AI constructor");
        assertThrows(IllegalArgumentException.class,
                ()->new Human(null),
                "Null parameter is not allowed in Human constructor");
        assertThrows(IllegalArgumentException.class,
                ()->new Board(0, 0),
                "0 size parameterz not allowed in Board parameter");
    }
}
