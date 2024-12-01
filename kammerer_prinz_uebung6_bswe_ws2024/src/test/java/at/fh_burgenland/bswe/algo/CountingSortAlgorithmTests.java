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
    public void executeTest_alreadySortedList() {
        Assertions.assertTrue(Arrays.equals(
                TestData.getListSortedLong(),
                new CountingSortAlgorithm().getSortedList(TestData.getListSortedLong())));
    }

    @Test
    public void executeTest_unsortedList() {
        Assertions.assertTrue(Arrays.equals(
                Arrays.stream(TestData.getListUnsortedShort()).sorted().toArray(),
                new CountingSortAlgorithm().getSortedList(TestData.getListUnsortedShort())));
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
}