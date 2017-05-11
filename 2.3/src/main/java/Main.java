import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;

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
        try(Scanner input = new Scanner(System.in)) {
            System.out.print("Enter in an integer: ");
            int n = input.nextInt();
            int l = Integer.toString(n).length() - 1;
            for(int i = (int) Math.pow(10, l) ; i > 0 ; i /= 10)
                System.out.print(n / i % 10 + " ");
        }
    }
}
