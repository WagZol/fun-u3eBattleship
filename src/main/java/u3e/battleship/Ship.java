/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package u3e.battleship;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 *
 * @author wagnerz
 */
public class Ship {
    List xCoordinates;
    List yCoordinates;
    
    public Ship(Integer[] xCoordinates, Integer[] yCoordinates){
        if (xCoordinates.length==0 || yCoordinates.length==0)
            throw new IllegalArgumentException();
        this.xCoordinates=new ArrayList<>(Arrays.asList(xCoordinates));
        this.yCoordinates=new ArrayList<>(Arrays.asList(yCoordinates));
    }
    
}
