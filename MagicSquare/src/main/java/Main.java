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
            while(true) {
                System.out.print("\nEnter in an NxN square of numbers with spaces between them\n//.ex. 9 numbers produces a 3x3 square\n\n{~}> ");
                String numbers = input.nextLine();
                MagicSquare m = MagicSquareFactory.createMatrix(numbers);
                System.out.println("The square is ->\n");
                System.out.printf("%s\n\n", m);
                if(m.isMagicSquare())
                    System.out.println("This is a magic square!");
                else
                    System.out.println("This is NOT a magic square");
            }
        }
    }
}
