import java.lang.Math;

public class CircleFactory {
    public static Circle createCircle(double radius) {
        Circle c = new Circle(radius);
        c = calculateDiameter(c);
        c = calculateCircumference(c);
        c = calculateArea(c);
        return c;
    }

    private static Circle calculateDiameter(Circle circle) {
        circle.setDiameter(circle.getRadius() * 2);
        return circle;
    }

    private static Circle calculateCircumference(Circle circle) {
        circle.setCircumference(2 * Math.PI * circle.getRadius());
        return circle;
    }

    private static Circle calculateArea(Circle circle) {
        double r = circle.getRadius();
        circle.setArea(Math.PI * (r * r));
        return circle;
    }
}