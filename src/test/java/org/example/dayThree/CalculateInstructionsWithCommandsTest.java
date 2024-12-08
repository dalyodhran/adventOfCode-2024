package org.example.dayThree;

import org.example.util.FileReader;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

class CalculateInstructionsWithCommandsTest {

    @org.junit.jupiter.api.Test
    void calculate() throws IOException {
        CalculateInstructionsWithCommands calculateInstructionsWithCommands = new CalculateInstructionsWithCommands();
        String input = FileReader.readFile("src/test/java/org/example/dayThree/inputPartTwo.txt");

        assertEquals(0, calculateInstructionsWithCommands.calculate(input));
    }

}