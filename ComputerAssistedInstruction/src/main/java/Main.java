/**
 * Copyright (C) 2017 Mark Pro.
 */

import java.util.Random;

/**
 * Main class.
 *
 * @version 1.0.0
 */
public class Main {
    public static void main(String[] args) {
        Random r = new Random();

        for(int i = 0, num = r.nextInt(4) + 1; i < 100; i++, num = r.nextInt(4) + 1)
            System.out.println(num);
    }
}
