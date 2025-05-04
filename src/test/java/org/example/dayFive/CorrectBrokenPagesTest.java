package org.example.dayFive;

import org.example.util.FileReader;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.*;

class CorrectBrokenPagesTest {

    @org.junit.jupiter.api.Test
    void find() throws IOException {
        CorrectBrokenPages correctBrokenPages = new CorrectBrokenPages();
        String[] precedenceRules = FileReader.readFile("src/test/java/org/example/dayFive/inputPartOneA.txt").split("\n");
        List<List<Integer>> listToOrder = new ArrayList<>();
        String[] lines = FileReader.readFile("src/test/java/org/example/dayFive/inputPartOneB.txt").split("\n");
        for (String line : lines) {
            List<Integer> list = Arrays.stream(line.split(","))
                    .map(Integer::parseInt)
                    .collect(Collectors.toList());
            listToOrder.add(list);
        }

        assertEquals(0, correctBrokenPages.find(listToOrder, precedenceRules));
    }

}