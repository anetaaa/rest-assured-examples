package com.testinglaboratory.testingbasics.exercises;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.*;
import com.github.javafaker.Faker;

import static org.junit.jupiter.api.Assertions.assertEquals;

/*TODO EXERCISE
 * - Create class Toy having fields: make, name, colour, material
 *  - having methods returning greeting (including name, colour and material)
 *  - create getters and setters
 *  - write tests that put a text file with toy data to a text file in a folder
 *  - use FileManager to operate on files
 *  - remember to prepare data
 *  - remember to clean up after tests
 */
@Slf4j
public class WholesomeExerciseTest {
    Toy toy;

    @BeforeAll
    public static void setupClass(){
        FileManager.createDirectory("toys");
    }

    @BeforeEach
    public void getToy() {
        String toyName = Faker.instance().name().name();
        String toyMake = Faker.instance().company().bs();
        String toyColor = Faker.instance().color().name();
        String toyMaterial = Faker.instance().commerce().material();
        toy = new Toy(toyMake, toyName, toyColor, toyMaterial);
        log.info(toy.greeting());                                 //log.info() zamiast sout -> loguje wszystko dzięki @Slf4j

    }

    @Test
    public void toyParametersShouldBeEquals() {
       // FileManager.createFile("first_toy");
        FileManager.writeToFileFile("toys/first_toy", toy.greeting());
        assertEquals(toy.greeting(),FileManager.readFile("toys/first_toy"));
    }

    @AfterEach
    public void removeToy(){
        FileManager.deleteFile("/toys/first_toy");
    }
    @AfterAll
    public static void clear(){
    FileManager.deleteFile("/toys");
    }
}
