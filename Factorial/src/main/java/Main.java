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
            int n = in.nextInt();
            long result = calculateFactorial(n);
            System.out.println(n + "! = " + result);
        }
    }
    public static long calculateFactorial(int n) {
        long i; for(i = 1; n > 0 ; i *= n--); return i;
    }
}
