package com.testinglaboratory.testingbasics.exercises;

import com.testinglaboratory.testingbasics.examples.Me;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

/*TODO EXERCISE create tests checking:
   - number of letters in your first name
   - equality of length of your first and last name
   - equality of your first and last name
   - your first name having more than 3 letters
 */
public class BasicsExerciseTest {
    static Me me;

    @BeforeAll
    public static void myName() {
        me = new Me("Aneta", "Majewska");
    }

    @Test
    public void nameShouldBeEquals() {
        assertEquals(me.getName(), "Aneta");
    }

    @Test
    public void nameShouldHasFiveLetter() {
        assertEquals(5, me.getName());
    }

    @Test
    public void surnameShouldBeEquals() {
        assertEquals(me.getSurname(), "Majewska");
    }

    @Test
    public void equalityOfLengthFirstNameAndSurname() {
        assertTrue(me.getSurname().length() == me.getName().length());
    }

    @Test
    public void shouldBeMoreThanThreeLetters() {
        assertTrue(me.getName().length() > 3);
        //assertThat().isG
    }
}
