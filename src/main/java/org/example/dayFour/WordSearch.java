package org.example.dayFour;

import java.util.ArrayList;
import java.util.List;

public class WordSearch {
    private static final String WORD = "XMAS";
    private static final int WORD_LENGTH = WORD.length();

    public static int[] computePrefixTable(String pattern) {
        int[] prefixTable = new int[pattern.length()];
        int j = 0;
        for (int i = 1; i < pattern.length(); i++) {
            while (j > 0 && pattern.charAt(i) != pattern.charAt(j)) {
                j = prefixTable[j - 1];
            }
            if (pattern.charAt(i) == pattern.charAt(j)) {
                j++;
            }
            prefixTable[i] = j;
        }
        return prefixTable;
    }

    public static int kmpSearch(String text, String pattern) {
        int[] prefixTable = computePrefixTable(pattern);
        int matches = 0;
        int j = 0;

        for (int i = 0; i < text.length(); i++) {
            while (j > 0 && text.charAt(i) != pattern.charAt(j)) {
                j = prefixTable[j - 1];
            }
            if (text.charAt(i) == pattern.charAt(j)) {
                j++;
            }
            if (j == pattern.length()) {
                matches++;
                j = prefixTable[j - 1];
            }
        }
        return matches;
    }

    public static List<String> extractDiagonals(char[][] grid, boolean isAntiDiagonal) {
        List<String> diagonals = new ArrayList<>();
        int rows = grid.length;
        int cols = grid[0].length;

        for (int d = 0; d < rows + cols - 1; d++) {
            StringBuilder sb = new StringBuilder();
            for (int row = 0; row < rows; row++) {
                int col = isAntiDiagonal ? d - row : d - (rows - row - 1);
                if (col >= 0 && col < cols) {
                    sb.append(grid[row][col]);
                }
            }
            if (sb.length() >= WORD_LENGTH) {
                diagonals.add(sb.toString());
            }
        }
        return diagonals;
    }

    public static int countOccurrences(char[][] grid) {
        int rows = grid.length;
        int cols = grid[0].length;
        int count = 0;

        for (int i = 0; i < rows; i++) {
            count += kmpSearch(new String(grid[i]), WORD);
            count += kmpSearch(new StringBuilder(new String(grid[i])).reverse().toString(), WORD);
        }

        for (int j = 0; j < cols; j++) {
            StringBuilder column = new StringBuilder();
            for (int i = 0; i < rows; i++) {
                column.append(grid[i][j]);
            }
            count += kmpSearch(column.toString(), WORD);
            count += kmpSearch(column.reverse().toString(), WORD);
        }

        List<String> diagonals = extractDiagonals(grid, false);
        for (String diagonal : diagonals) {
            count += kmpSearch(diagonal, WORD);
            count += kmpSearch(new StringBuilder(diagonal).reverse().toString(), WORD);
        }

        List<String> antiDiagonals = extractDiagonals(grid, true);
        for (String antiDiagonal : antiDiagonals) {
            count += kmpSearch(antiDiagonal, WORD);
            count += kmpSearch(new StringBuilder(antiDiagonal).reverse().toString(), WORD);
        }

        return count;
    }

    public int search(char[][] wordSearch) {
        return countOccurrences(wordSearch);
    }
}
