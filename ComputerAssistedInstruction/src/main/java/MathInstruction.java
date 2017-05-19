import java.security.SecureRandom;
import java.util.Random;

class MathInstruction {
    SecureRandom sr = new SecureRandom();
    public enum GoodResponses {
        VeryGood , Excellent , NiceWork , GoodWork;
    }
    public enum BadResponses {
        TryAgain, TryOnceMore, DontGiveUp, KeepTrying
    }

    public MathProblem generateProblem() {
        return new MathProblem(sr.nextInt(9) + 1, sr.nextInt(9) + 1);
    }

    public boolean checkAnswer(int answer, MathProblem problem) {
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