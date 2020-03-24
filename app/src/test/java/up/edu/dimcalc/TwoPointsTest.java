package up.edu.dimcalc;

import org.junit.Test;

import static org.junit.Assert.*;
import android.graphics.Point;

public class TwoPointsTest {

    /** when created, getPoint() should show both points at the origin */
    @Test
    public void getPoint() throws Exception {
        TwoPoints testPoints = new TwoPoints();
        Point p1 = testPoints.getPoint(0);
        Point p2 = testPoints.getPoint(1);
        assertEquals(0, p1.x);
        assertEquals(0, p1.y);
        assertEquals(0, p2.x);
        assertEquals(0, p2.y);
    }

    /** verify that arbitrary values are properly stored via setPoint() */
    @Test
    public void setPoint() throws Exception {
        TwoPoints testPoints = new TwoPoints();
        testPoints.setPoint(0, 5, -3);
        testPoints.setPoint(1, -3, 5);
        Point p1 = testPoints.getPoint(0);
        Point p2 = testPoints.getPoint(1);
        assertEquals(5, p1.x);
        assertEquals(-3, p1.y);
        assertEquals(-3, p2.x);
        assertEquals(5, p2.y);
    }


    @Test
    public void randomValue() {
        TwoPoints testPoints = new TwoPoints();
        testPoints.randomValue(0);
        testPoints.randomValue(1);
        Point p1 = testPoints.getPoint(0);
        Point p2 = testPoints.getPoint(1);
        assertNotEquals(p1.x,p1.y);
        assertNotEquals(p2.x,p2.y);
        assertNotEquals(p1.y,p2.x);
        assertNotEquals(p1.y,p2.y);
    }

    @Test
    public void setOrigin() {
        TwoPoints testPoints = new TwoPoints();
        testPoints.setPoint(0, 5, -3);
        testPoints.setOrigin(0);
        Point p1 = testPoints.getPoint(0);
        assertEquals(0, p1.x);
        assertEquals(0, p1.y);
    }

    @Test
    public void copy() {
        TwoPoints testPoints = new TwoPoints();
        testPoints.setPoint(0, 5, -3);
        testPoints.setPoint(1, -4, 2);
        testPoints.copy(0,1);
        Point p = testPoints.getPoint(1);
        assertEquals(5,p.x);
        assertEquals(-3,p.y);
    }

    @Test
    public void distance() {
        TwoPoints testPoints = new TwoPoints();
        testPoints.setPoint(0, 5, -3);
        testPoints.setPoint(1, -4, 2);
        double d = testPoints.distance();
        assertEquals(10,d, 0.001);
    }

    @Test
    public void slope() {
        TwoPoints testPoints = new TwoPoints();
        testPoints.setPoint(0, 1, -2);
        testPoints.setPoint(1, -1, 2);
        double d = testPoints.slope();
        assertEquals(d,-2, 0.01);
    }
}