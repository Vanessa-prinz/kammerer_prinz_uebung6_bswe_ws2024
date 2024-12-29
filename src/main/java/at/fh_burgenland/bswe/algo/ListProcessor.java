package at.fh_burgenland.bswe.algo;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;

/**
 * This class provides methods for processing, sorting and validating lists from user input.
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

    public static int[] getListFromFile(String fileName) {
        Path path = Paths.get("src", "main", "resources", fileName);
        ArrayList<Integer> integerArray = new ArrayList<>();

        if (!Files.exists(path)) {
            System.err.println("File does not exist in: " + path);
            return null;
        }

        try (BufferedReader reader = Files.newBufferedReader(path)) { //new BufferedReader(new java.io.FileReader(path.toString()))) {
            String firstLine = reader.readLine();  //erste Zeile einlesen

            if (firstLine != null && firstLine.contains(";")) {
                System.out.println("File contains semicolon. Processing with semicolons...");
                processWithSemicolon(firstLine, integerArray);
            } else {
                System.out.println("File does not contain semicolon. Processing with line breaks...");
                processWithLineBreak(reader, integerArray);
            }
        } catch (IOException e) {
            System.err.println(e.getMessage());
        }

        return integerArray.stream().mapToInt(i -> i).toArray(); //Umwandlung von ArrayList in int[]
    }

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