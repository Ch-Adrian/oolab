package agh.ics.oop;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

public class OptionsParserTest {

    @Test
    public void testParse(){
        String[] str1 = new String[]{"daf","r","a","right", "dsfescs", "f","123" ,"forward", "rtwp", "b","89vasdv9a",
                "backward", "flwe8sc", "l","fsf", "left", "op"};
        assertTrue(Arrays.equals(
                new MoveDirection[]{MoveDirection.RIGHT, MoveDirection.RIGHT,
                                           MoveDirection.FORWARD, MoveDirection.FORWARD,
                                            MoveDirection.BACKWARD, MoveDirection.BACKWARD,
                                                MoveDirection.LEFT, MoveDirection.LEFT},
                OptionsParser.parse(str1)));
    }

}
