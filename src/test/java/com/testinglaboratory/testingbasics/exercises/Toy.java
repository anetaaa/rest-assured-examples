package com.testinglaboratory.testingbasics.exercises;

import lombok.Getter;
import lombok.Setter;

import java.util.Optional;

@Getter
@Setter
public class Toy {
    private String make;
    private String name;
    private String colour;
    private String material;

    public Toy(String make, String name, String colour, String material) {
        this.make = make;
        this.name = name;
        this.colour = colour;
        this.material = material;
    }

    public String greeting() {
        String toyGreeting;
        toyGreeting = "Hello! I'm a toy. My name is " + getName() + " (make: " + getMake() + ", colour: " + getColour() +
                ", material: " + getMaterial() + ").";
        return toyGreeting;
    }
}