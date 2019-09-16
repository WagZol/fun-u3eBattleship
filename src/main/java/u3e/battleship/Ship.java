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
    private List<int[]> coordinates;
    
    public Ship(List<int[]> coordinates){
        if (coordinates.size()==0 || 
                coordinates.stream().anyMatch(n->n.length!=2))
            throw new IllegalArgumentException();
        this.coordinates=coordinates;
    }

    public Ship() {}
    
    public List<int[]> getCoordinates(){
        return this.coordinates;
    }
    
    
    
}
