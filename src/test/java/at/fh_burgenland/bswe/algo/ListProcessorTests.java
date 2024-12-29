package at.fh_burgenland.bswe.algo;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * This class contains unit tests for the ListProcessor class.
 */
public class ListProcessorTests {

    /**
     * This test method ensures that a valid string is correctly parsed into an integer array.
     */
    @Test
    public void getList_Success() {
        String inputString = "1,2,3,4,5,6,7,8,9";
        int[] expectedList = {1,2,3,4,5,6,7,8,9};

        Assertions.assertArrayEquals(expectedList, ListProcessor.getListFromUserInput(inputString));
    }

    /**
     * This test method checks if the getList method handles an empty string correctly by returning null.
     */
    @Test
    public void getList_Success_EmptyString() {
        String inputString = "";

        Assertions.assertNull(ListProcessor.getListFromUserInput(inputString));
    }

    /**
     * This test method checks if the getList method handles a string with invalid characters correctly by returning null.
     */
    @Test
    public void getList_Failure_WrongCharacter() {
        String inputString = "1,2,c,4,5,6,7,8,9";

        Assertions.assertNull(ListProcessor.getListFromUserInput(inputString));
    }

    /**
     * This test method checks if the getList method handles a string with invalid format correctly by returning null.
     */
    @Test
    public void getList_Failure_WrongFormat() {
        String inputString = "1,2,3,,4,5,6,7,8,9";

        Assertions.assertNull(ListProcessor.getListFromUserInput(inputString));
    }

    /**
     * This test method tests the listInputValid method with a valid input string.
     * Return true, because input is in a valid format.
     */
    @Test
    public void listInputValid_Success_CorrectFormat() {
        String inputString = "1,2,3,4,5,6,7,8,9";

        Assertions.assertTrue(ListProcessor.listInputValid(inputString));
    }

    /**
     * This test method tests the listInputValid method with an invalid input string.
     * Return false, because input is in an invalid format.
     */
    @Test
    public void listInputValid_Failure_WrongFormat() {
        String inputString = "1,2,,3,4,5,6,7,8,9";

        Assertions.assertFalse(ListProcessor.listInputValid(inputString));
    }

    /**
     * This test method checks if the getListAsString method handles an empty list correctly by returning null.
     */
    @Test
    public void getListAsString_EmptyList() {
        int[] inputList = {};

        Assertions.assertNull(ListProcessor.getListAsString(inputList));
    }

    /**
     * This test method ensures that a valid integer array is correctly parsed into a string.
     */
    @Test
    public void getListAsString() {
        int[] inputList = {9,8,7,6,5,2,3,1,4};
        String expectedString = "9 8 7 6 5 2 3 1 4";

        Assertions.assertEquals(expectedString, ListProcessor.getListAsString(inputList));
    }

    /**
     * This test method checks if the hasNegativeNumbers method correctly identifies an array with negative numbers.
     */
    @Test
    public void hasNegativeNumbers_Success_WithNegatives() {
        int[] inputList = {1, -2, 3, 4, 5};

        Assertions.assertTrue(ListProcessor.hasNegativeNumbers(inputList));
    }

    /**
     * This test method checks if the hasNegativeNumbers method correctly identifies an array without negative numbers.
     */
    @Test
    public void hasNegativeNumbers_Failure_WithoutNegatives() {
        int[] inputList = {1, 2, 3, 4, 5};

        Assertions.assertFalse(ListProcessor.hasNegativeNumbers(inputList));
    }

    /**
     * This test method checks if the getListFromFile method handles a non-existent file correctly by returning null.
     */
    @Test
    public void getListFromFile_Failure_NonExistentFile() {
        String testFileName = "non_existent.txt";

        Assertions.assertNull(ListProcessor.getListFromFile(testFileName));
    }

    /**
     * This test method ensures that the getListFromFile method correctly processes a file with semicolon-separated values.
     */
    @Test
    public void getListFromFile_Success_SemicolonSeparated() throws IOException {
        String testFileName = "test_semicolon.txt";
        Path testFilePath = Paths.get("src", "main", "resources", testFileName);
        Files.writeString(testFilePath, "1;2;3;4;5;6;7;8;9");

        int[] expectedList = {1, 2, 3, 4, 5, 6, 7, 8, 9};
        Assertions.assertArrayEquals(expectedList, ListProcessor.getListFromFile(testFileName));

        Files.deleteIfExists(testFilePath);
    }

    /**
     * This test method ensures that the getListFromFile method correctly processes a file with line-break-separated values.
     */
    @Test
    public void getListFromFile_Success_LineBreakSeparated() throws IOException {
        String testFileName = "test_linebreak.txt";
        Path testFilePath = Paths.get("src", "main", "resources", testFileName);
        Files.writeString(testFilePath, "1\n2\n3\n4\n5\n6\n7\n8\n9");

        int[] expectedList = {1, 2, 3, 4, 5, 6, 7, 8, 9};
        Assertions.assertArrayEquals(expectedList, ListProcessor.getListFromFile(testFileName));

        Files.deleteIfExists(testFilePath);
    }
}