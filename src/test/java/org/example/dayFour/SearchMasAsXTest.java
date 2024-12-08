package org.example.dayFour;

import org.example.util.FileReader;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

class SearchMasAsXTest {

    @org.junit.jupiter.api.Test
    public void testSearch() throws IOException {
        SearchMasAsX searchMasAsX = new SearchMasAsX();
        String input = FileReader.readFile("src/test/java/org/example/dayFour/inputPartTwo.txt");
        String[] lines = input.split("\n");
        char[][] wordSearchInput = new char[lines.length][];
        for (int i = 0; i < lines.length; i++) {
            wordSearchInput[i] = lines[i].toCharArray();
        }
        assertEquals(0, searchMasAsX.search(wordSearchInput));
    }

}