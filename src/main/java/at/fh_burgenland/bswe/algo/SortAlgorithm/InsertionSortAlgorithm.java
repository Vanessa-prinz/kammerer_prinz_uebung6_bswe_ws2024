package at.fh_burgenland.bswe.algo.SortAlgorithm;

public class InsertionSortAlgorithm extends SortAlgorithm {

    @Override
    public int[] getSortedList(int[] originalList) {
        if (originalList == null || originalList.length == 0) {
            return null;
        }

        int[] sortedList = originalList.clone();

        for (int i = 1; i < sortedList.length; i++) {
            int key = sortedList[i];
            int j = i - 1;

            while (j >= 0 && sortedList[j] > key) { //Elemente die größer als key sind, werden um eine Position nach rechts verschoben
                sortedList[j + 1] = sortedList[j];
                j = j - 1;
            }

            sortedList[j + 1] = key; //key an richtige Stelle setzen
        }

        return sortedList;
    }
}