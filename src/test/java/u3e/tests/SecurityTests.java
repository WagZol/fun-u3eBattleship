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
        assertThrows(
            IllegalArgumentException.class,
            () -> {
                new AI(null);
                new Human(null);
                new Board(0, 0);
            },
            "Null parameters or 0 not allowed in constructor!"
        );
    }
}
