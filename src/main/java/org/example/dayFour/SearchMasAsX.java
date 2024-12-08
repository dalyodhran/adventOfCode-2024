package org.example.dayFour;

public class SearchMasAsX {
    public static final String PATTERN = "MAS";

    public int search(char[][] wordSearch) {
        return countXShapeOccurrences(wordSearch);
    }

    public int countXShapeOccurrences(char[][] wordSearch) {
        int rows = wordSearch.length;
        int cols = wordSearch[0].length;
        int count = 0;

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (matchesXShape(wordSearch, i, j)) {
                    count++;
                }
            }
        }
        return count;
    }

    public boolean matchesXShape(char[][] wordSearch, int x, int y) {
        int rows = wordSearch.length;
        int cols = wordSearch[0].length;

        if (x - 1 >= 0 && x + 1 < rows && y -1 >= 0 && y + 1 < cols) {
            return (wordSearch[x - 1][y - 1] == PATTERN.charAt(0) &&
                    wordSearch[x + 1][y + 1] == PATTERN.charAt(2) &&
                    wordSearch[x][y] == PATTERN.charAt(1) &&
                    wordSearch[x - 1][y + 1] == PATTERN.charAt(0) &&
                    wordSearch[x + 1][y - 1] == PATTERN.charAt(2))
                    ||
                    (wordSearch[x - 1][y - 1] == PATTERN.charAt(2) &&
                    wordSearch[x + 1][y + 1] == PATTERN.charAt(0) &&
                    wordSearch[x][y] == PATTERN.charAt(1) &&
                    wordSearch[x - 1][y + 1] == PATTERN.charAt(0) &&
                    wordSearch[x + 1][y - 1] == PATTERN.charAt(2))
                    ||
                    (wordSearch[x - 1][y - 1] == PATTERN.charAt(2) &&
                    wordSearch[x + 1][y + 1] == PATTERN.charAt(0) &&
                    wordSearch[x][y] == PATTERN.charAt(1) &&
                    wordSearch[x - 1][y + 1] == PATTERN.charAt(2) &&
                    wordSearch[x + 1][y - 1] == PATTERN.charAt(0))
                    ||
                    (wordSearch[x - 1][y - 1] == PATTERN.charAt(0) &&
                    wordSearch[x + 1][y + 1] == PATTERN.charAt(2) &&
                    wordSearch[x][y] == PATTERN.charAt(1) &&
                    wordSearch[x - 1][y + 1] == PATTERN.charAt(2) &&
                    wordSearch[x + 1][y - 1] == PATTERN.charAt(0));
        }

        return false;
    }
}
