public class Circle {
    
    //. Variables
    private double Radius;
    private double Diameter;
    private double Circumference;
    private double Area;

    //. Constructors
    public Circle() { this.initialize(); }

    public Circle(double radius) {
        this.initialize();
        this.setRadius(radius); 
    }

    private void initialize() {
        this.Radius = 0;
        this.Diameter = 0;
        this.Circumference = 0;
        this.Area = 0;
    }

    //. Getters and setters
    public double getRadius() { return this.Radius; }
    public void setRadius(double radius) { this.Radius = radius; }
    public double getDiameter() { return this.Diameter; }
    public void setDiameter(double diameter) { this.Diameter = diameter; }
    public double getCircumference() { return this.Circumference; }
    public void setCircumference(double circumference) { this.Circumference = circumference; }
    public double getArea() { return this.Area; }
    public void setArea(double area) { this.Area = area; }

    @Override
    public String toString() {
        return 
        "{\n" +
        "\tradius: " + this.getRadius() + "\n" +
        "\tdiameter: " + this.getDiameter() + "\n" +
        "\tcircumference: " + this.getCircumference() + "\n" +
        "\tarea: " + this.getArea() + "\n" +
        "}"
        ;
    }
}