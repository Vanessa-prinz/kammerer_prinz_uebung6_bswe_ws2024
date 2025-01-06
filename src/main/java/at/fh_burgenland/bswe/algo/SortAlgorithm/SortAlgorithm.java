package at.fh_burgenland.bswe.algo.SortAlgorithm;

import at.fh_burgenland.bswe.algo.ListProcessor;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * This abstract class provides methods for implementing different sort algorithms and logging their results.
 */
public abstract class SortAlgorithm {

    private static final Logger logger = LogManager.getLogger(SortAlgorithm.class);

    protected int iterations;

    /**
     * This abstract method executes the sort algorithm.
     * @param list the array of integers to sort
     * @return the sorted list
     */
    public abstract int[] getSortedList(int[] list);

    /**
     * This method executed the specific sort algorithm and logs the start, execution and end time.
     * @param list the array of integers to sort
     * @return the sorted list
     */
    public int[] executeAlgorithm(int[] list) {
        if (this.getClass() == SortAlgorithm.class) { //überprüft ob Methode von SortAlgorithm aufgerufen wird
            return null;
        }
        long startTime = System.nanoTime();
        logger.info("StartTime: " + startTime);
        int[] result = this.getSortedList(list);  //der ursprüngliche execute-Aufruf
        long endTime = System.nanoTime();
        logger.info("EndTime: " + endTime);
        logger.info("Execution time: " + (endTime - startTime) + " ns");
        logger.info("Iterations: " + iterations);
        return result;
    }

    /**
     * This method runs the given sort algorithm on a specific list and prints the original and sorted list.
     * @param list the array of integers to sort
     * @param sortAlgorithm the sort algorithm to execute
     */
    public static void runSortAlgorithm(int[] list, SortAlgorithm sortAlgorithm) {
        logger.info("Sort algorithm: " + sortAlgorithm.getClass().getSimpleName());
        if (sortAlgorithm instanceof CountingSortAlgorithm && ListProcessor.hasNegativeNumbers(list)) {
            logger.warn("Counting sort algorithm can not handle negative numbers!");
            return;
        }
        try {
            int[] sortedList = sortAlgorithm.executeAlgorithm(list);
            logger.info("Original list: " + ListProcessor.getListAsString(list));
            logger.info("Sorted list: " + ListProcessor.getListAsString(sortedList));
        } catch (Exception e) {
            logger.error(e);
        }
    }
}