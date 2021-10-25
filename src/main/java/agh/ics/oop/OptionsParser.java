package agh.ics.oop;

import java.util.ArrayList;
import java.util.Arrays;

public class OptionsParser {

    public static MoveDirection[] parse(String[] arr){

        MoveDirection[] moveDirections = new MoveDirection[arr.length];

        int len = arr.length;
        int j = 0;
        for(int i = 0; i< len; i++, j++){
            moveDirections[j] = switch (arr[i]) {
                case "f", "forward" -> MoveDirection.FORWARD;
                case "b", "backward" -> MoveDirection.BACKWARD;
                case "r", "right" -> MoveDirection.RIGHT;
                case "l", "left" -> MoveDirection.LEFT;
                default -> null;
            };
            if (moveDirections[j] == null){
                j -= 1;
            }
        }

        return Arrays.copyOfRange(moveDirections, 0, j);
    }

}
