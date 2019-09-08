/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package u3e.battleship;

/**
 *
 * @author Zoltán
 */
public abstract class Player {
    private Board board;
    
    public Player(Board board) {
        if (board==null)
            throw new IllegalArgumentException();
        this.board=board;
    }
    
}
