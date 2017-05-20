import java.util.Scanner;
import java.util.Random;

/**
 * Copyright (C) 2017 Mark Pro.
 */


/**
 * Main class.
 *
 * @version 1.0.0
 */
public class Main {
    private static Scanner in = new Scanner(System.in);
    public static void main(String[] args) {
        if(args.length > 0 && args[0].equalsIgnoreCase("advanced"))
            run(
                getOption("mode", new String[] { "Easy", "Medium", "Hard" }),
                getOption("operation", new String[] { "Addition", "Subtraction", "Multiplication", "Division", "All" })
            );
        else run(0, 2);
    }

    public static void run(int mode, int operation) {
        do {
            MathProblem.Operation o = operation != 4 ? 
                MathProblem.Operation.values()[operation] : 
                MathProblem.Operation.values()[new Random().nextInt(4)];
            MathProblemHelper.Mode m = MathProblemHelper.Mode.values()[mode];
            MathProblemHelper mi = new MathProblemHelper();
            MathProblem p = mi.generateProblem(m, o);
            System.out.println(p.getQuestion());
            while (!MathProblemHelper.checkAnswer(promptForAnswer(), p))
                System.out.println(MathProblemHelper.getBadResponse());
            System.out.println(MathProblemHelper.getGoodResponse());
        } while(true);
    }
    public static int getOption(String option, String[] options) {
        System.out.printf("What %s would you like? (select a number 1 - %d)\n", option, options.length);
        for(int i = 0; i < options.length; i++)
            System.out.printf("%d. %s\n", i + 1, options[i]);
        System.out.print("{~}> ");
        return in.nextInt() - 1;
    }
    public static Double promptForAnswer() {
        System.out.print("{~}> ");
        Double result = in.nextDouble();
        return result;
    }
}
