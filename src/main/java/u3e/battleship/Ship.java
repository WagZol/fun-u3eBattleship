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

    private List<int[]> sampleCoordinates;
    private List<int[]> actualCoordinates;
    private String symbol;

    public Ship(List<int[]> sampleCoordinates, String shipSymbol) {
        if (sampleCoordinates.size() == 0
                || sampleCoordinates.stream().anyMatch(n -> n.length != 2) 
                || shipSymbol==null
                || shipSymbol.equals(Board.getEmptyCoordinate())) {
            throw new IllegalArgumentException();
        }
        this.sampleCoordinates = sampleCoordinates;
        this.actualCoordinates = sampleCoordinates;
        this.symbol=shipSymbol;
    }

    public Ship() {
    }

    public List<int[]> getActualCoordinates() {
        return this.actualCoordinates;
    }

    public void setActualCoordinates(List<int[]> changedCoordinates) {
        this.actualCoordinates = changedCoordinates;
    }

    public Ship turnLeft() {
        actualCoordinates = sampleCoordinates;
        return this;
    }

    public Ship turnRight() {
        int[] shipSampleFirstCoordinate = sampleCoordinates.get(0);

        actualCoordinates = this.sampleCoordinates.stream()
                .map((int[] shipCoordinate) -> {
                    int[] distanceFromFirstCoordinate = new int[]{
                        abs(shipSampleFirstCoordinate[0] - shipCoordinate[0]),
                        abs(shipSampleFirstCoordinate[1] - shipCoordinate[1])
                    };
                    return new int[]{
                        shipSampleFirstCoordinate[0] - distanceFromFirstCoordinate[0],
                        shipSampleFirstCoordinate[1] - distanceFromFirstCoordinate[1]
                    };
                }).collect(Collectors.toList());
        return this;
    }

    public Ship turnUp() {
        int[] shipSampleFirstCoordinate = this.sampleCoordinates.get(0);

        actualCoordinates = this.sampleCoordinates.stream()
                .map((int[] shipCoordinate) -> {
                    int[] distanceFromFirstCoordinate = new int[]{
                        abs(shipSampleFirstCoordinate[0] - shipCoordinate[0]),
                        abs(shipSampleFirstCoordinate[1] - shipCoordinate[1])
                    };
                    return new int[]{
                        shipSampleFirstCoordinate[0] - distanceFromFirstCoordinate[1],
                        shipSampleFirstCoordinate[1] + distanceFromFirstCoordinate[0]
                    };
                }).collect(Collectors.toList());
        return this;
    }

    public Ship turnDown() {
        int[] shipSampleFirstCoordinate = this.sampleCoordinates.get(0);

        actualCoordinates = this.sampleCoordinates.stream()
                .map((int[] shipCoordinate) -> {
                    int[] distanceFromFirstCoordinate = new int[]{
                        abs(shipSampleFirstCoordinate[0] - shipCoordinate[0]),
                        abs(shipSampleFirstCoordinate[1] - shipCoordinate[1])
                    };
                    return new int[]{
                        shipSampleFirstCoordinate[0] + distanceFromFirstCoordinate[1],
                        shipSampleFirstCoordinate[1] - distanceFromFirstCoordinate[0]
                    };
                }).collect(Collectors.toList());
        return this;
    }

    public Ship shiftShipToCursor(int[] cursor) {
        int[] distance = new int[]{cursor[0] - sampleCoordinates.get(0)[0],
            cursor[1] - sampleCoordinates.get(0)[0]};
        actualCoordinates = sampleCoordinates.stream()
                .map((int[] coordinate) -> {
                    return new int[]{coordinate[0]
                        + distance[0], coordinate[1] + distance[1]};
                }).collect(Collectors.toList());
        return this;
    }
    
    public String getShipSymbol(){
        return this.symbol;
    }
}
