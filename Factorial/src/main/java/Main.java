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
    public static void main(String... args) {
        try(Scanner in = new Scanner(System.in)) {
            System.out.print("Enter in a number 0 < n < 21\n{~}> ");
            short n = in.nextShort();
            if (inBounds(n)) {
                long result = calculateFactorial(n);
                System.out.println(n + "! = " + result);
            }
            else
                System.out.printf("Could not calculate %d!\nnow exiting..." , n);
        }
    }
    public static long calculateFactorial(short n) {
        long i = 1; for(; inBounds(n) ; i *= n--); return i;
    }
    private static boolean inBounds(short n) {
        return 0 < n && n < 20;
    }
}
