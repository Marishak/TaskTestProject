import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static junit.framework.TestCase.assertEquals;
import static org.junit.Assert.*;

public class RectangleTest {

    private Rectangle rectangle;

    @Before
    public void setUp() {
        rectangle = Rectangle.of("red", 5.2f, 5.2f);
    }

    @Test
    public void correctAreaRectangleCalculation() {
        float actual = rectangle.getArea();
        float expected = 27.04f;
        assertEquals(expected, actual);
    }

    @Test
    public void side1RectangleShouldFloat() {
        float actual = rectangle.getSide1();
        float expected = 5.2f;
        assertEquals(expected, actual);
    }

    @Test
    public void side2RectangleShouldFloat() {
        float actual = rectangle.getSide2();
        float expected = 5.2f;
        assertEquals(expected, actual);
    }

    @Test
    public void colorRectangleShouldString() {
        String actual = rectangle.getColor();
        String expected = "red";
        assertEquals(expected, actual);
    }

    @Test
    public void newRectangleNotNullColor() {
        String colorActual = rectangle.getColor();
        assertNotNull(colorActual);
    }

    @Test
    public void newRectangleSidesShouldMore0() {
        if (rectangle.getSide1() <= 0 || rectangle.getSide2() <= 0) {
            Assert.fail("The side of the rectangle is less than or equal to 0.");
        }
    }

}