import java.math.BigInteger;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.text.NumberFormat;
import java.util.Locale;
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
            BigInteger max =  BigInteger.valueOf(Integer.valueOf(2)).pow(Short.MAX_VALUE + (Short.MAX_VALUE / 2));
            NumberFormat formatter = new DecimalFormat("0.##E0", DecimalFormatSymbols.getInstance(Locale.ROOT));
            System.out.printf("Enter in a numbaer from 0 -> %s\n{~}> ", formatter.format(max));
            BigInteger n = in.nextBigInteger();
            new FibIterator(n)
                .forEach(i -> System.out.printf("%s\n", isLessThan10k(i) ? 
                    String.format("%d ", i) : 
                    formatter.format(i))
                );
        }

    }
    private static boolean isLessThan10k(BigInteger i) {
        return BigInteger.valueOf(Integer.valueOf(10000)).compareTo(i) == 1;
    }
}
