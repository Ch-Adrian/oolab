package agh.ics.oop;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Vector;
import java.util.function.Consumer;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import static java.lang.System.out;

public class World {

    public static void main(String[] args) {

        /*Vector2d position1 = new Vector2d(1,2);
        System.out.println(position1);
        Vector2d position2 = new Vector2d(-2,1);
        System.out.println(position2);
        System.out.println(position1.add(position2));*/

        MapDirection n = MapDirection.NORTH;
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
        System.out.println(e.toUnitVector().toString());


        /*Vector2d v = new Vector2d(1,2);
        Vector2d v2 = new Vector2d(1,2);
        System.out.println(v.equals(v2));*/

       /* System.out.println("Start");
        run(args);
        System.out.println("Stop");*/
    }

    public static void run(String[] arr){
        System.out.println("Zwierzak idzie do przodu");

        Object[] arrDir = Stream.of(arr).filter(str -> (str.equals("f") || str.equals("b") || str.equals("r") || str.equals("l")))
                .peek(str ->
                {
                    switch (str) {
                        case "f" -> System.out.println("Zwierzak idzie do przodu");
                        case "b" -> System.out.println("Zwierzak idzie do tyłu");
                        case "r" -> System.out.println("Zwierzak skręca w prawo");
                        default -> System.out.println("Zwierzak skręca w lewo");
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
