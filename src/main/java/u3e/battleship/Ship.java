/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package u3e.battleship;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import static java.lang.Math.abs;
import java.util.stream.Collectors;

/**
 *
 * @author wagnerz
 */
public class Ship {

    private List<int[]> coordinates;
    private String symbol;

    public Ship(List<int[]> coordinates, String shipSymbol) {
        if (coordinates.size() == 0
                || coordinates.stream().anyMatch(n -> n.length != 2)
                || shipSymbol == null
                || shipSymbol.equals(Board.getEmptyCoordinate())) {
            throw new IllegalArgumentException();
        }
        this.coordinates = coordinates;
        this.symbol = shipSymbol;
    }

    public Ship() {
    }

    public List<int[]> getCoordinates() {
        return this.coordinates;
    }

    public void setCoordinates(List<int[]> changedCoordinates) {
        this.coordinates = changedCoordinates;
    }

    public Ship turnLeft() {
        return new Ship(this.coordinates, this.symbol);
    }

    public Ship turnRight() {
        int[] shipFirstCoordinate = coordinates.get(0);
        List<int[]> turnedCoordinates;
        turnedCoordinates = this.coordinates.stream()
                .map((int[] shipCoordinate) -> {
                    int[] distanceFromFirstCoordinate = new int[]{
                        abs(shipFirstCoordinate[0] - shipCoordinate[0]),
                        abs(shipFirstCoordinate[1] - shipCoordinate[1])
                    };
                    return new int[]{
                        shipFirstCoordinate[0] - distanceFromFirstCoordinate[0],
                        shipFirstCoordinate[1] - distanceFromFirstCoordinate[1]
                    };
                }).collect(Collectors.toList());
        return new Ship(turnedCoordinates, this.symbol);
    }

    public Ship turnUp() {
        int[] shipFirstCoordinate = coordinates.get(0);
        List<int[]> turnedCoordinates;
        turnedCoordinates = this.coordinates.stream()
                .map((int[] shipCoordinate) -> {
                    int[] distanceFromFirstCoordinate = new int[]{
                        abs(shipFirstCoordinate[0] - shipCoordinate[0]),
                        abs(shipFirstCoordinate[1] - shipCoordinate[1])
                    };
                    return new int[]{
                        shipFirstCoordinate[0] - distanceFromFirstCoordinate[1],
                        shipFirstCoordinate[1] + distanceFromFirstCoordinate[0]
                    };
                }).collect(Collectors.toList());
        return new Ship(turnedCoordinates, this.symbol);
    }

    public Ship turnDown() {
        int[] shipFirstCoordinate = coordinates.get(0);
        List<int[]> turnedCoordinates;
        turnedCoordinates = this.coordinates.stream()
                .map((int[] shipCoordinate) -> {
                    int[] distanceFromFirstCoordinate = new int[]{
                        abs(shipFirstCoordinate[0] - shipCoordinate[0]),
                        abs(shipFirstCoordinate[1] - shipCoordinate[1])
                    };
                    return new int[]{
                        shipFirstCoordinate[0] + distanceFromFirstCoordinate[1],
                        shipFirstCoordinate[1] - distanceFromFirstCoordinate[0]
                    };
                }).collect(Collectors.toList());
        return new Ship(turnedCoordinates, this.symbol);
    }

    public Ship shiftShipToCursor(int[] cursor) {
        int[] distance = new int[]{cursor[0] - coordinates.get(0)[0],
            cursor[1] - coordinates.get(0)[0]};
        List<int[]> shiftedCoordinates;
        shiftedCoordinates = coordinates.stream()
                .map((int[] coordinate) -> {
                    return new int[]{coordinate[0]
                        + distance[0], coordinate[1] + distance[1]};
                }).collect(Collectors.toList());
        return new Ship(shiftedCoordinates, this.symbol);
    }
    
    public String getShipSymbol(){
        return this.symbol;
    }
    
}
