package org.example.dayThree;

import org.example.util.FileReader;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

class CalculateInstructionsTest {

    @org.junit.jupiter.api.Test
    void calculate() throws IOException {
        CalculateInstructions calculateInstructions = new CalculateInstructions();
        String input = FileReader.readFile("src/test/java/org/example/dayThree/inputPartOne.txt");

        assertEquals(0, calculateInstructions.calculate(input));
    }

}