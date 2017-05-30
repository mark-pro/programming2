import java.util.Scanner;

/**
 * Copyright (C) 2017 Mark Pro.
 */

/**
 * Main class.
 *
 * @version 1.0.0
 */
public class Main {
    public static void main(String[] args) {
        Run();
    }

    private static void Run() {
        try(Scanner input = new Scanner(System.in)) {
            System.out.print("Enter in 9 numbers with spaces between them\n{~}>");
            String numbers = input.nextLine();
            int[][] nxn = MatrixHelper.createMatrix(numbers);
            for(int i = 0 ; i < nxn.length; i++) {
                for(int j = 0; j < nxn[0].length; j++)
                    System.out.printf("%d ", nxn[i][j]);

                System.out.println();
            }
        }
    }
}
