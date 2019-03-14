import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static junit.framework.TestCase.assertEquals;
import static org.junit.Assert.*;

public class TriangleTest {

    private Triangle triangle;

    @Before
    public void setUp() {
        triangle = Triangle.of("red", 5.2f, 5.6f, 7f);
    }


    @Test
    public void correctAreaTriangleCalculation() {
        float actual = triangle.getArea();
        float expected = 14.37f;
        assertEquals(expected, actual);
    }

    @Test
    public void side1TriangleShouldFloat() {
        float actual = triangle.getSide1();
        float expected = 5.2f;
        assertEquals(expected, actual);
    }

    @Test
    public void side2TriangleShouldFloat() {
        float actual = triangle.getSide2();
        float expected = 5.6f;
        assertEquals(expected, actual);
    }

    @Test
    public void side3TriangleShouldFloat() {
        float actual = triangle.getSide3();
        float expected = 7f;
        assertEquals(expected, actual);
    }

    @Test
    public void colorTriangleShouldString() {
        String actual = triangle.getColor();
        String expected = "red";
        assertEquals(expected, actual);
    }

    @Test
    public void newTriangleNotNullColor() {
        String colorActual = triangle.getColor();
        assertNotNull(colorActual);
    }

    @Test
    public void newTriangleSidesShouldMore0() {
        if (triangle.getSide1() <= 0 || triangle.getSide2() <= 0 || triangle.getSide3() <= 0) {
            Assert.fail("The side of the triangle is less than or equal to 0.");
        }
    }
}
