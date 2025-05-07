package org.example.daySix;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class FindGuardsPath {

    public int find(String input) {
        String[] lines = input.split("\n");
        char[][] map = new char[lines.length][lines[0].length()];
        int xStart = 0;
        int yStart = 0;
        String[] directions = {"up", "right", "down", "left"};
        HashMap<String, List<Integer>> moves = new HashMap<>() {
            {
                put("up", new ArrayList<>(List.of(-1, 0)));
                put("down", new ArrayList<>(List.of(1, 0)));
                put("right", new ArrayList<>(List.of(0, 1)));
                put("left", new ArrayList<>(List.of(0, -1)));
            }
        };

        for (int i = 0; i < lines.length; i++) {
            for (int j = 0; j < lines[i].length(); j++) {
                char temp = lines[i].charAt(j);
                if (temp == '^') {
                    xStart = i;
                    yStart = j;
                }
                map[i][j] = temp;
            }
        }

        int count = 0;
        int directionIndex = 0;
        String direction = directions[directionIndex];
        List<Integer> moveAxis = moves.get(direction);
        boolean escaped = false;

        while (!escaped) {
            xStart += moveAxis.getFirst();
            yStart += moveAxis.getLast();

            if (xStart < 0 || yStart < 0 || xStart > map.length - 1 || yStart > map[0].length - 1) {
                break;
            }

            char path =  map[xStart][yStart];

            while (path != '#') {
                if (path != 'x') {
                    count++;
                }
                map[xStart][yStart] = 'x';
                xStart += moveAxis.getFirst();
                yStart += moveAxis.getLast();

                if (xStart < 0 || yStart < 0 || xStart > map.length - 1 || yStart > map[0].length - 1) {
                    escaped = true;
                    break;
                }

                path =  map[xStart][yStart];
            }

            printGrid(map);
            xStart += moveAxis.getFirst() * -1;
            yStart += moveAxis.getLast() * -1;


            directionIndex++;
            if (directionIndex >= 4) {
                directionIndex = 0;
            }
            direction = directions[directionIndex];
            moveAxis = moves.get(direction);
        }

        return count;
    }

    public static void printGrid(char[][] grid) {
        for (char[] row : grid) {
            for (char c : row) {
                System.out.print(c + " ");
            }
            System.out.println();
        }
    }
}
