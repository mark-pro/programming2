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
        System.out.println("number\tsquare\tcube");
        for(int i = 0 ; i <= 10 ; i++) {
            String out = i + "\t" + 
                (int) Math.pow(i, 2) + "\t" + 
                (int) Math.pow(i, 3);
            System.out.println(out);
        }
    }
}
