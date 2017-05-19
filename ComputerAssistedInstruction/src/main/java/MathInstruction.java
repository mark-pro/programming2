import java.security.SecureRandom;
import java.util.Random;
import java.util.function.Supplier;

class MathInstruction {
    public enum GoodResponses {
        VeryGood , Excellent , NiceWork , GoodWork;
    }
    public enum BadResponses {
        TryAgain, TryOnceMore, DontGiveUp, KeepTrying
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
            case VeryGood: return "Very Good!";
            case Excellent: return "Excellent!";
            case NiceWork: return "Nice Work!";
            case GoodWork: return "Keep up the good work!";
        }        
        return null;
    }

    public static String getBadResponse() {
        int result = new Random().nextInt(4);
        BadResponses badResponse = BadResponses.values()[result];
        switch (badResponse) {
            case TryAgain: return "No, please try again";
            case TryOnceMore: return "Wrong. Try once more.";
            case DontGiveUp: return "Don't give up!'";
            case KeepTrying: return "No. Keep trying";
        }        
        return null;
    }
}