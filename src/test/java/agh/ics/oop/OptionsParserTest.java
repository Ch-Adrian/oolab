package agh.ics.oop;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

public class OptionsParserTest {

    @Test
    public void testParse(){
        try {
            String[] str2 = new String[]{"r", "right", "f", "forward", "b",
                    "backward", "l", "left"};
            assertTrue(Arrays.equals(
                    new MoveDirection[]{MoveDirection.RIGHT, MoveDirection.RIGHT,
                            MoveDirection.FORWARD, MoveDirection.FORWARD,
                            MoveDirection.BACKWARD, MoveDirection.BACKWARD,
                            MoveDirection.LEFT, MoveDirection.LEFT},
                    OptionsParser.parse(str2)));

            String[] str1 = new String[]{"daf", "r", "a", "right", "dsfescs", "f", "123", "forward", "rtwp", "b", "89vasdv9a",
                    "backward", "flwe8sc", "l", "fsf", "left", "op"};
            assertTrue(Arrays.equals(
                    new MoveDirection[]{MoveDirection.RIGHT, MoveDirection.RIGHT,
                            MoveDirection.FORWARD, MoveDirection.FORWARD,
                            MoveDirection.BACKWARD, MoveDirection.BACKWARD,
                            MoveDirection.LEFT, MoveDirection.LEFT},
                    OptionsParser.parse(str1)));
        }
        catch( IllegalArgumentException ex){
            System.out.println(ex.getMessage());
        }
    }

}
