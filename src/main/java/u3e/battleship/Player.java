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
    protected Board board;
    protected int[] cursor;

    public Player(Board board) {
        
        if (board == null) {
            throw new IllegalArgumentException();
        }
        this.board = board;
    }
    
    public int[] getCursor(){
        return cursor;
    }
    
    public abstract void settleShip(Ship shipSample);
}
