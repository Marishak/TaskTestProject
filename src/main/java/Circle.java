public class Circle extends Shape {

    private float diameter;

    private Circle(String color, float diameter) {
        super(color);
        this.diameter = diameter;
    }

    public static Circle of(String color, float diameter) {
        if (diameter <= 0 || color.matches("\\s*")) {
            throw new IllegalArgumentException();
        } else {
            return new Circle(color, diameter);
        }
    }

    public float getDiameter() {
        return diameter;
    }

    @Override
    public float getArea() {
        float s = (float) (3.14*diameter*diameter);
        return (float) (Math.round(s * Math.pow(10, 2)) / Math.pow(10, 2));
    }
}
