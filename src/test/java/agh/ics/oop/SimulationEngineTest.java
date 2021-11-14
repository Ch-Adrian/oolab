package agh.ics.oop;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class SimulationEngineTest {

    @Test
    public void testRun(){
        String[] tab = {"f", "f"};
        Vector2d[] positions = { new Vector2d(0,0)};
        MoveDirection[] directions = new OptionsParser().parse(tab);
        IWorldMap map = new RectangularMap(10, 5);
        IEngine engine = new SimulationEngine(directions, map, positions);
        engine.run();

        IWorldMap map2 = new RectangularMap(10, 5);
        map2.place(new Animal(map2, new Vector2d(0, 2),MapDirection.NORTH));
        assertEquals(map.toString(), map2.toString());
    }

    @Test
    public void testRun2(){
        String[] tab = {"f", "f","r", "f", "f","r","f","f","r","f","f"};
        Vector2d[] positions = { new Vector2d(0,0)};
        MoveDirection[] directions = new OptionsParser().parse(tab);
        IWorldMap map = new RectangularMap(10, 5);
        IEngine engine = new SimulationEngine(directions, map, positions);
        engine.run();

        IWorldMap map2 = new RectangularMap(10, 5);
        map2.place(new Animal(map2, new Vector2d(0, 0),MapDirection.WEST));
        assertEquals(map.toString(), map2.toString());
    }

    @Test
    public void testRun3(){
        String[] tab = {"f", "f","f", "f","r","r", "f", "f", "f", "f","r","r","f","f", "f", "f","r","r","f","f", "f", "f"};
        Vector2d[] positions = { new Vector2d(0,0), new Vector2d(1,1)};
        MoveDirection[] directions = new OptionsParser().parse(tab);
        IWorldMap map = new RectangularMap(10, 5);
        IEngine engine = new SimulationEngine(directions, map, positions);
        engine.run();

        IWorldMap map2 = new RectangularMap(10, 5);
        map2.place(new Animal(map2, new Vector2d(0, 0),MapDirection.WEST));
        map2.place(new Animal(map2, new Vector2d(1, 1), MapDirection.WEST));
        assertEquals(map.toString(), map2.toString());
    }

    @Test
    public void testRun4(){
        String[] tab = {"f", "f","f", "r","r","l", "f", "f", "f", "f","r","r","f","f", "f", "f","r","r","f","f", "f", "f"};
        Vector2d[] positions = { new Vector2d(0,0), new Vector2d(1,1)};
        MoveDirection[] directions = new OptionsParser().parse(tab);
        IWorldMap map = new RectangularMap(10, 5);
        IEngine engine = new SimulationEngine(directions, map, positions);
        engine.run();

        IWorldMap map2 = new RectangularMap(10, 5);
        map2.place(new Animal(map2, new Vector2d(0, 0),MapDirection.WEST));
        map2.place(new Animal(map2, new Vector2d(3, 2), MapDirection.SOUTH));
        assertEquals(map.toString(), map2.toString());
    }

    @Test
    public void testRun5(){
        String[] tab = {"f", "b", "r", "l"};
        Vector2d[] positions = { new Vector2d(0,0), new Vector2d(1,1)};
        MoveDirection[] directions = new OptionsParser().parse(tab);
        IWorldMap map = new RectangularMap(10, 5);
        IEngine engine = new SimulationEngine(directions, map, positions);
        engine.run();

        IWorldMap map2 = new RectangularMap(10, 5);
        map2.place(new Animal(map2, new Vector2d(0, 1),MapDirection.EAST));
        map2.place(new Animal(map2, new Vector2d(1, 0), MapDirection.WEST));
        assertEquals(map.toString(), map2.toString());
    }

    @Test
    public void testRun6(){
        String[] tab = {"f", "b", "r", "l", "f", "f", "r", "r", "f", "f", "f", "f", "f", "f", "f", "f"};
        Vector2d[] positions = { new Vector2d(2,2), new Vector2d(3,4)};
        MoveDirection[] directions = new OptionsParser().parse(tab);
        IWorldMap map = new RectangularMap(10, 5);
        IEngine engine = new SimulationEngine(directions, map, positions);
        engine.run();

        IWorldMap map2 = new RectangularMap(10, 5);
        map2.place(new Animal(map2, new Vector2d(2, 0),MapDirection.SOUTH));
        map2.place(new Animal(map2, new Vector2d(3, 4), MapDirection.NORTH));
        assertEquals(map.toString(), map2.toString());
    }

}
