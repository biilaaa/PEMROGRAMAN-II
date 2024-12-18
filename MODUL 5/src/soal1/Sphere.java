package soal1;

public class Sphere extends Shape {
    private final double radius;

    public Sphere(double r) {
        super("Sphere");
        this.radius = r;
    }

    @Override
    public double area() {
        return 4 * Math.PI * Math.pow(radius, 2);
    }

    @Override
    public String toString() {
        return super.toString() + " of radius " + radius;
    }
}