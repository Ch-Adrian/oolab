package agh.ics.oop;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class AnimalTest {

    Animal animal = new Animal();
    Animal animal2 = new Animal();

    @Test
    public void testMove(){
        assertTrue(animal.toString().equals("Position: (2,2) Orientation: Północ"));
        animal.move(MoveDirection.RIGHT);
        assertTrue(animal.toString().equals("Position: (2,2) Orientation: Wschód"));
        animal.move(MoveDirection.RIGHT);
        assertTrue(animal.toString().equals("Position: (2,2) Orientation: Południe"));
        animal.move(MoveDirection.RIGHT);
        assertTrue(animal.toString().equals("Position: (2,2) Orientation: Zachód"));
        animal.move(MoveDirection.RIGHT);
        assertTrue(animal.toString().equals("Position: (2,2) Orientation: Północ"));
        animal2.move(MoveDirection.LEFT);
        assertTrue(animal2.toString().equals("Position: (2,2) Orientation: Zachód"));
        animal2.move(MoveDirection.LEFT);
        assertTrue(animal2.toString().equals("Position: (2,2) Orientation: Południe"));
        animal2.move(MoveDirection.LEFT);
        assertTrue(animal2.toString().equals("Position: (2,2) Orientation: Wschód"));
        animal2.move(MoveDirection.LEFT);
        assertTrue(animal2.toString().equals("Position: (2,2) Orientation: Północ"));

        assertTrue(animal.toString().equals("Position: (2,2) Orientation: Północ"));
        animal.move(MoveDirection.FORWARD);
        assertTrue(animal.toString().equals("Position: (2,3) Orientation: Północ"));
        animal.move(MoveDirection.FORWARD);
        assertTrue(animal.toString().equals("Position: (2,4) Orientation: Północ"));
        animal.move(MoveDirection.RIGHT);
        assertTrue(animal.toString().equals("Position: (2,4) Orientation: Wschód"));
        animal.move(MoveDirection.FORWARD);
        assertTrue(animal.toString().equals("Position: (3,4) Orientation: Wschód"));
        animal.move(MoveDirection.FORWARD);
        assertTrue(animal.toString().equals("Position: (4,4) Orientation: Wschód"));
        animal.move(MoveDirection.FORWARD);
        assertTrue(animal.toString().equals("Position: (4,4) Orientation: Wschód"));
        animal.move(MoveDirection.LEFT);
        assertTrue(animal.toString().equals("Position: (4,4) Orientation: Północ"));
        animal.move(MoveDirection.BACKWARD);
        assertTrue(animal.toString().equals("Position: (4,3) Orientation: Północ"));
        animal.move(MoveDirection.BACKWARD);
        assertTrue(animal.toString().equals("Position: (4,2) Orientation: Północ"));
        animal.move(MoveDirection.BACKWARD);
        assertTrue(animal.toString().equals("Position: (4,1) Orientation: Północ"));
        animal.move(MoveDirection.BACKWARD);
        assertTrue(animal.toString().equals("Position: (4,0) Orientation: Północ"));
        animal.move(MoveDirection.BACKWARD);
        assertTrue(animal.toString().equals("Position: (4,0) Orientation: Północ"));

    }
}
