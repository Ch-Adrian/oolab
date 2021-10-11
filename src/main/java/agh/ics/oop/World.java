package agh.ics.oop;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class World {

    public static void main(String[] args) {
        System.out.println("Start");
        run(args);
        System.out.println("Stop");
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
