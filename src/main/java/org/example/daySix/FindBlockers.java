package org.example.daySix;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class FindBlockers {

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

        return 0;
    }
}
