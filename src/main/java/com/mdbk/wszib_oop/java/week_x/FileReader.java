package com.mdbk.wszib_oop.java.week_x;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;

public class FileReader {

    public List<String> readFile() {
        File file = new File(getClass().getClassLoader().getResource("input").getFile());
        try (BufferedReader reader = Files.newBufferedReader(Paths.get(file.getAbsolutePath()), StandardCharsets.UTF_8)) {
            return reader.lines().collect(Collectors.toList());
        } catch (IOException e) {
            e.printStackTrace();
        }

        return null;
    }
}

// TODO create a class representing number with fields: top, middle, bottom, left1, left2, right1, right2
//  one class is responsible for sending only valid lines, means skip every forth line, to another class
//  that parses lines and creates SnannedNumber objects (9 of them)
//  Another class is responsible for converting those ScannedNumber objects into integers
