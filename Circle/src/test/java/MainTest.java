/**
 * Copyright (C) 2017 Mark Pro.
 */

import static org.junit.Assert.*;
import org.junit.*;

/**
 * Main class unit tests.
 *
 * @version 1.0.0
 */
public class MainTest {
    Circle TestCircle = new Circle(5);
    @Test
    public void radiusTest() {
        assertEquals(TestCircle.getRadius(), 5, 0);
    }

    @Test
    public void diameterTest() {
        assertEquals(TestCircle.getDiameter(), 10, 0);
    }

    @Test
    public void circumferenceTest() {
        assertEquals(TestCircle.getCircumference(), 31.4159, 0.0001);                
    }

    @Test
    public void areaTest() {
        assertEquals(TestCircle.getArea(), 78.5398, 0.0001);
    }
}
