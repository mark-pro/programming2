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
        do {
            MathInstruction mi = new MathInstruction();
            MathProblem p = mi.generateProblem();
            System.out.println(p.getQuestion());
            while (!MathInstruction.checkAnswer(promptForAnswer(), p))
                System.out.println(MathInstruction.getBadResponse());
            System.out.println(MathInstruction.getGoodResponse());
        } while(true);
    }

    public static Double promptForAnswer() {
        System.out.print("{~}> ");
        Double result = in.nextDouble();
        return result;
    }
}
