import java.security.SecureRandom;
import java.util.Random;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

import groovy.lang.MetaArrayLengthProperty;

class MathInstruction {
    public enum GoodResponses {
        VERY_GOOD , EXCELLENT , NICE_WORK , GOOD_WORK;
    }
    public enum BadResponses {
        TRY_AGAIN, TRY_ONCE_MORE, DONT_GIVE_UP, KEEP_TRYING
    }
    public enum Mode {
        EASY, MEDIUM, HARD
    }
    private SecureRandom sr = new SecureRandom();
    private Supplier<Double> getLowNumber = () -> (double) sr.nextInt(9) + 1;
    private Supplier<Double> getHighNumber = () -> (double) sr.nextInt(100) + 1;
    private MathProblem setUpMathProblem(Mode mode, MathProblem.Operation operation) {
        MathProblem p = null;
        boolean hasOperation = operation != null;
        switch (mode) {
            case HARD:
                p = hasOperation ? 
                    new MathProblem(this.getHighNumber, operation) : 
                    new MathProblem(this.getHighNumber);
                break;                    
            case MEDIUM:
                p = hasOperation ? 
                    new MathProblem(this.getHighNumber, operation) :
                    new MathProblem(this.getHighNumber);
                p = this.setupForDivision(p, this.getHighNumber);
                break;
            case EASY:
                p = hasOperation ? 
                    new MathProblem(this.getLowNumber, operation) : 
                    new MathProblem(this.getLowNumber);
                p = this.setupForDivision(p, this.getLowNumber);
                break;
        }
        return p;
    }
    public MathProblem generateProblem(Mode mode) {
        return this.setUpMathProblem(mode, null);
    }
    public MathProblem generateProblem(Mode mode, MathProblem.Operation operation) {
        return this.setUpMathProblem(mode, operation);
    }
    private MathProblem setupForDivision(MathProblem problem, Supplier<Double> func) {
        while (problem.getOperation() == MathProblem.Operation.DIVIDE && 
            problem.getX() % problem.getY() != 0) {
            problem.setX(func.get());
            problem.setY(func.get());
        }
        return problem;
    }
    public static boolean checkAnswer(double answer, MathProblem problem) {
        return answer == problem.getAnswer();
    }
    public static String getGoodResponse() {
        int result = new Random().nextInt(4);
        GoodResponses goodResponse = GoodResponses.values()[result];
        switch (goodResponse) {
            case VERY_GOOD: return "Very Good!";
            case EXCELLENT: return "Excellent!";
            case NICE_WORK: return "Nice Work!";
            case GOOD_WORK: return "Keep up the good work!";
        }        
        return null;
    }
    public static String getBadResponse() {
        int result = new Random().nextInt(4);
        BadResponses badResponse = BadResponses.values()[result];
        switch (badResponse) {
            case TRY_AGAIN: return "No, please try again";
            case TRY_ONCE_MORE: return "Wrong. Try once more.";
            case DONT_GIVE_UP: return "Don't give up!'";
            case KEEP_TRYING: return "No. Keep trying";
        }        
        return null;
    }
}