import java.util.ArrayList;
import java.util.Collection;
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
            System.out.printf("Enter in a numbaer from 0 -> %d\n{~}> ", Long.MAX_VALUE);
            Long n = in.nextLong();
            if (-1 < n && n <= Long.MAX_VALUE)
                new FibIterator(n).forEach(i -> System.out.println(i));
            else
                System.out.print("Cannot generate the series from %d\n");
        }
    }
}
