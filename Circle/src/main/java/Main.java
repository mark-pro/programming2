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
        System.out.println(new Circle(proptRadius()));
    }

    public static double proptRadius() {
        try(Scanner input = new Scanner(System.in)) {
            System.out.print("Enter a radius for a circle: ");
            return input.nextDouble();
        }
    }
}
