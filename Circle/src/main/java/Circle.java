public class Circle {
    
    //. Properties
    private double Radius;
    private double Diameter;
    private double Circumference;
    private double Area;

    //. Constructors
    public Circle(double radius) {
        this.Radius = radius;
        this.calculateDiameter()
            .calculateCircumference()
            .calculateArea();
    }

    //. Calculation Methods
    public Circle calculateDiameter() {
        this.Diameter = 2 * this.Radius;
        return this;
    }

    public Circle calculateCircumference() {
        this.Circumference = 2 * Math.PI * this.Radius;
        return this;
    }

    public Circle calculateArea() {
        this.Area = Math.PI * (this.Radius * this.Radius);
        return this;
    }

    //. Getters and setters
    public double getRadius() { return this.Radius; }
    public double getDiameter() { return this.Diameter; }
    public double getCircumference() { return this.Circumference; }
    public double getArea() { return this.Area; }

    @Override
    public String toString() {
        return 
        "{\n" +
        "\tradius: " + this.Radius + "\n" +
        "\tdiameter: " + this.Diameter + "\n" +
        "\tcircumference: " + this.Circumference + "\n" +
        "\tarea: " + this.Area + "\n" +
        "}";
    }
}