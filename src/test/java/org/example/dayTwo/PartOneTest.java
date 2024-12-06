package org.example.dayTwo;

import org.example.util.FileReader;

import java.io.IOException;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class PartOneTest {

    @org.junit.jupiter.api.Test
    void testPartOne() throws IOException {
        PartOne partOne = new PartOne();
        String input = FileReader.readFile("src/test/java/org/example/dayTwo/inputPartOne.txt");
        List<String> reports = List.of(input.split("\n"));

        assertEquals(0, partOne.getNumberOfSafeReports(reports));
    }

}