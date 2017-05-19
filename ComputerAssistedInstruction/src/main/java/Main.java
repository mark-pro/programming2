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
    static Scanner in = new Scanner(System.in);
    public static void main(String[] args) {
        run();
    }

    public static void run() {
        MathInstruction mi = new MathInstruction();
        do {
            MathProblem p = mi.generateProblem();
            System.out.println(p);
            while (p.getAnswer() != promptForAnswer())
                System.out.println(MathInstruction.getBadResponse());
            System.out.println(MathInstruction.getGoodResponse());
        } while(true);
    }

    public static int promptForAnswer() {
        System.out.print("{~}> ");
        int result = in.nextInt();
        return result;
    }
}
