public class Triangle extends Shape {

    private float side1;
    private float side2;
    private float side3;

    public Triangle(String color, float side1, float side2, float side3) {
        super(color);
        this.side1 = side1;
        this.side2 = side2;
        this.side3 = side3;
    }

    public static Triangle of(String color, float side1, float side2, float side3) {
        if (side1 <= 0 || side2 <= 0 || side3 <= 0 || color.matches("\\s*")) {
            throw new IllegalArgumentException();
        } else {
            return new Triangle(color, side1, side2, side3);
        }
    }

    public float getSide1() {
        return side1;
    }

    public float getSide2() {
        return side2;
    }

    public float getSide3() {
        return side3;
    }

    @Override
    public float getArea() {
        float p = (side1+side2+side3)/2;
        float s = (float) Math.sqrt(p*(p-side1)*(p-side2)*(p-side3));
        return (float) (Math.round(s * Math.pow(10, 2)) / Math.pow(10, 2));
    }
}
