package at.fh_burgenland.bswe.algo;

import at.fh_burgenland.bswe.algo.SortAlgorithm.InsertionSortAlgorithm;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

public class InsertionSortAlgorithmTests {

    @Test
    public void executeTest_EmptyList() {
        Assertions.assertNull(new InsertionSortAlgorithm().getSortedList(new int[0]));
    }

    @Test
    public void executeTest_OneElement() {
        Assertions.assertTrue(Arrays.equals(
                TestData.getListSingleElement(),
                new InsertionSortAlgorithm().getSortedList(TestData.getListSingleElement())));
    }

    @Test
    public void executeTest_alreadySortedList() {
        Assertions.assertTrue(Arrays.equals(
                TestData.getListSortedLong(),
                new InsertionSortAlgorithm().getSortedList(TestData.getListSortedLong())));
    }

    @Test
    public void executeTest_unsortedList() {
        Assertions.assertTrue(Arrays.equals(
                Arrays.stream(TestData.getListUnsortedShort()).sorted().toArray(),
                new InsertionSortAlgorithm().getSortedList(TestData.getListUnsortedShort())));
    }

    @Test
    public void executeTest_unsortedLongList() {
        Assertions.assertTrue(Arrays.equals(
                Arrays.stream(TestData.getListUnsortedLong()).sorted().toArray(),
                new InsertionSortAlgorithm().getSortedList(TestData.getListUnsortedLong())));
    }


    @Test
    public void executeTest_negativeNumbers() {
        Assertions.assertTrue(Arrays.equals(
                Arrays.stream(TestData.getListUnsortedWithNegative()).sorted().toArray(),
                new InsertionSortAlgorithm().getSortedList(TestData.getListUnsortedWithNegative())));
    }
}