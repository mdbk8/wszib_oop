package com.mdbk.wszib_oop.java.week_2;

public class EmailGenerator {

    private EmailStorage storage;

    public EmailGenerator(EmailStorage storage) {
        this.storage = storage;
    }

    public String generateEmail(Person person) {
        int numOfPersons = storage.howManyPersonsExist(person);
        String emailPostfix = "";

        if (numOfPersons > 0) emailPostfix = "" + numOfPersons;

        return person.getSurname().toLowerCase() + "." + person.getName().toLowerCase() + emailPostfix + "@mex.com";
    }
}
