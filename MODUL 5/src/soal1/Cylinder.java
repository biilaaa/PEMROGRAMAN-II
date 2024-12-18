package soal1;

public class Cylinder extends Shape {
    private final  double radius;
    private final double height;

    public Cylinder(double r, double h) {
        super("Cylinder");
        this.radius = r;
        this.height = h;
    }

    @Override
    public double area() {
        return Math.PI * Math.pow(radius, 2) * height;
    }

    @Override
    public String toString() {
        return super.toString() + " of radius " + radius + " and height " + height;
    }
}