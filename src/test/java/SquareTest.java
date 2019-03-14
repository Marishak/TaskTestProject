import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static junit.framework.TestCase.assertEquals;
import static org.junit.Assert.assertNotNull;


public class SquareTest {

    private Square square;

    @Before
    public void setUp() {
        square = Square.of("red", 5.2f);
    }

    @Test
    public void correctAreaSquareCalculation() {
        float actual = square.getArea();
        float expected = 27.04f;
        assertEquals(expected, actual);
    }

    @Test
    public void colorSquareShouldString() {
        String actual = square.getColor();
        String expected = "red";
        assertEquals(expected, actual);
    }

    @Test
    public void sideSquareShouldFloat() {
        float actual = square.getSide();
        float expected = 5.2f;
        assertEquals(expected, actual);
    }

    @Test
    public void newSquareNotNullColor() {
        String colorActual = square.getColor();
        assertNotNull(colorActual);
    }

    @Test
    public void newSquareSideShouldMore0() {
        if (square.getSide() <= 0) {
            Assert.fail("The side of the square is less than or equal to 0.");
        }
    }
}
