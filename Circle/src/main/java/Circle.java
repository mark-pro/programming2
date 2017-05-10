public class Circle {
    
    //. Properties
    private double Radius;
    private double Diameter;
    private double Circumference;
    private double Area;

    //. Constructors
    public Circle(double radius) {
        this.Radius = radius;
        this.setDiameter()
            .setCircumference()
            .setArea();
    }

    //. Getters
    public double getRadius() { return this.Radius; }
    
    public double getDiameter() { return this.Diameter; }
    
    private Circle setDiameter() {
        this.Diameter = 2 * this.Radius;
        return this;
    }
    
    public double getCircumference() { return this.Circumference; }
    
    private Circle setCircumference() {
        this.Circumference = 2 * Math.PI * this.Radius;
        return this;
    }
    
    public double getArea() { return this.Area; }
    
    private Circle setArea() {
        this.Area = Math.PI * Math.pow(this.Radius, 2);
        return this;
    }

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