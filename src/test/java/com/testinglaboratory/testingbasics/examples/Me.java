package com.testinglaboratory.testingbasics.examples;

import lombok.Getter;
import lombok.Setter;

import java.util.Optional;

@Getter
@Setter
public class Me {
        private String name;
        private String surname;

        public Me(String name, String surname) {
            this.name = name;
            this.surname = surname;

        }
    }

