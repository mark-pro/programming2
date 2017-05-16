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
            System.out.printf("Enter in a numbaer from 0 -> %d\n{~}> ", Short.MAX_VALUE);
            short n = in.nextShort();
            if (-1 < n && n <= Long.MAX_VALUE)
                fib(n).stream()
                    .map(i -> String.format("%d ", i))
                    .forEach(System.out::print);
            else
                System.out.print("Cannot generate the series from %d\n");
        }
    }

    private static ArrayList<Short> fib(short n) {
        ArrayList<Short> f = new ArrayList<Short>();
        if(n == 1)
            f.add((short) 1);
        else
            for(short i = 0 , j = 1 , k = 0 ; i <= n ; k = i , i = j , j += k) f.add(i);
        return f;
    }
}
