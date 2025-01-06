package at.fh_burgenland.bswe.algo.SortAlgorithm;

import java.util.Arrays;

/**
 * This class implements the counting sort algorithm.
 */
public class CountingSortAlgorithm extends SortAlgorithm {


    /**
     * This method implements the logic of the counting sort algorithm.
     * It trys to sort a given list.
     * @param originalList the array of integers to sort
     * @return the sorted list of integers or null if the given list is empty or null
     */
    @Override
    public int[] getSortedList(int[] originalList) {
        iterations = 0;
        if (originalList == null || originalList.length == 0)
            return null;

        if (originalList.length == 1)
            return originalList;

        for (int i = 0; i < originalList.length - 1; i++) {
            if (originalList[i] < 0)
                throw new IllegalArgumentException("The given original list contains a negative number. " +
                        "Counting sort algorithm can not handle negative numbers.");
        }

        int[] helperArray = new int[Arrays.stream(originalList).max().getAsInt()+1];
        for (int i = 0; i < originalList.length; i++) {
            helperArray[originalList[i]]++;
            iterations++;
        }

        int elementCounter = 0;
        for (int i = 0; i < helperArray.length; i++) {
            elementCounter += helperArray[i];
            helperArray[i] = elementCounter;
            iterations++;
        }

        int[] sortedArray = new int[originalList.length];
        for (int i = originalList.length-1; i >= 0; i--) {
            sortedArray[helperArray[originalList[i]] - 1] = originalList[i];
            helperArray[originalList[i]]--;
            iterations++;
        }
        return sortedArray;
    }
}