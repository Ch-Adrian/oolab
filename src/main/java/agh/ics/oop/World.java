package agh.ics.oop;

import java.util.ArrayList;
import java.util.Arrays;

public class World {

    public static void main(String[] args) {
        System.out.println("Start");
        run(change(args));
        System.out.println("Stop");
    }

    public static Direction[] change(String[] arr){
        Direction[] dir = new Direction[arr.length];

        int i = 0;
        for(String str: arr){
            switch (str) {
                case "f" -> dir[i] = Direction.FORWARD;
                case "b" -> dir[i] = Direction.BACKWARD;
                case "r" -> dir[i] = Direction.RIGHT;
                case "l" -> dir[i] = Direction.LEFT;
                default -> i--;
            }
            i++;
        }
        return Arrays.copyOfRange(dir, 0, i);
    }

    public static void run(Direction[] arr){
        System.out.println("Zwierzak idzie do przodu");

        for(Direction dir: arr){
            switch (dir) {
                case FORWARD -> System.out.println("Zwierzak idzie do przodu.");
                case BACKWARD -> System.out.println("Zwierzak idzie do tyłu");
                case RIGHT -> System.out.println("Zwierzak skręca w prawo");
                case LEFT -> System.out.println("Zwierzak skręca w lewo");
                default -> {
                }
            }
        }

        int cnt = 0;
        for(Direction str: arr){
            System.out.print(str);
            if(cnt != arr.length - 1){
                System.out.print(", ");
            }
            cnt++;
        }
        System.out.println();
    }

}
