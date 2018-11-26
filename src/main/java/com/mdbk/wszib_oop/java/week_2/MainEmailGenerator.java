package com.mdbk.wszib_oop.java.week_2;

import java.util.Scanner;

public class MainEmailGenerator {

    // TODO write FileEmailStorage
    private static EmailGenerator generator = new EmailGenerator(new InMemoryEmailStorage());

    public static void main(String[] args) {
        // TODO wrap below logic into some class and test
        Scanner scanner = new Scanner(System.in);

        do {
            generateEmail(scanner);

            print("Do you want to generate another email? Y/N:  ");
        } while (scanner.next().equals("Y"));

        print("Thank you!");
    }

    private static void generateEmail(Scanner scanner) {
        print("Enter name: ");
        String name = scanner.next();

        print("Enter surname: ");
        String surname = scanner.next();

        String email = generator.generateEmail(new Person(name, surname));
        print("Email is : " + email);
    }

    private static void print(String printString) {
        System.out.println(printString);
    }
}
