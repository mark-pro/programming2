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
    private SecureRandom sr = new SecureRandom();
    private MathProblem generateMathProblem(Mode mode, MathProblem.Operation operation) {
        Supplier<Double> getLowNumber = () -> (double) sr.nextInt(9) + 1;
        Supplier<Double> getHighNumber = () -> (double) sr.nextInt(100) + 1;
        MathProblem p = null;
        boolean hasOperation = operation != null;
        switch (mode) {
            case HARD:
                p = hasOperation ? 
                    new MathProblem(getHighNumber, operation) : 
                    new MathProblem(getHighNumber);
                break;                    
            case MEDIUM:
                p = hasOperation ? 
                    new MathProblem(getHighNumber, operation)
                        .setupForDivision(getHighNumber) :
                    new MathProblem(getHighNumber)
                        .setupForDivision(getHighNumber);
                break;
            case EASY:
                p = hasOperation ? 
                    new MathProblem(getLowNumber, operation)
                        .setupForDivision(getLowNumber) : 
                    new MathProblem(getLowNumber)
                        .setupForDivision(getLowNumber);
                break;
        }
        return p;
    }
    public MathProblem generateProblem(Mode mode) {
        return this.generateMathProblem(mode, null);
    }
    public MathProblem generateProblem(Mode mode, MathProblem.Operation operation) {
        return this.generateMathProblem(mode, operation);
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