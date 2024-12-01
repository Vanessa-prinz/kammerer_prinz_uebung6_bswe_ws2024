package at.fh_burgenland.bswe.algo.SortAlgorithm;

import java.util.Arrays;

public class CountingSortAlgorithm extends SortAlgorithm {

    @Override
    public int[] getSortedList(int[] originalList) {
        if (originalList == null || originalList.length == 0)
            return null;
        for (int i = 0; i < originalList.length - 1; i++) {
            if (originalList[i] < 0)
                throw new IllegalArgumentException("The given original list contains a negative number. " +
                        "Counting sort algorithm can not handle negative numbers.");
        }

        int[] helperArray = new int[Arrays.stream(originalList).max().getAsInt()+1];
        for (int i = 0; i < originalList.length; i++) {
            helperArray[originalList[i]]++;
        }

        int elementCounter = 0;
        for (int i = 0; i < helperArray.length; i++) {
            elementCounter += helperArray[i];
            helperArray[i] = elementCounter;
        }

        int[] sortedArray = new int[originalList.length];
        for (int i = originalList.length-1; i >= 0; i--) {
            sortedArray[helperArray[originalList[i]] - 1] = originalList[i];
            helperArray[originalList[i]]--;
        }
        return sortedArray;
    }
}