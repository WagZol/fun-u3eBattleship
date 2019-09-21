/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package u3e.utils;

import java.util.Arrays;
import java.util.List;

/**
 *
 * @author Zoltán
 */
public class ListOfArrays {

    public static  boolean isArrayInListOfArray(int[] array, List<int[]> list) {
        return list.stream().anyMatch((int[] listElement) -> {
            return Arrays.equals(listElement, array);
        });
    }

    public static boolean isListOfArrayInListOfArray(List<int[]> partList,
            List<int[]> containerList) {
        return partList.stream().allMatch((int[] listElement) -> {
            return isArrayInListOfArray(listElement, containerList);
        });
    }

}
