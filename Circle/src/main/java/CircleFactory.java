import java.lang.Math;

public class CircleFactory {
    public static Circle createFromRadius(double radius) {
        return new Circle(radius);
    }

    public static Circle createFromDiameter(double diameter) {
        return new Circle(diameter / 2);
    }

    public static Circle createFromCircumference(double circumference) {
        return new Circle(circumference / (2 * Math.PI));
    }

    public static Circle createFromArea(double area) {
        return new Circle(Math.sqrt(area / Math.PI));
    }
}