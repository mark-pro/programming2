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
        run();        
    }

    private static void run() {
        HealthProfile profile;
        do {
            profile = HealthProfileFactory.createProfileFromInput();
        } while(profile == null);
        System.out.println("//---------------------//");
        System.out.println(profile);
    }
}
