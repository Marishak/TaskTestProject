import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static junit.framework.TestCase.assertEquals;
import static org.junit.Assert.*;

public class CircleTest {

    private Circle circle;


    @Before
    public void setUp() {
        circle = Circle.of("red", 5.2f);
        }

    @Test
    public void correctAreaCircleCalculation() {
        float actual = circle.getArea();
        float expected = 84.91f;
        assertEquals(expected, actual);
    }

    @Test
    public void colorCircleShouldString() {
        String actual = circle.getColor();
        String expected = "red";
        assertEquals(expected, actual);
    }

    @Test
    public void diameterCircleShouldFloat() {
        float actual = circle.getDiameter();
        float expected = 5.2f;
        assertEquals(expected, actual);
    }

    @Test
    public void newCircleNotNullColor() {
        String colorActual = circle.getColor();
        assertNotNull(colorActual);
    }
    @Test

    public void newCircleDiameterShouldMore0() {
        if (circle.getDiameter() <= 0) {
            Assert.fail("The diameter of the circle is less than or equal to 0.");
        }
    }
}