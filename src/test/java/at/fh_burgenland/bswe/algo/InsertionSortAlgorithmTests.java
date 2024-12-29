package at.fh_burgenland.bswe.algo;

import at.fh_burgenland.bswe.algo.SortAlgorithm.InsertionSortAlgorithm;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

/**
 * This class contains unit tests for the insertion sort algorithm.
 */
public class InsertionSortAlgorithmTests {

    /**
     * This test method checks if the sort algorithm handles empty arrays as expected.
     * Checks if it is returning null when given an empty array.
     */
    @Test
    public void executeTest_EmptyList() {
        Assertions.assertNull(new InsertionSortAlgorithm().getSortedList(new int[0]));
    }

    /**
     * This test method checks if the sort algorithm handles a single-element array as expected.
     * Checks if it is returning the same array, as it is already sorted.
     */
    @Test
    public void executeTest_OneElement() {
        Assertions.assertTrue(Arrays.equals(
                TestData.getListSingleElement(),
                new InsertionSortAlgorithm().getSortedList(TestData.getListSingleElement())));
    }

    /**
     * This test method checks if the sort algorithm handles an already sorted long list as expected.
     * Checks if it is returning the same array, as it is already sorted.
     */
    @Test
    public void executeTest_alreadySortedLongList() {
        Assertions.assertTrue(Arrays.equals(
                TestData.getListSortedLong(),
                new InsertionSortAlgorithm().getSortedList(TestData.getListSortedLong())));
    }

    /**
     * This test method checks if the sort algorithm handles an already sorted short list as expected.
     * Checks if it is returning the same array, as it is already sorted.
     */
    @Test
    public void executeTest_alreadySortedShortList() {
        Assertions.assertTrue(Arrays.equals(
                TestData.getListSortedShort(),
                new InsertionSortAlgorithm().getSortedList(TestData.getListSortedShort())));
    }

    /**
     * This test method checks if the sort algorithm handles an unsorted short list as expected.
     * Checks if it is returning a sorted array in ascending order with the given values.
     */
    @Test
    public void executeTest_unsortedShortList() {
        Assertions.assertTrue(Arrays.equals(
                Arrays.stream(TestData.getListUnsortedShort()).sorted().toArray(),
                new InsertionSortAlgorithm().getSortedList(TestData.getListUnsortedShort())));
    }

    /**
     * This test method checks if the sort algorithm handles an unsorted medium list as expected.
     * Checks if it is returning a sorted array in ascending order with the given values.
     */
    @Test
    public void executeTest_unsortedMediumList() {
        Assertions.assertTrue(Arrays.equals(
                Arrays.stream(TestData.getListUnsortedMedium()).sorted().toArray(),
                new InsertionSortAlgorithm().getSortedList(TestData.getListUnsortedMedium())));
    }

    /**
     * This test method checks if the sort algorithm handles an unsorted long list as expected.
     * Checks if it is returning a sorted array in ascending order with the given values.
     */
    @Test
    public void executeTest_unsortedLongList() {
        Assertions.assertTrue(Arrays.equals(
                Arrays.stream(TestData.getListUnsortedLong()).sorted().toArray(),
                new InsertionSortAlgorithm().getSortedList(TestData.getListUnsortedLong())));
    }

    /**
     * This test method checks if the sort algorithm handles lists containing negative numbers as expected.
     * Checks if it is returning a sorted array in ascending order with the given values.
     */
    @Test
    public void executeTest_negativeNumbers() {
        Assertions.assertTrue(Arrays.equals(
                Arrays.stream(TestData.getListUnsortedWithNegative()).sorted().toArray(),
                new InsertionSortAlgorithm().getSortedList(TestData.getListUnsortedWithNegative())));
    }

    /**
     * This test method checks if the sort algorithm handles a list of arrays in descending order correctly.
     * Checks if it is returning a sorted array in ascending order with the given values.
     */
    @Test
    public void executeTest_sortedDescendingList() {
        Assertions.assertTrue(Arrays.equals(
                Arrays.stream(TestData.getListSortedDescending()).sorted().toArray(),
                new InsertionSortAlgorithm().getSortedList(TestData.getListSortedDescending())));
    }
}