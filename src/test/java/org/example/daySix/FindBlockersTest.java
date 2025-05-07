package org.example.daySix;

import org.example.util.FileReader;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

class FindBlockersTest {

    @org.junit.jupiter.api.Test
    void find() throws IOException {
        FindBlockers findBlockers = new FindBlockers();
        String input = FileReader.readFile("src/test/java/org/example/daySix/input.txt");

        assertEquals(0, findBlockers.find(input));
    }

}