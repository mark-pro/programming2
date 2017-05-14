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
        HealthProfile profile = HealthProfileFactory.createProfileFromInput();
        System.out.println(profile);
    }
}
