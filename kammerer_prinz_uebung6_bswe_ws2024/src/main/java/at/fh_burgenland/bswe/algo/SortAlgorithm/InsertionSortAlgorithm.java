package at.fh_burgenland.bswe.algo.SortAlgorithm;

public class InsertionSortAlgorithm extends SortAlgorithm {

    @Override
    public int[] getSortedList(int[] originalList) {
        if (originalList == null || originalList.length == 0) {
            return null;
        }

        for (int i = 1; i < originalList.length; i++) {
            int key = originalList[i];
            int j = i - 1;

            while (j >= 0 && originalList[j] > key) { //Elemente die größer als key sind, werden um eine Position nach rechts verschoben
                originalList[j + 1] = originalList[j];
                j = j - 1;
            }

            originalList[j + 1] = key; //key an richtige Stelle setzen
        }

        return originalList;
    }
}