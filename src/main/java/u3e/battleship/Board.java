/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package u3e.battleship;

import java.util.Collections;

/**
 *
 * @author Zoltán
 */
public class Board {

    private String[][] battleField;
    private int width;
    private int height;

    public Board(int width, int height) {
        if (width == 0 || height == 0) {
            throw new IllegalArgumentException();
        }
        this.height = height;
        this.width = width;
        this.battleField = new String[width][height];
    }

    public boolean isShipNotMacthingToBoard(Ship shipToCheck) {
        boolean shipFitVertically=shipToCheck.xCoordinates.
                stream().anyMatch(n->(Integer)(n)<0 || (Integer)(n)>this.height);
        boolean shipFitHorizontally=shipToCheck.yCoordinates.
                stream().anyMatch(n->(Integer)(n)<0 || (Integer)(n)>this.width);
        return shipFitVertically || shipFitHorizontally;
    }
}
