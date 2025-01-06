package at.fh_burgenland.bswe.algo.SortAlgorithm;

/**
 * This class implements the insertion sort algorithm.
 */
public class InsertionSortAlgorithm extends SortAlgorithm {

    /**
     * This method implements the logic of the insertion sort algorithm.
     * It trys to sort a given list.
     * @param originalList the array of integers to sort
     * @return the sorted list of integers or null if the given list is empty or null
     */
    @Override
    public int[] getSortedList(int[] originalList) {
        if (originalList == null || originalList.length == 0) {
            return null;
        }

        int[] sortedList = originalList.clone();
        iterations = 0;

        for (int i = 1; i < sortedList.length; i++) {
            int key = sortedList[i];
            int j = i - 1;

            while (j >= 0 && sortedList[j] > key) {
                sortedList[j + 1] = sortedList[j];
                j = j - 1;
            }

            sortedList[j + 1] = key;
            iterations++;
        }


        return sortedList;
    }
}