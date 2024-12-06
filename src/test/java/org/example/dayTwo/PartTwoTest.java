package org.example.dayTwo;

import org.example.util.FileReader;

import java.io.IOException;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class PartTwoTest {

    @org.junit.jupiter.api.Test
    void testPartTwo() throws IOException {
        PartTwo partTwo = new PartTwo();
        String input = FileReader.readFile("src/test/java/org/example/dayTwo/inputPartTwo.txt");
        List<String> reports = List.of(input.split("\n"));

        assertEquals(0, partTwo.getNumberOfSafeReports(reports));
    }

}