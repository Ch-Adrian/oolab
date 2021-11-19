package agh.ics.oop;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;


public class RectangularMapTest {

    @Test
    public void test(){
        RectangularMap rectangularMap = new RectangularMap(10, 10);
        Animal ani = new Animal(rectangularMap, new Vector2d(5,5));
        assertEquals(false, rectangularMap.isOccupied(new Vector2d(5,5)));
        rectangularMap.place(ani);
        assertEquals(true, rectangularMap.isOccupied(new Vector2d(5,5)));
        assertEquals(true, rectangularMap.canMoveTo(new Vector2d(5,6)));
        ani.move(MoveDirection.FORWARD);
        assertEquals(false, rectangularMap.isOccupied(new Vector2d(5,5)));
        assertEquals(true, rectangularMap.isOccupied(new Vector2d(5,6)));
        assertEquals(false, rectangularMap.canMoveTo(new Vector2d(5,6)));
        assertTrue(ani.equals(rectangularMap.objectAt(new Vector2d(5,6))));
        assertTrue("N".equals((rectangularMap.objectAt(new Vector2d(5,6)).toString())));
    }

}
