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
            System.out.print("Enter in a number greater than 0\n{~}> ");
            short n = in.nextShort();
            long result = calculateFactorial(n);
            System.out.println(n + "! = " + result);
        }
    }
    public static long calculateFactorial(short n) {
        long i = 1; for(; n > 0 ; i *= n--); return i;
    }
}
