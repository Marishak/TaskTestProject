public class Rectangle extends Shape {

    private float side1;
    private float side2;

    private Rectangle(String color, float side1, float side2) {
        super(color);
        this.side1 = side1;
        this.side2 = side2;
    }

    public static Rectangle of(String color, float side1, float side2) {
        if (side1 <= 0 || side2 <= 0 || color.matches("\\s*")) {
            throw new IllegalArgumentException();
        } else {
            return new Rectangle(color, side1, side2);
        }
    }

    public float getSide1() {
        return side1;
    }

    public float getSide2() {
        return side2;
    }

    @Override
    public float getArea() {
        float s = side1*side2;
        return (float) (Math.round(s * Math.pow(10, 2)) / Math.pow(10, 2));
    }
}
