package at.fh_burgenland.bswe.algo;

import at.fh_burgenland.bswe.algo.SortAlgorithm.InsertionSortAlgorithm;
import at.fh_burgenland.bswe.algo.SortAlgorithm.CountingSortAlgorithm;

import java.util.Scanner;

import static at.fh_burgenland.bswe.algo.SortAlgorithm.SortAlgorithm.runSortAlgorithm;

/**
 * This class provides a menu to allow interactions with the user.
 */
public class Menu {

    private static final Scanner scanner = new Scanner(System.in);

    /**
     * This method runs the main menu loop. The user can choose between different input variants and sort algorithms.
     * The programm continues running until the user chooses to exit the program.
     */
    public static void run() {
        System.out.println("Welcome to our sort algorithms program!");
        boolean isRunning = true;
        boolean runSort = true;
        while (isRunning) {
            String inputMenu = """
                    You have the following options for input to choose from:
                    1 - console input
                    2 - file input
                    3 - exit program
                    """;
            System.out.println(inputMenu);
            System.out.print("Please enter your input choice: ");
            int inputChoice = checkInputMisMatch();
            int[] list = null;
            switch (inputChoice) {
                case 1:
                    list = getListFromConsole();
                    runSort = true;
                    break;
                case 2:
                    list = getListFromFile(list);
                    runSort = true;
                    break;
                case 3:
                    runSort = false;
                    isRunning = false;
                    break;
                default:
                    System.out.println("Invalid choice! Please enter a valid number.");
                    break;
            }

            String menu = """
                    Now that we have your input, you have the following options:
                    1 - use the insertion sort
                    2 - use the counting sort
                    3 - change your input choice
                    4 - exit program
                    """;
                while (runSort) {
                    System.out.println(menu);
                    System.out.print("Please enter your choice: ");
                    int userChoice = checkInputMisMatch();
                    switch (userChoice) {
                        case 1:
                            runSortAlgorithm(list, new InsertionSortAlgorithm());
                            break;
                        case 2:
                            runSortAlgorithm(list, new CountingSortAlgorithm());
                            break;
                        case 3:
                            runSort = false;
                            break;
                        case 4:
                            runSort = false;
                            isRunning = false;
                            break;
                        default:
                            System.out.println("Invalid choice! Please enter a valid number.");
                            break;
                    }
                }
            }
        }

    /**
     * This method prompts the user to enter a list of integers per console.
     * If the input is invalid, the user is asked to re-enter the input until it is valid.
     * @return an array of integers entered by the user
     */
    private static int[] getListFromConsole() {
        int[] list = new int[0];
        boolean isValidInput = false;

        while (!isValidInput) {
            System.out.println("Enter the list in the following format: 1,2,3,... (only integer, seperated by ',', spacing is removed)");
            System.out.println("Please give me your list:");
            String listInput = scanner.nextLine();
            list = ListProcessor.getListFromUserInput(listInput);
            if (list == null) {
                System.out.println("Invalid input! Please enter again.");
            } else {
                isValidInput = true;
            }
        }
        return list;
    }

    /**
     * This method prompts the user to select a predefined file containing a list of integers.
     * If the input is invalid, the user is asked to re-enter the choice until it is valid.
     * @param list the array to store the integers, read from the file
     * @return an array of integers from the selected file
     */
    private static int[] getListFromFile(int[] list) {
        String fileMenu = """
                You have the following files to choose from:
                1 - digits
                2 - numbers_1_to_100
                3 - Random-Zahlen-die-größer-als-1000-sind
                4 - Random-Zahlen-von-1-zu-1000
                """;
        boolean isValidInput = false;
        while (!isValidInput) {
            System.out.println(fileMenu);
            System.out.print("Please enter your file choice: ");
            int fileChoice = checkInputMisMatch();
            switch (fileChoice) {
                case 1:
                    list = ListProcessor.getListFromFile("digits.txt");
                    isValidInput = true;
                    break;
                case 2:
                    list = ListProcessor.getListFromFile("numbers_1_to_100.txt");
                    isValidInput = true;
                    break;
                case 3:
                    list = ListProcessor.getListFromFile("Random-Zahlen-die-größer-als-1000-sind.txt");
                    isValidInput = true;
                    break;
                case 4:
                    list = ListProcessor.getListFromFile("Random-Zahlen-von-1-zu-1000.txt");
                    isValidInput = true;
                    break;
                default:
                    System.out.println("Invalid file choice! Please enter a valid number between 1 and 4.");
                    break;
            }
        }
        return list;
    }

    /**
     * This method checks for input mismatch exceptions and ensures valid integer input.
     * @return the valid integer input from the user
     */
    private static int checkInputMisMatch() {
        boolean runLoop = true;
        int input = 0;

        while (runLoop) {
            try {
                input = scanner.nextInt();
                scanner.nextLine();
                runLoop = false;
            } catch (Exception e) {
                System.err.println("Invalid Input! Please enter a valid integer.");
                scanner.nextLine();
            }
        }
        return input;
    }
}