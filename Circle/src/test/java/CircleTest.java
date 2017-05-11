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
public class CircleTest {
    
    Circle TestCircle = new Circle(5);
    
    @Test
    public void radiusTest() {
        assertEquals(this.TestCircle.getRadius(), 5, 0);
    }

    @Test
    public void diameterTest() {
        assertEquals(this.TestCircle.getDiameter(), 10, 0);
    }

    @Test
    public void circumferenceTest() {
        assertEquals(this.TestCircle.getCircumference(), 31.4159, 0.0001);                
    }

    @Test
    public void areaTest() {
        assertEquals(this.TestCircle.getArea(), 78.5398, 0.0001);
    }
}
