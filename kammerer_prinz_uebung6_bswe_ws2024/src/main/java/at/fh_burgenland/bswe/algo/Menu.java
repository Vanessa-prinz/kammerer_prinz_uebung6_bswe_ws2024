package at.fh_burgenland.bswe.algo;

import at.fh_burgenland.bswe.algo.SortAlgorithm.InsertionSortAlgorithm;
import at.fh_burgenland.bswe.algo.SortAlgorithm.CountingSortAlgorithm;
import lombok.extern.log4j.Log4j2;

import java.util.Scanner;

import static at.fh_burgenland.bswe.algo.SortAlgorithm.SortAlgorithm.runSortAlgorithm;

@Log4j2
public class Menu {

    private static final Scanner scanner = new Scanner(System.in);

    public static void run() {
        System.out.println("Welcome to our sort algorithms!");
        boolean isRunning = true;
        while (isRunning) {
            System.out.println("Enter the list in the following format: 1,2,3,... (only integer, seperated by ',', spacing is removed)");
            System.out.println("Please give me your list:");
            String listInput = scanner.nextLine();
            int[] list = ListProcessor.getList(listInput);
            if (list == null) {
                System.out.println("Invalid input! Please enter again.");
                continue;
            }

            System.out.print("Please enter your integer to search for: ");
            int searchedInteger = checkInputMisMatch();

            String menu = """
                You have the following options:
                1 - use the insertion sort
                2 - use the counting sort
                3 - enter new list
                4 - exit program
                """;
            boolean runSearch = true;

            while (runSearch) {
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
                        runSearch = false;
                        break;
                    case 4:
                        runSearch = false;
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