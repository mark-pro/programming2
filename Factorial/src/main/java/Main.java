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
            short n = 0;
            do {
                System.out.print("Enter in a number -1 < n < 21\n{~}> ");
                n = in.nextShort();
                if (inBounds(n)) {
                    long result = calculateFactorial(n);
                    System.out.println(n + "! = " + result);
                }
                else
                    System.out.printf("Could not calculate %d!\n" , n);
            } while (!inBounds(n));
        }
    }
    public static long calculateFactorial(short n) {
        long i = 1; for(n = n == 0 ? 1 : n ; n > 0 ; i *= n--); return i;
    }
    private static boolean inBounds(short n) {
        return -1 < n && n < 21;
    }
}
