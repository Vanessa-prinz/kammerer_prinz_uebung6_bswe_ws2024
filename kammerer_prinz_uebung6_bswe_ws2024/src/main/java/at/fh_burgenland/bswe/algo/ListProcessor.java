package at.fh_burgenland.bswe.algo;

import java.util.Arrays;
import java.util.Objects;

/**
 * This class provides methods for processing, sorting and validating lists from user input.
 */
public class ListProcessor {

    /**
     * This method converts string input from the user in an array of integers.
     * @param userInput a string of integers from the user
     * @return the parsed integer array or null if invalid
     */
    public static int[] getList(String userInput) {
        userInput = userInput.replaceAll(" ", "");

        if (listInputValid(userInput)) {
            String[] stringValues = userInput.split(",");
            int[] values = new int[stringValues.length];
            for (int i = 0; i < stringValues.length; i++) {
                try {
                    values[i] = Integer.parseInt(stringValues[i]);
                } catch (NumberFormatException e) {
                    System.out.println("Value can not be parsed!");
                    return null;
                }
            }
            return values;
        } else {
            System.out.println("Invalid format!");
            return null;
        }
    }

    public static boolean hasNegativeNumbers(int[] values) {
        for (int i = 0; i < values.length; i++) {
            if (values[i] < 0) {
                return true;
            }
        }
        return false;
    }

    /**
     * This method checks if the given user input is in a valid format.
     * @param userInput a string of integers from the user
     * @return true it the input matches the expected format, false if otherwise
     */
    public static boolean listInputValid(String userInput) {
        return userInput.matches("^\\d+(,\\d+)*$");
    }

    /**
     * This method converts an array of integers in a string, separated by spaces.
     * @param list the array of integers to convert
     * @return the string representation of the array or null if list is empty or null
     */
    public static String getListAsString(int[] list) {
        if (list == null || list.length == 0) {
            return null;
        }

        StringBuilder listAsString = new StringBuilder();
        for (int i = 0; i < list.length; i++) {
            listAsString.append(list[i]).append(" ");
        }

        return listAsString.toString().trim();
    }
}