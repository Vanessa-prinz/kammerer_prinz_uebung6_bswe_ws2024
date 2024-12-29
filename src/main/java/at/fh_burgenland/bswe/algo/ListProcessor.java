package at.fh_burgenland.bswe.algo;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;

/**
 * This class provides methods for processing, sorting and validating lists from user or file input.
 */
public class ListProcessor {

    /**
     * This method converts string input from the user in an array of integers.
     * @param userInput a string of integers from the user
     * @return the parsed integer array or null if invalid
     */
    public static int[] getListFromUserInput(String userInput) {
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

    /**
     * This method checks if the given array contains any negative numbers.
     * The counting sort algorithm can not execute with negative numbers.
     * @param values an array of integers to check
     * @return true if the array contains any negative numbers, false if otherwise
     */
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

    /**
     * This method reads a list of integers from a file.
     * The file input can be seperated by semicolons or line breaks.
     * @param fileName the name of the file to read
     * @return an array of integers from the file or null if the file does not exist or the values are invalid
     */
    public static int[] getListFromFile(String fileName) {
        Path path = Paths.get("src", "main", "resources", fileName);
        ArrayList<Integer> integerArray = new ArrayList<>();

        if (!Files.exists(path)) {
            System.err.println("File does not exist in: " + path);
            return null;
        }

        try (BufferedReader reader = Files.newBufferedReader(path)) {
            String firstLine = reader.readLine();

            if (firstLine != null && firstLine.contains(";")) {
                System.out.println("File contains semicolon. Processing with semicolons...");
                processWithSemicolon(firstLine, integerArray);
            } else if (firstLine != null) {
                try {
                    integerArray.add(Integer.parseInt(firstLine.trim()));
                } catch (NumberFormatException e) {
                    System.out.println("Value can not be parsed!");
                }
                System.out.println("File does not contain semicolon. Processing with line breaks...");
                processWithLineBreak(reader, integerArray);
                }
        } catch (IOException e) {
            System.err.println(e.getMessage());
        }

        return integerArray.stream().mapToInt(i -> i).toArray();
    }

    /**
     * This method processes a line of input where the values are seperated by semicolons.
     * This method is called when the first line in the file contains semicolons as separation.
     * @param line the line of input containing values that are seperated by semicolons
     * @param integerArray an ArrayList to store the parsed integers
     */
    private static void processWithSemicolon(String line, ArrayList<Integer> integerArray) {
        String[] stringValues = line.split(";");
        for (String value : stringValues) {
            value = value.trim();
            try {
                integerArray.add(Integer.parseInt(value));
            } catch (NumberFormatException e) {
                System.out.println("Value can not be parsed!");
            }
        }
    }

    /**
     * This method processes the input of a file where each line contains one value.
     * This method is called when the first line in the file contains no semicolons as separation.
     * @param reader a BufferedReader to read the file line by line
     * @param integerArray an ArrayList to store the parsed integers
     * @throws IOException if an I/O error occurs while reading the file
     */
    private static void processWithLineBreak(BufferedReader reader, ArrayList<Integer> integerArray) throws IOException {
        String line;
        while ((line = reader.readLine()) != null) {
            try {
                integerArray.add(Integer.parseInt(line.trim()));
            } catch (NumberFormatException e) {
                System.out.println("Value can not be parsed!");
            }
        }
    }
}