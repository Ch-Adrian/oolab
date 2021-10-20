package agh.ics.oop;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class Vector2dTest {

    Vector2d lb = new Vector2d(1,1);
    Vector2d rb = new Vector2d(2,1);
    Vector2d lt = new Vector2d(1,2);

    Vector2d rt = new Vector2d(2,2);
    Vector2d rt2 = new Vector2d(2,2);
    Vector2d opprt = new Vector2d(-2,-2);

    @Test
    public void testEquals(){
        assertTrue(rt.equals(rt2));
        assertFalse(rt.equals(lt));
        assertFalse(rt.equals(rb));
        assertFalse(rt.equals(lb));
    }

    @Test
    public void testToString(){
        assertTrue("(2,2)".equals(rt.toString()));
        assertFalse("(2,1)".equals(rt.toString()));
        assertFalse("(1,2)".equals(rt.toString()));
        assertFalse("(1,1)".equals(rt.toString()));
    }

    @Test
    public void testPrecedes(){
        assertTrue(lb.precedes(rt));
        assertTrue(rb.precedes(rt));
        assertTrue(lt.precedes(rt));
        assertTrue(rt.precedes(rt));

        assertFalse(rt.precedes(lb));
        assertFalse(rt.precedes(rb));
        assertFalse(rt.precedes(lt));

    }

    @Test
    public void testFollows(){
        assertFalse(lb.follows(rt));
        assertFalse(rb.follows(rt));
        assertFalse(lt.follows(rt));
        assertTrue(rt.follows(rt));

        assertTrue(rt.follows(lb));
        assertTrue(rt.follows(rb));
        assertTrue(rt.follows(lt));
    }

    @Test
    public void testUpperRight(){
        assertTrue(rt.equals(lt.upperRight(rb)));
        assertFalse(lb.equals(lt.upperRight(rb)));
        assertFalse(lt.equals(lt.upperRight(rb)));
        assertFalse(rb.equals(lt.upperRight(rb)));

        assertTrue(rt.equals(lt.upperRight(rt)));
        assertFalse(lt.equals(lt.upperRight(rt)));
    }

    @Test
    public void testLowerLeft(){
        assertTrue(lb.equals(lt.lowerLeft(rb)));
        assertFalse(rt.equals(lt.lowerLeft(rb)));
        assertFalse(lt.equals(lt.lowerLeft(rb)));
        assertFalse(rb.equals(lt.lowerLeft(rb)));

        assertTrue(lt.equals(lt.lowerLeft(rt)));
        assertFalse(rt.equals(lt.lowerLeft(rt)));
    }

    @Test
    public void testAdd(){
        assertTrue(rt.equals(lb.add(lb)));
        assertFalse(rt.equals(lb.add(rb)));
        assertFalse(rt.equals(lt.add(rb)));
        assertFalse(rt.equals(lt.add(rt)));

    }

    @Test
    public void testSubtract(){
        assertTrue(lb.equals(rt.subtract(lb)));
        assertFalse(lb.equals(lt.subtract(rb)));
        assertFalse(lb.equals(lt.subtract(rt)));
        assertFalse(lb.equals(lb.subtract(lb)));

    }

    @Test
    public void testOpposite(){
        assertTrue(opprt.equals(rt.opposite()));
        assertFalse(rt.equals(lb.opposite()));
        assertFalse(lt.equals(lt.opposite()));
        assertFalse(rb.equals(opprt.opposite()));
        assertTrue(rt.equals(opprt.opposite()));
    }


}
