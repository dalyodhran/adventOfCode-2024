package org.example.dayOne;

import org.example.util.FileReader;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class PartTwoTest {

    @org.junit.jupiter.api.Test
    public void testPartTwo() throws IOException {
        PartTwo partTwo = new PartTwo();
        String fileName = "src/test/java/org/example/dayOne/inputPartOne.txt";
        String locationId = FileReader.readFile(fileName);
        List<Integer> leftLocationId = new ArrayList<>();
        List<Integer> rightLocationId = new ArrayList<>();
        splitData(List.of(locationId.split("\n")), leftLocationId, rightLocationId);

        assertEquals(0, partTwo.scoreLocationId(leftLocationId, rightLocationId));
    }

    public void splitData(List<String> data, List<Integer> left, List<Integer> right) {
        for (String line : data) {
            String[] parts = line.split("\\s+");
            if (parts.length == 2) {
                left.add(Integer.parseInt(parts[0]));
                right.add(Integer.parseInt(parts[1]));
            }
        }
    }

}