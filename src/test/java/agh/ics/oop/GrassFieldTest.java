package agh.ics.oop;

import com.sun.nio.sctp.IllegalReceiveException;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;


public class GrassFieldTest {

    @Test
    public void test(){
        try {
            GrassField grassField = new GrassField(10);
            Animal ani = new Animal(grassField, new Vector2d(5, 5));
            assertEquals(true, grassField.canMoveTo(new Vector2d(5, 5)));
            grassField.place(ani);
            assertEquals(true, grassField.isOccupied(new Vector2d(5, 5)));
            assertEquals(false, grassField.canMoveTo(new Vector2d(5, 5)));
            assertEquals(true, grassField.canMoveTo(new Vector2d(5, 6)));
            ani.move(MoveDirection.FORWARD);
            assertEquals(true, grassField.canMoveTo(new Vector2d(5, 5)));
            assertEquals(true, grassField.isOccupied(new Vector2d(5, 6)));
            assertEquals(false, grassField.canMoveTo(new Vector2d(5, 6)));
            assertTrue(ani.equals(grassField.objectAt(new Vector2d(5, 6))));
            assertTrue("N".equals(grassField.objectAt(new Vector2d(5, 6)).toString()));
        } catch(IllegalArgumentException ex){
            System.out.println(ex.getMessage());
        }
    }

}
