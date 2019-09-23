/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package u3e.battleship;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import u3e.utils.ListOfArrays;

/**
 *
 * @author Zoltán
 */
public class Board {

    private String[][] battleField;
    private int width;
    private int height;
    private static final String EMPTY_COORDINATE = " ";
    private List<int[]> emptyCoordinates;

    public Board(int width, int height) {
        if (width == 0 || height == 0) {
            throw new IllegalArgumentException();
        }
        this.battleField = new String[width][height];
        this.height = height;
        this.width = width;
        initEmptyCoordinates();

    }

    public Board(String[][] battleField) {
        if (battleField == null || battleField.length == 0
                || battleField[0].length == 0) {
            throw new IllegalArgumentException();
        }
        this.battleField = battleField;
        this.width = battleField.length;
        this.height = battleField[0].length;
        initEmptyCoordinates();
    }

    public static String getEmptyCoordinate() {
        return EMPTY_COORDINATE;
    }

    public List<int[]> getEmptyCoordinates() {
        return emptyCoordinates;
    }

    private List<int[]> getCoordinatesWithAura(List<int[]> coordinate) {
        List coordinatesWithAura = new ArrayList<>();
        coordinatesWithAura.addAll(coordinate);

        coordinate.stream().forEach((int[] n) -> {
            for (int diffXIndex = -1; diffXIndex <= 1; diffXIndex++) {
                for (int diffYIndex = -1; diffYIndex <= 1; diffYIndex++) {
                    int[] possibleAuraCoordinate = new int[]{n[0] + diffXIndex,
                        n[1] + diffYIndex};

                    if (!(ListOfArrays.isArrayInListOfArray(
                            possibleAuraCoordinate,
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

    private void removeCoordinatesFormList(List<int[]> coordinates,
            List<int[]> list) {
        coordinates.stream().forEach((int[] coordinate) -> {
            list.removeIf((int[] emptyCoordinate) -> {
                return Arrays.equals(emptyCoordinate, coordinate);
            });
        });
    }

    private void addCoordinatesToBoard(List<int[]> coordinates,
            String shipSymbol) {
        coordinates.stream().forEach((int[] coordinate) -> {
            battleField[coordinate[0]][coordinate[1]] = shipSymbol;
        });
    }

    public String toString() {
        String battlefieldString = "";
        for (String[] raws : battleField) {
            for (String symbol : raws) {
                battlefieldString += symbol;
            }
            battlefieldString += "\n";
        }
        return battlefieldString;
    }

    public int getHeight() {
        return this.height;
    }

    public int getWidth() {
        return this.width;
    }

    private void initEmptyCoordinates() {
        emptyCoordinates = new ArrayList<>();
        List<int[]> filledCoordinate = new ArrayList<>();

        for (int yCoordinate = 0; yCoordinate < this.height; yCoordinate++) {
            for (int xCoordinate = 0; xCoordinate < this.width; xCoordinate++) {
                if ((battleField[xCoordinate][yCoordinate] == null)
                        || (battleField[xCoordinate][yCoordinate]
                                .equals(EMPTY_COORDINATE))) {
                    emptyCoordinates.add(new int[]{xCoordinate, yCoordinate});
                    continue;
                }
                filledCoordinate.add(new int[]{xCoordinate, yCoordinate});
            };
        }
        removeCoordinatesFormList(getCoordinatesWithAura(filledCoordinate),
                emptyCoordinates);

    }

    public boolean isShipFit(Ship shipToTest) {
        return ListOfArrays.isListOfArrayInListOfArray(shipToTest
                .getCoordinates(),
                emptyCoordinates);
    }

    public boolean settleShip(Ship shipToSettle) {

        ArrayList<int[]> coordinatesOfShipToSettle
                = (ArrayList<int[]>) shipToSettle.getCoordinates();

        if (isShipFit(shipToSettle)) {
            removeCoordinatesFormList(coordinatesOfShipToSettle,
                    emptyCoordinates);
            addCoordinatesToBoard(coordinatesOfShipToSettle,
                    shipToSettle.getShipSymbol());
            return true;
        }
        return false;
    }
}
