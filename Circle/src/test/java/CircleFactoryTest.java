import static org.junit.Assert.*;
import org.junit.*;

public class CircleFactoryTest {

    Circle Expected = new Circle(5);

    @Test
    public void createFromRadiusTest() {
        Circle actual = CircleFactory.createFromRadius(
            this.Expected.getRadius());
        assertEquals(this.Expected.toString(), actual.toString());
    }

    @Test
    public void createFromDiameterTest() {
        Circle actual = CircleFactory.createFromDiameter(
            this.Expected.getDiameter());
        assertEquals(this.Expected.toString(), actual.toString());
    }

    @Test
    public void createFromAreaTest() {
        Circle actual = CircleFactory.createFromArea(this.Expected.getArea());
        assertEquals(this.Expected.toString(), actual.toString());
    }

    @Test
    public void createFromCircumferenceTest() {
        Circle actual = CircleFactory.createFromCircumference(
            this.Expected.getCircumference());
        assertEquals(this.Expected.toString(), actual.toString());
    }
}