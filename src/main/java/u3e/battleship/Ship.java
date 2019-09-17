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

    public Ship(List<int[]> coordinates) {
        if (coordinates.size() == 0
                || coordinates.stream().anyMatch(n -> n.length != 2)) {
            throw new IllegalArgumentException();
        }
        this.coordinates = coordinates;
    }

    public Ship() {
    }

    public List<int[]> getCoordinates() {
        return this.coordinates;
    }

    public void setCoordinates(List<int[]> changedCoordinates) {
        this.coordinates = changedCoordinates;
    }

    public List<int[]> turnLeft() {
        return this.coordinates;
    }

    public List<int[]> turnRight() {
        int[] shipSampleFirstCoordinate=this.getCoordinates().get(0);
        
        return this.coordinates.stream().map((int[] shipCoordinate) -> {
            int[] distanceFromFirstCoordinate = new int[]{
                abs(shipSampleFirstCoordinate[0] - shipCoordinate[0]),
                abs(shipSampleFirstCoordinate[1] - shipCoordinate[1])
            };
            return new int[]{
                shipSampleFirstCoordinate[0] - distanceFromFirstCoordinate[0],
                shipSampleFirstCoordinate[1] - distanceFromFirstCoordinate[1]
            };
        }).collect(Collectors.toList());
    }
    
    public List<int[]> turnUp() {
        int[] shipSampleFirstCoordinate=this.getCoordinates().get(0);
        
        return this.coordinates.stream().map((int[] shipCoordinate) -> {
            int[] distanceFromFirstCoordinate = new int[]{
                abs(shipSampleFirstCoordinate[0] - shipCoordinate[0]),
                abs(shipSampleFirstCoordinate[1] - shipCoordinate[1])
            };
            return new int[]{
                shipSampleFirstCoordinate[0] - distanceFromFirstCoordinate[1],
                shipSampleFirstCoordinate[1] + distanceFromFirstCoordinate[0]
            };
        }).collect(Collectors.toList());
    }

    public List<int[]> turnDown() {
        int[] shipSampleFirstCoordinate=this.getCoordinates().get(0);
        
        return this.coordinates.stream().map((int[] shipCoordinate) -> {
            int[] distanceFromFirstCoordinate = new int[]{
                abs(shipSampleFirstCoordinate[0] - shipCoordinate[0]),
                abs(shipSampleFirstCoordinate[1] - shipCoordinate[1])
            };
            return new int[]{
                shipSampleFirstCoordinate[0] + distanceFromFirstCoordinate[1],
                shipSampleFirstCoordinate[1] - distanceFromFirstCoordinate[0]
            };
        }).collect(Collectors.toList());
    }
}
