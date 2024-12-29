package at.fh_burgenland.bswe.algo;

import at.fh_burgenland.bswe.algo.SortAlgorithm.CountingSortAlgorithm;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

public class CountingSortAlgorithmTests {
    @Test
    public void executeTest_EmptyList() {
        Assertions.assertNull(new CountingSortAlgorithm().getSortedList(new int[0]));
    }

    @Test
    public void executeTest_OneElement() {
        Assertions.assertTrue(Arrays.equals(
                TestData.getListSingleElement(),
                new CountingSortAlgorithm().getSortedList(TestData.getListSingleElement())));
    }

    @Test
    public void executeTest_alreadySortedLongList() {
        Assertions.assertTrue(Arrays.equals(
                TestData.getListSortedLong(),
                new CountingSortAlgorithm().getSortedList(TestData.getListSortedLong())));
    }

    @Test
    public void executeTest_alreadySortedShortList() {
        Assertions.assertTrue(Arrays.equals(
                TestData.getListSortedShort(),
                new CountingSortAlgorithm().getSortedList(TestData.getListSortedShort())));
    }

    @Test
    public void executeTest_unsortedShortList() {
        Assertions.assertTrue(Arrays.equals(
                Arrays.stream(TestData.getListUnsortedShort()).sorted().toArray(),
                new CountingSortAlgorithm().getSortedList(TestData.getListUnsortedShort())));
    }

    @Test
    public void executeTest_unsortedMediumList() {
        Assertions.assertTrue(Arrays.equals(
                Arrays.stream(TestData.getListUnsortedMedium()).sorted().toArray(),
                new CountingSortAlgorithm().getSortedList(TestData.getListUnsortedMedium())));
    }

    @Test
    public void executeTest_unsortedLongList() {
        Assertions.assertTrue(Arrays.equals(
                Arrays.stream(TestData.getListUnsortedLong()).sorted().toArray(),
                new CountingSortAlgorithm().getSortedList(TestData.getListUnsortedLong())));
    }

    @Test
    public void executeTest_negativeNumbers_Failure() throws IllegalArgumentException {
        Assertions.assertThrows(
                IllegalArgumentException.class,
                () -> new CountingSortAlgorithm().getSortedList(TestData.getListUnsortedWithNegative()));
    }

    @Test
    public void executeTest_sortedDescendingList() {
        Assertions.assertTrue(Arrays.equals(
                Arrays.stream(TestData.getListSortedDescending()).sorted().toArray(),
                new CountingSortAlgorithm().getSortedList(TestData.getListSortedDescending())));
    }
}