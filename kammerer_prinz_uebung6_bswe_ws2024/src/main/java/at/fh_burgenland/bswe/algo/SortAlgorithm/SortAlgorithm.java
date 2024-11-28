package at.fh_burgenland.bswe.algo.SortAlgorithm;

import at.fh_burgenland.bswe.algo.ListProcessor;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public abstract class SortAlgorithm {

    private static final Logger logger = LogManager.getLogger(SortAlgorithm.class);

    public abstract int[] getSortedList(int[] list);

    public int[] executeAlgorithm(int[] list) {
        if (this.getClass() == SortAlgorithm.class) { //überprüft ob Methode von SearchAlgorithm aufgerufen wird
            return null;
        }
        long startTime = System.nanoTime();
        logger.info("StartTime: " + startTime);
        int[] result = this.getSortedList(list);  //der ursprüngliche execute-Aufruf
        long endTime = System.nanoTime();
        logger.info("EndTime: " + endTime);
        logger.info("Execution time: " + (endTime - startTime) + " ns");
        return result;
    }

    public static void runSortAlgorithm(int[] list, SortAlgorithm sortAlgorithm) {
        logger.info("Sortalgorithm: " + sortAlgorithm.getClass().getSimpleName());
        if (sortAlgorithm instanceof CountingSortAlgorithm && ListProcessor.hasNegativeNumbers(list)) {
            logger.warn("Counting sort algorithm can not handle negative numbers!");
            return;
        }
        int[] sortedList = sortAlgorithm.executeAlgorithm(list);
        logger.info("Original list: " + ListProcessor.getListAsString(list));
        logger.info("Sorted list: " + ListProcessor.getListAsString(sortedList));
    }
}