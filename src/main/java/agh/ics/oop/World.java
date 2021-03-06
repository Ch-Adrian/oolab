package agh.ics.oop;

import agh.ics.oop.gui.App;
import javafx.application.Application;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Vector;
import java.util.function.Consumer;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import static java.lang.System.out;
import static java.lang.System.setOut;

public class World {

    public static void main(String[] args) {
        try {

            Application.launch(App.class, args);
/*
        Animal animal = new Animal();
        out.println(animal.toString());
        String[] move = new String[]{"f","f","r","f","f","q","r","f","f","f","f"};
        MoveDirection[] moveDirections = OptionsParser.parse(move);
        for(MoveDirection mD: moveDirections){
            animal.move(mD);
        }
        out.println(animal.toString());*/

        /*
        MoveDirection[] directions = new OptionsParser().parse(args);
        IWorldMap map = new RectangularMap(10, 5);
        Vector2d[] positions = { new Vector2d(2,2), new Vector2d(3,4) };
        IEngine engine = new SimulationEngine(directions, map, positions);
        engine.run();*/
/*
            String[] move2 = new String[]{"f","rty" ,"b", "r", "l", "f", "f", "r", "r", "f", "f", "f", "f", "f", "f", "f", "f"};
            MoveDirection[] moveDirections = OptionsParser.parse(move2);
            IWorldMap map2 = new GrassField(10);
            Vector2d[] positions2 = {new Vector2d(2, 2), new Vector2d(2, 2)};
            IEngine engine2 = new SimulationEngine(moveDirections, map2, positions2);
            //out.println(map2);
            engine2.run();
            //out.println(map2);
            */
            /*
            String[] move2 = new String[]{"f", "f", "f", "f"};
            MoveDirection[] moveDirections = OptionsParser.parse(move2);
            GrassField gF = new GrassField(10);
            IWorldMap map2 = gF;
            Vector2d[] positions2 = {new Vector2d(2, 2), new Vector2d(3, 3)};
            IEngine engine2 = new SimulationEngine(moveDirections, map2, positions2);
            out.println(map2.toString());
            engine2.run();
            out.println(map2.toString());
*/


        /*Vector2d position1 = new Vector2d(1,2);
        System.out.println(position1);
        Vector2d position2 = new Vector2d(-2,1);
        System.out.println(position2);
        System.out.println(position1.add(position2));*/

        /*MapDirection n = MapDirection.NORTH;
        MapDirection s = MapDirection.SOUTH;
        MapDirection w = MapDirection.WEST;
        MapDirection e = MapDirection.EAST;

        System.out.println(n.toString());
        System.out.println(s.toString());
        System.out.println(w.toString());
        System.out.println(e.toString());
        System.out.println();
        System.out.println(n.next().toString());
        System.out.println(s.next().toString());
        System.out.println(w.next().toString());
        System.out.println(e.next().toString());
        System.out.println();
        System.out.println(n.previous().toString());
        System.out.println(s.previous().toString());
        System.out.println(w.previous().toString());
        System.out.println(e.previous().toString());
        System.out.println();
        System.out.println(n.toUnitVector().toString());
        System.out.println(s.toUnitVector().toString());
        System.out.println(w.toUnitVector().toString());
        System.out.println(e.toUnitVector().toString());*/


        /*Vector2d v = new Vector2d(1,2);
        Vector2d v2 = new Vector2d(1,2);
        System.out.println(v.equals(v2));*/

       /* System.out.println("Start");
        run(args);
        System.out.println("Stop");*/
        }
        catch(IllegalArgumentException ex){
            out.println(ex.getMessage());
            return;
        }
    }


    public static void run(String[] arr){
        System.out.println("Zwierzak idzie do przodu");

        Object[] arrDir = Stream.of(arr).filter(str -> (str.equals("f") || str.equals("b") || str.equals("r") || str.equals("l")))
                .peek(str ->
                {
                    switch (str) {
                        case "f" -> System.out.println("Zwierzak idzie do przodu");
                        case "b" -> System.out.println("Zwierzak idzie do ty??u");
                        case "r" -> System.out.println("Zwierzak skr??ca w prawo");
                        default -> System.out.println("Zwierzak skr??ca w lewo");
                    }
                }).toArray();

        long dl = Stream.of(arr).filter(str -> (str.equals("f") || str.equals("b") || str.equals("r") || str.equals("l"))).count();
        Stream<Direction> stream = Stream.of(arr).filter(str -> (str.equals("f") || str.equals("b") || str.equals("r") || str.equals("l")))
                .map(str ->
                switch (str) {
                        case "f" -> Direction.FORWARD;
                        case "b" -> Direction.BACKWARD;
                        case "r" -> Direction.RIGHT;
                        case "l" -> Direction.LEFT;
                        default ->  Direction.FORWARD;
                });
        stream = stream.limit(dl - 1).peek(str -> System.out.print(str + ", "));

        Direction last = Stream.of(arr).filter(str -> (str.equals("f") || str.equals("b") || str.equals("r") || str.equals("l")))
                .map(str ->
                        switch (str) {
                            case "f" -> Direction.FORWARD;
                            case "b" -> Direction.BACKWARD;
                            case "r" -> Direction.RIGHT;
                            case "l" -> Direction.LEFT;
                            default -> Direction.FORWARD;
                        }).skip(dl - 1).collect(Collectors.toList()).get(0);
        Object[] dir = stream.toArray();
        System.out.println(last);
    }


}
