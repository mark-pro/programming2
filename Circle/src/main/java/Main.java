import java.util.Scanner;

import org.omg.PortableInterceptor.SYSTEM_EXCEPTION;

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
        Circle c = CircleFactory.createCircle(proptRadius());
        System.out.println(c);
    }

    public static double proptRadius() {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter a radius for a circle: ");
        return input.nextDouble();
    }
}
