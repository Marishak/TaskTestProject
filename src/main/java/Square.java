public class Square extends Shape{

    private float side;

    private Square(String color, float side) {
        super(color);
        this.side = side;
    }

    public static Square of(String color, float side) {
        if (side <= 0 || color.matches("\\s*")) {
            throw new IllegalArgumentException();
        } else {
            return new Square(color, side);
        }
    }

    public float getSide() {
        return side;
    }

    @Override
    public float getArea() {
        float s = side*side;
        return (float) (Math.round(s * Math.pow(10, 2)) / Math.pow(10, 2));
    }
}
