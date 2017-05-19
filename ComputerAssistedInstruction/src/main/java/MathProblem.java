import java.util.EnumMap;
import java.util.Random;
import java.util.function.Supplier;
import java.math.BigDecimal;
import java.math.RoundingMode;;

class MathProblem {
    public enum Operation {
        ADD, SUBTRACT, MULTIPLY, DIVIDE
    }

    private EnumMap<Operation, Supplier<Double>> funcMap;

    double x;
    double y;
    Operation op;

    public MathProblem(double x, double y) {
        funcMap = new EnumMap<>(Operation.class);
        this.x = x;
        this.y = y;
        this.op = Operation.values()[new Random().nextInt(4)];
        funcMap.put(Operation.ADD, () -> (double) (x + y));
        funcMap.put(Operation.SUBTRACT, () -> (double) (x - y));
        funcMap.put(Operation.MULTIPLY, () -> (double) (x * y));
        funcMap.put(Operation.DIVIDE, () -> (double) round((x / y), 2));
    }

    public static double round(double value, int places) {
    if (places < 0) throw new IllegalArgumentException();
        BigDecimal bd = new BigDecimal(value);
        bd = bd.setScale(places, RoundingMode.HALF_UP);
        return bd.doubleValue();
    }
    public double getX() { return this.x; }
    public double getY() { return this.y; }
    public double getAnswer() { return funcMap.get(this.op).get(); };

    public String getQuestion() {
        String opString = op == Operation.ADD ? "add" :
            op == Operation.SUBTRACT ? "minus" :
            op == Operation.MULTIPLY ? "times" :
            "divided by";
        return String.format(
                "How much is %d %s %d? (round to two deimal places if needed) ex: 0.56", 
            (int) this.x, opString, (int) this.y);
    }
}