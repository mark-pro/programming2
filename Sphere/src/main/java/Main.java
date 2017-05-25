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
        try(Scanner in = new Scanner(System.in)) {
            for (int i = 0 ; i < 5 ; i++) {
                System.out.println("Enter a positive number to calculate a spheres volume");
                System.out.print("{~}> ");
                int radius = in.nextInt();
                if (radius < 1) {
                    System.out.println("radius cannot be less than 1");
                    i--; continue;
                }
                Sphere s = new Sphere(radius);
                System.out.printf("volume: %.2f\n", s.getSphereVoluem());
            }
        }
    }
}
