/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package u3e.battleship;

import java.util.ArrayList;
import java.util.Random;

/**
 *
 * @author Zoltán
 */
public class AI extends Player {

    Random randomGenerator = new Random();
    private Board board;
    private int[] cursor;

    public AI(Board board) {
        super(board);
    }

    /*public void setCursor() {
        ArrayList<int[]> emptyCoordinates
                = (ArrayList<int[]>) this.board.getEmptyCoordinates();
        int randomIndex = randomGenerator.nextInt(emptyCoordinates.size());
        cursor = emptyCoordinates.get(randomIndex);
    }*/

    /*public Ship settleShip(Ship shipSample) {
        setCursor();
        Ship shiftedShip=shipSample.shiftShipToCursor(cursor);
        
    }*/
    
    //public chooseDirections()

}
