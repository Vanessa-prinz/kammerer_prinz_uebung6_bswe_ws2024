package at.fh_burgenland.bswe.algo;

import at.fh_burgenland.bswe.algo.SortAlgorithm.InsertionSortAlgorithm;
import at.fh_burgenland.bswe.algo.SortAlgorithm.CountingSortAlgorithm;
import lombok.extern.log4j.Log4j2;

import java.util.List;
import java.util.Scanner;

import static at.fh_burgenland.bswe.algo.SortAlgorithm.SortAlgorithm.runSortAlgorithm;

@Log4j2
public class Menu {

    private static final Scanner scanner = new Scanner(System.in);

    public static void run() {
        System.out.println("Welcome to our sort algorithms program!");
        String text = """
                1. You will choose your type of input (console or file)
                2. If you chose console: you will enter your list
                2. If you chose file: you will choose a type of file
                3. You will choose your type of sort algorithm (insertion or counting)
                """;
        System.out.println(text);
        boolean isRunning = true;

        while (isRunning) {
            System.out.print("Please choose your type of input (1-console input, 2-file input, 3-exit program): ");
            int inputChoice = checkInputMisMatch();
            int[] list = null;
            switch (inputChoice) {
                case 1:
                    System.out.println("Enter the list in the following format: 1,2,3,... (only integer, seperated by ',', spacing is removed)");
                    System.out.println("Please give me your list:");
                    String listInput = scanner.nextLine();
                    list = ListProcessor.getListFromUserInput(listInput);
                    if (list == null) {
                        System.out.println("Invalid input! Please enter again.");
                    }
                    break;
                case 2:
                    System.out.println("Please choose a file from the following list: ");
                    String fileMenu = """
                            1 - digits
                            2 - numbers_1_to_100
                            3 - Random-Zahlen-die-größer-als-1000-sind
                            4 - Random-Zahlen-von-1-zu-1000
                            """;
                    System.out.println(fileMenu);
                    System.out.print("Please enter your file type: ");
                    int fileChoice = checkInputMisMatch();
                    switch (fileChoice) {
                        case 1:
                            list = ListProcessor.getListFromFile("digits.txt");
                            break;
                        case 2:
                            list = ListProcessor.getListFromFile("numbers_1_to_100.txt");
                            break;
                        case 3:
                            list = ListProcessor.getListFromFile("Random-Zahlen-die-größer-als-1000-sind.txt");
                            break;
                        case 4:
                            list = ListProcessor.getListFromFile("Random-Zahlen-von-1-zu-1000.txt");
                            break;
                        default:
                            System.out.println("Invalid file choice! Please enter a valid number.");
                            break;
                    }
                    break;
                case 3:
                    isRunning = false;
                    break;
                default:
                    System.out.println("Invalid choice! Please enter a valid number.");
                    break;
            }

            if (list != null) {
                System.out.print("Please choose your type of algorithm (1-Insertion sort, 2-Counting sort, 3-exit program): ");
                int algorithmChoice = checkInputMisMatch();
                switch (algorithmChoice) {
                    case 1:
                        runSortAlgorithm(list, new InsertionSortAlgorithm());
                        break;
                    case 2:
                        runSortAlgorithm(list, new CountingSortAlgorithm());
                        break;
                    case 3:
                        isRunning = false;
                        break;
                    default:
                        System.out.println("Invalid algorithm choice! Please enter a valid number.");
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