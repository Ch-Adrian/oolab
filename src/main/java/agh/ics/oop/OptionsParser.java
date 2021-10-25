package agh.ics.oop;

import java.util.ArrayList;
import java.util.Arrays;

public class OptionsParser {

    public static MoveDirection[] parse(String[] arr){

        MoveDirection[] moveDirections = new MoveDirection[arr.length];
        ArrayList<MoveDirection> arrayList = new ArrayList<>();
        int len = arr.length;
        for(int i = 0; i< len; i++){
            moveDirections[i] = switch (arr[i]) {
                case "f", "forward" -> MoveDirection.FORWARD;
                case "b", "backward" -> MoveDirection.BACKWARD;
                case "r", "right" -> MoveDirection.RIGHT;
                case "l", "left" -> MoveDirection.LEFT;
                default -> null;
            };
            if (moveDirections[i] == null){
                i-= 1;
                len -= 1;
            }
        }

        return Arrays.copyOfRange(moveDirections, 0, len-1);
    }

}
