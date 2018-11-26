package com.mdbk.wszib_oop.java.week_2;

import java.util.HashMap;

public class EmailStorage {

    private HashMap<Person, Integer> storage = new HashMap<>();

    public int howManyPersonsExist(Person person) {
        if (storage.containsKey(person)) {
            Integer currNum = storage.get(person);
            storage.put(person, currNum + 1);
            return currNum;
        } else {
            storage.put(person, 1);
            return 0;
        }
    }
}
