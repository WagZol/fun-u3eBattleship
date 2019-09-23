/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package u3e.battleship;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.function.UnaryOperator;

/**
 *
 * @author Zoltán
 */
public class AI extends Player {

    Random randomGenerator = new Random();
    List<UnaryOperator<Ship>> turns=new ArrayList<>();
    
    
    {
        turns.add(shipToTurn->shipToTurn.turnDown());
        turns.add(shipToTurn->shipToTurn.turnLeft());
        turns.add(shipToTurn->shipToTurn.turnRight());
        turns.add(shipToTurn->shipToTurn.turnUp());
    }
    
    
    public AI(Board board) {
        super(board);    
    }

    public void setCursor() {       
        ArrayList<int[]> emptyCoordinates
                = new ArrayList((ArrayList<int[]>) board.getEmptyCoordinates());
        int randomIndex = randomGenerator.nextInt(emptyCoordinates.size());
        cursor = emptyCoordinates.get(randomIndex);
        emptyCoordinates.remove(randomIndex);
    }

    public void settleShip(Ship shipSample) {
        Ship shipToSettle = null;
        do {
            setCursor();           
            Ship shiftedShip = shipSample.shiftShipToCursor(cursor);          
            shipToSettle = chooseDirection(shiftedShip);
        } while (shipToSettle == null);
        board.settleShip(shipToSettle);
        System.out.println(board);
    }

    public Ship chooseDirection(Ship shiftedShip) {
        ArrayList<Ship> allowedDirections = new ArrayList<>();
        turns.forEach((turn) -> {
            Ship turnedShip=(Ship)turn.apply(shiftedShip);
            if (board.isShipFit(turnedShip)){
                allowedDirections.add(turnedShip);
            }
        });

        int sizeOfTheAllowedDirections = allowedDirections.size();
        if (sizeOfTheAllowedDirections == 0) {
            return null;
        }
        return allowedDirections
                .get(randomGenerator.nextInt(sizeOfTheAllowedDirections));
    }

}
