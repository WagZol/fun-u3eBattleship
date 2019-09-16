/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package u3e.battleship;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 *
 * @author Zoltán
 */
public class Board {

    private String[][] battleField;
    private int width;
    private int height;
    private final String EMPTY_COORDINATE = " ";

    public Board(int width, int height) {
        if (width == 0 || height == 0) {
            throw new IllegalArgumentException();
        }
        this.height = height;
        this.width = width;
        this.battleField = new String[width][height];
    }

    public Board(String[][] battleField) {
        if (battleField == null || battleField.length == 0
                || battleField[0].length == 0) {
            throw new IllegalArgumentException();
        }
        this.battleField = battleField;
        this.width = battleField.length;
        this.height = battleField[0].length;
    }

    public boolean isShipNotMacthingToBoard(Ship shipToCheck) {
        return shipToCheck.getCoordinates().stream()
                .anyMatch((int[] n) -> n[0] < 0 || n[0] > this.height
                || n[1] < 0 || n[1] > this.width);
    }

    public boolean isShipCollosingWithOtherShips(Ship shipToCheck) {
        return !(getShipCoordinateWithAura(shipToCheck).stream()
                .allMatch((int[] n) -> {
                    return this.battleField[n[0]][n[1]].equals(EMPTY_COORDINATE);
                }));
    }

    private List<int[]> getShipCoordinateWithAura(Ship originalShip) {
        List coordinatesWithAura = new ArrayList<>();
        coordinatesWithAura.addAll(originalShip.getCoordinates());

        originalShip.getCoordinates().stream().forEach((int[] n) -> {
            for (int diffXIndex = -1; diffXIndex <= 1; diffXIndex++) {
                for (int diffYIndex = -1; diffYIndex <= 1; diffYIndex++) {
                    int[] possibleAuraCoordinate = new int[]{n[0] + diffXIndex,
                        n[1] + diffYIndex};

                    if (!(isCoordinateInList(possibleAuraCoordinate,
                             coordinatesWithAura))
                            && auraCoordinateIsInBoard(possibleAuraCoordinate)) {
                        coordinatesWithAura.add(possibleAuraCoordinate);
                    }
                }
            }
        });
        return coordinatesWithAura;
    }

    private boolean auraCoordinateIsInBoard(int[] coordinate) {
        return coordinate[0] >= 0 && coordinate[0] < this.width
                && coordinate[1] >= 0 && coordinate[1] < this.height;
    }

    private boolean isCoordinateInList(int[] coordinateToTest,
            List<int[]> coordinateList) {
        return coordinateList.stream().anyMatch((int[] coordinate) -> {
            return Arrays.equals(coordinate, (int[])coordinateToTest);
        });
    }

    public String toString() {
        String battlefieldString = "";
        Arrays.asList(battleField).stream().forEach((String[] coordinateRaw) -> {
            Arrays.asList(coordinateRaw).stream().forEach((String coordinate) -> {
                battlefieldString.concat(coordinate);
            });
            battlefieldString.concat("\n");
        });
        return battlefieldString;
    }
}
