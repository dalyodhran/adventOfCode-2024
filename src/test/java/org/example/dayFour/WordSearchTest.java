package org.example.dayFour;

import org.example.util.FileReader;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

class WordSearchTest {

    @org.junit.jupiter.api.Test
    void search() throws IOException {
        WordSearch wordSearch = new WordSearch();
        String input = FileReader.readFile("src/test/java/org/example/dayFour/inputPartOne.txt");
        String[] lines = input.split("\n");
        char[][] wordSearchInput = new char[lines.length][];
        for (int i = 0; i < lines.length; i++) {
            wordSearchInput[i] = lines[i].toCharArray();
        }
        assertEquals(0, wordSearch.search(wordSearchInput));
    }

}