import java.security.SecureRandom;
import java.util.Random;
import java.util.function.Supplier;

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
    
    SecureRandom sr = new SecureRandom();

    public MathProblem generateProblem(Mode mode) {
        MathProblem p = 
            new MathProblem((double) sr.nextInt(9) + 1, (double) sr.nextInt(9) + 1);
        switch (mode) {
            case HARD:
                p = new MathProblem(
                    (double) sr.nextInt(100) + 1, (double) sr.nextInt(100) + 1);
                break;                    
            case MEDIUM:
                p = new MathProblem(
                    (double) sr.nextInt(100) + 1, (double) sr.nextInt(100) + 1);
                p = setupForDivision(p, () -> sr.nextInt(100));
                break;
            case EASY:
                p = this.setupForDivision(p, () -> sr.nextInt(9) + 1);
                break;
            default:
                break;
        }
        return p;
    }

    public MathProblem generateProblem(Mode mode, MathProblem.Operation operation) {
        MathProblem p = 
            new MathProblem((double) sr.nextInt(9) + 1, (double) sr.nextInt(9) + 1, operation);
        switch (mode) {
            case HARD:
                p = new MathProblem(
                    (double) sr.nextInt(100) + 1, (double) sr.nextInt(100) + 1, operation);
                break;                    
            case MEDIUM:
                p = new MathProblem(
                    (double) sr.nextInt(100) + 1, (double) sr.nextInt(100) + 1, operation);
                p = setupForDivision(p, () -> sr.nextInt(100));
                break;
            case EASY:
                p = this.setupForDivision(p, () -> sr.nextInt(9) + 1);
                break;
            default:
                break;
        }
        return p;
    }

    private MathProblem setupForDivision(MathProblem problem, Supplier<Integer> func) {
        while (problem.getOperation() == MathProblem.Operation.DIVIDE && 
            problem.getX() % problem.getY() != 0) {
            problem.setX((double) func.get());
            problem.setY((double) func.get());
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