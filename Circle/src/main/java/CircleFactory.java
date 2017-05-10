import java.lang.Math;

public class CircleFactory {
    public static Circle createCircle(double radius) {
        Circle c = new Circle(radius);
        c.setDiameter(calculateDiameter(radius));
        c.setCircumference(calculateCircumference(radius));
        c.setArea(calculateArea(radius));
        return c;
    }

    private static double calculateDiameter(double radius) {
        return radius * 2;
    }

    private static double calculateCircumference(double radius) {
        return 2 * Math.PI * radius;
    }

    private static double calculateArea(double radius) {
        return Math.PI * (radius * radius);
    }
}