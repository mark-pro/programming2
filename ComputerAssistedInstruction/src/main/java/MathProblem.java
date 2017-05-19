import java.util.EnumMap;
import java.util.Random;
import java.util.function.BiFunction;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.function.Supplier;

class MathProblem {
    public enum Operation {
        ADD, SUBTRACT, MULTIPLY, DIVIDE
    }

    private EnumMap<Operation, BiFunction<Double, Double, Double>> funcMap;
    private double x;
    private double y;
    private Operation op;

    public MathProblem(double x, double y) {
        this.op = Operation.values()[new Random().nextInt(4)];
        this.Initialize(x, y);
    }
    public MathProblem(double x, double y, Operation operation) {
        this.op = operation;
        this.Initialize(x, y);
    }
    public MathProblem(Supplier<Double> func) {
        this.Initialize(func.get(), func.get());
    }
    public MathProblem(Supplier<Double> func, Operation operation) {
        this.op = operation;
        this.Initialize(func.get(), func.get());
    }
    public void Initialize(double x, double y) {
        funcMap = new EnumMap<>(Operation.class);
        this.x = x;
        this.y = y;
        funcMap.put(Operation.ADD, (a, b) -> (double) (a + b));
        funcMap.put(Operation.SUBTRACT, (a, b) -> (double) (a - b));
        funcMap.put(Operation.MULTIPLY, (a, b) -> (double) (a * b));
        funcMap.put(Operation.DIVIDE, (a, b) -> (double) round((a / b), 2));
    }
    public static double round(double value, int places) {
    if (places < 0) throw new IllegalArgumentException();
        BigDecimal bd = new BigDecimal(value);
        bd = bd.setScale(places, RoundingMode.HALF_UP);
        return bd.doubleValue();
    }
    public double getX() { return this.x; }
    public double getY() { return this.y; }
    public Operation getOperation() { return this.op; }
    public void setX(double x) { this.x = x; }
    public void setY(double y) { this.y = y; }
    public double getAnswer() { return funcMap.get(this.op).apply(this.x, this.y); };
    public String getQuestion() {
        String opString = op == Operation.ADD ? "plus" :
            op == Operation.SUBTRACT ? "minus" :
            op == Operation.MULTIPLY ? "times" :
            "divided by";
        return String.format(
                "How much is %d %s %d? (round to two deimal places if needed) ex: 0.56", 
            (int) this.x, opString, (int) this.y);
    }
    public MathProblem setupForDivision(Supplier<Double> func) {
        while (this.getOperation() == MathProblem.Operation.DIVIDE && 
            this.getX() % this.getY() != 0) {
            this.setX(func.get());
            this.setY(func.get());
        }
        return this;
    }
}