package org.example.daySix;

import org.example.util.FileReader;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

class FindGuardsPathTest {

    @org.junit.jupiter.api.Test
    void find() throws IOException {
        FindGuardsPath path = new FindGuardsPath();
        String input = FileReader.readFile("src/test/java/org/example/daySix/input.txt");

        assertEquals(0, path.find(input));
    }

}